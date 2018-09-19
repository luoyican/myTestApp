package com.rfchina.internet.mytestapp.http.http;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.rfchina.internet.mytestapp.http.ModelManager;
import com.rfchina.internet.mytestapp.http.entity.EntryWrapper;
import com.rfchina.internet.mytestapp.http.http.cookie.PersistentCookieStore;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.http.OkHeaders;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class HttpManager {
    private static HttpManager mHttpManager;
    private OkHttpClient mOkHttpClient;

    private static final String DEFAULT_ERROR_MSG = "当前网络异常，请检查后重试。";
    private static final String LOG_TAG = "xm_request";
    private Handler mainHandler;
    private ExecutorService threadPool;

    HttpManager() {
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setCookieHandler(new CookieManager(
                new PersistentCookieStore(ModelManager.getInstance().getAppContext()),
                CookiePolicy.ACCEPT_ALL));
        mOkHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        mOkHttpClient.setSslSocketFactory(OkHttpSSL.createSSLSocketFactory());
        mOkHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        mOkHttpClient.setWriteTimeout(60, TimeUnit.SECONDS);
        mainHandler = new Handler();
        threadPool = Executors.newSingleThreadExecutor();
    }

    public static HttpManager getInstance() {
        if (mHttpManager == null) {
            mHttpManager = new HttpManager();
        }
        return mHttpManager;
    }

//    public <T> void post(final String url, final HashMap<String, Object> hashMap,
//                         final OnResponseListener<T> onResponseListener, Object tag) {
//
//    }

    public <T> HttpCall postAysn(final String url, final HashMap<String, String> hashMap,
                                 final OnResponseListener<T> onResponseListener, Object tag) {
        final HttpRequest httpRequest = buildPostRequest(url, hashMap, tag);
        return requestAysn(url, httpRequest, onResponseListener);
    }


    public <T> HttpCall postFile(final String url, String fileName, File file,
                                 final OnResponseListener<T> onResponseListener, Object tag) {
        final HttpRequest httpRequest = buildPostFileRequest(url, fileName, file, tag);
        return requestAysn(url, httpRequest, onResponseListener);
    }

    public <T> HttpCall getAysn(final String url, final HashMap<String, String> hashMap,
                                final OnResponseListener<T> onResponseListener, Object tag) {
        final HttpRequest httpRequest = buildGetRequest(url, hashMap, tag);
        return requestAysn(url, httpRequest, onResponseListener);
    }

    private <T> HttpCall requestAysn(final String url, final HttpRequest httpRequest, final OnResponseListener<T> onResponseListener) {
        //设置cookie
        setCookie(httpRequest.getRequest());
        final Call call = mOkHttpClient.newCall(httpRequest.getRequest());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Request request, final IOException e) {
                if (call.isCanceled()) return;
                errorCallBack(DEFAULT_ERROR_MSG, DEFAULT_ERROR_MSG, onResponseListener);
            }

            @Override
            public void onResponse(final Response response) {
                try {
                    //保存cookie
                    mOkHttpClient.getCookieHandler().put(httpRequest.getRequest().uri(), OkHeaders.toMultimap(response.headers(), null));
                    final String body = response.body().string();
                    //log太长时分段打印
                    int maxLogSize = 3900;

                    Log.e(LOG_TAG, "=====onResponse=====\n" + httpRequest.getRequest().url() + "\n");
                    for (int i = 0; i <= body.length() / maxLogSize; i++) {

                        int start = i * maxLogSize;

                        int end = (i + 1) * maxLogSize;

                        end = end > body.length() ? body.length() : end;
                        if (i == 0) {
                            Log.i(LOG_TAG, "-----onResponse-----\n" + body.substring(start, end));
                        } else {
                            Log.i(LOG_TAG, "-----onResponse替换这一段-----" + body.substring(start, end));
                        }


                    }
                    if (call.isCanceled()) return;
                    Object object = JSON.parseObject(body, getSuperClassGenricType(onResponseListener.getClass(), 0), Feature.SupportNonPublicField);

                    final EntryWrapper entity = (EntryWrapper) object;
                    if (entity.isSuccess()) {
                        successCallBack(object, onResponseListener);
                    } else {
                        String errMsg = entity.getMessage();
                        if (!TextUtils.isEmpty(errMsg)) {
                            errorCallBack(body, entity.getStatus() + ":" + errMsg, onResponseListener);
                        } else {
                            String errorMsg = "服务器接口异常";
                            errorCallBack(errorMsg, errorMsg, onResponseListener);
                        }
                    }
                } catch (JSONException e) {
                    Log.e(LOG_TAG, "=====onFailure=====\n" + httpRequest.getRequest().urlString() + "\n-----error-----\n" + e.getMessage());
                    e.printStackTrace();
                    String errorMsg = "服务器数据解析异常";
                    errorCallBack(errorMsg, errorMsg, onResponseListener);
                } catch (Exception e) {
                    Log.e(LOG_TAG, "=====onFailure=====\n" + httpRequest.getRequest().urlString() + "\n-----error-----\n" + e.getMessage());
                    e.printStackTrace();
                    errorCallBack(DEFAULT_ERROR_MSG, DEFAULT_ERROR_MSG, onResponseListener);
                }

            }
        });
        HttpCall httpCall = new HttpCall();
        httpCall.setCall(call);
        return httpCall;
    }

    private void setCookie(Request request) {
        try {
            Request.Builder result = request.newBuilder();
            Map<String, List<String>> headers = OkHeaders.toMultimap(result.build().headers(), null);
            Map<String, List<String>> cookies = mOkHttpClient.getCookieHandler().get(request.uri(), headers);
            OkHeaders.addCookies(result, cookies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class HttpRequest {
        private Request request;
        private String postContent;

        public Request getRequest() {
            return request;
        }

        public void setRequest(Request request) {
            this.request = request;
        }

        public String getPostContent() {
            return postContent;
        }

        public void setPostContent(String postContent) {
            this.postContent = postContent;
        }
    }

    public String getTagStr(Object object) {
        if (object != null) {
            return object.toString();
        }
        return null;
    }

    private HttpRequest buildPostFileRequest(String url, String fileName, File file, Object tag) {
        HttpRequest httpRequest = new HttpRequest();
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        multipartBuilder.type(MultipartBuilder.FORM);
        multipartBuilder.addFormDataPart(fileName, file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        RequestBody requestBody = multipartBuilder.build();
        Request.Builder builder = new Request.Builder();
        builder.url(url).post(requestBody);
        if (!"".equals(tag) && tag != null) {
            builder.tag(getTagStr(tag));
        }
        httpRequest.setRequest(builder.build());
        return httpRequest;

    }

    private HttpRequest buildPostRequest(String url, HashMap<String, String> map, Object tag) {
        HttpRequest httpRequest = new HttpRequest();

        if (map == null) {
            map = new HashMap<>();
        }
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        for (String key : map.keySet()) {
            if (TextUtils.isEmpty(key)) continue;
            String value = map.get(key);
            if (value == null) continue;
            formEncodingBuilder.add(key, value);
            Log.d(LOG_TAG, key + ":" + value);
        }
        RequestBody requestBody = formEncodingBuilder.build();
        Request.Builder builder = new Request.Builder();
        builder.url(url).post(requestBody);
//        if (!TextUtils.isEmpty(DataManager.getInstance().getToken())) {
//            builder.header("authorization", "bearer " + DataManager.getInstance().getToken());
//        }
        if (!"".equals(tag) && tag != null) {
            builder.tag(getTagStr(tag));
        }
        httpRequest.setRequest(builder.build());
        return httpRequest;

    }

    private HttpRequest buildGetRequest(String url, HashMap<String, String> map, Object tag) {
        HttpRequest httpRequest = new HttpRequest();
        if (map == null) {
            map = new HashMap<>();
        }
        String getUrl = buildUrl(url, map);
        Request.Builder builder = new Request.Builder();
        builder.url(getUrl);
        if (!"".equals(tag) && tag != null) {
            builder.tag(getTagStr(tag));
        }
        httpRequest.setRequest(builder.build());
        return httpRequest;
    }

    private String buildUrl(String url, Map<String, String> map) {
        if (map == null || map.size() == 0) return url;
        String urlTail = "";
        for (String key : map.keySet()) {
            if (TextUtils.isEmpty(key)) continue;
            String value = "";
            try {
                value = URLEncoder.encode(map.get(key), "utf-8");
            } catch (Exception e) {
            }
            urlTail += "&" + key + "=" + value;
        }
        String urlHead = url.endsWith("?") ? url : url + "?";

        return urlHead + urlTail.substring(1);
    }

    private Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    private <T> void errorCallBack(final String errContent, final String errorMsg, final OnResponseListener<T> onResponseListener) {
        if (onResponseListener != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    onResponseListener.onErrorResponse(errContent, errorMsg);
                }
            });
        }


    }

    private <T> void successCallBack(final Object object, final OnResponseListener<T> onResponseListener) {
        if (onResponseListener != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    onResponseListener.onResponse((T) object);
                }
            });
        }

    }

    public void cancel(final Object tag) {
        ModelManager.getInstance().getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                mOkHttpClient.cancel(getTagStr(tag));
            }
        });

    }

    public void cleanCookies() {
        CookieManager cookieManager = (CookieManager) mOkHttpClient.getCookieHandler();
        cookieManager.getCookieStore().removeAll();
    }

}
