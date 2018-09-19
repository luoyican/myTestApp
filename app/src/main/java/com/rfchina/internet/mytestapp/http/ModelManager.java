package com.rfchina.internet.mytestapp.http;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.rfchina.internet.mytestapp.BuildConfig;
import com.rfchina.internet.mytestapp.http.http.RequestProvider;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ModelManager {
    private static ModelManager modelManager;
    private Context appContext;
    private Handler mainHandler;
    private ExecutorService threadPool;
    private boolean isDebug = BuildConfig.DEBUG;

    public static ModelManager getInstance() {
        if (modelManager == null) {
            modelManager = new ModelManager();
        }
        return modelManager;
    }

    public void init(Context appContext) {
        this.appContext = appContext;
        mainHandler = new Handler();
        threadPool = Executors.newFixedThreadPool(4);
        initImageLoader(appContext);
    }


    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public Handler getMainHandler() {
        return mainHandler;
    }

    public Context getAppContext() {
        return appContext;
    }

    public RequestProvider getRequestProvider() {
        return RequestProvider.getInstance();
    }


    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }



    /**
     * 初始化ImageLoader
     *
     * @param context
     */
    private void initImageLoader(Context context) {
        int MEM_CACHE_SIZE = 1024 * 1024 * ((ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass() / 8;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context).threadPriority(Thread.NORM_PRIORITY - 3)
                .memoryCache(new LruMemoryCache(MEM_CACHE_SIZE))
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .threadPoolSize(3).build();
        ImageLoader.getInstance().init(config);
    }
}
