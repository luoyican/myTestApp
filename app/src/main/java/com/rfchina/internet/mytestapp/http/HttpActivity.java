package com.rfchina.internet.mytestapp.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.rfchina.internet.mytestapp.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.List;

/**
 * Created by luoyican on 2018/7/31.
 */

public class HttpActivity extends Activity {
    TextView textView;
    TextView textView2;
    TextView textView3;


    private String jsonResult = "{\"eeGuid\":\"3DFF3057-E5A4-4B47-9637-1155F674B360\",\"startTime\":\"2018-07-31 17:04:49\",\"resultBeans\":[{\"eetGuid\":\"D196380E-A3BB-410B-92A5-2BC3F4083737\",\"resultItemBeans\":[{\"eetiGuid\":\"81E451B4-88F8-42C4-8ACF-B6479F29BCF8\",\"eetiTiGuid\":\"6CD7E040-0CD3-456C-9F3C-A81200CA1002\",\"resultVal\":\"82\"}]},{\"eetGuid\":\"A89B7D11-03E5-49F1-A2B3-38769944D578\",\"resultItemBeans\":[{\"eetiGuid\":\"1CC842E4-B7FA-492E-900B-70BDA209B432\",\"eetiTiGuid\":\"6A211282-F930-4A43-A8E0-A81200CA0FA4\",\"resultVal\":\"60\"}]},{\"eetGuid\":\"6B0CDCF1-BA18-43AE-A66B-C5C8A9830882\",\"resultItemBeans\":[]},{\"eetGuid\":\"0FCA7A86-CF3C-47F9-A61C-64FB9FB70E15\",\"resultItemBeans\":[]},{\"eetGuid\":\"62CB1CFC-FF22-47B8-B278-8F018845DD79\",\"resultItemBeans\":[]},{\"eetGuid\":\"518CA96E-AEF2-4B1A-9F80-368CCB535ACF\",\"resultItemBeans\":[]},{\"eetGuid\":\"81674AC8-710C-4CD0-9A29-ADDA76915D2A\",\"resultItemBeans\":[]},{\"eetGuid\":\"91FCB340-8885-4D2C-9893-4DFFE0C0BE5B\",\"resultItemBeans\":[]},{\"eetGuid\":\"83E2B847-AABC-426E-81C6-FDD711C7CAFD\",\"resultItemBeans\":[]},{\"eetGuid\":\"DA830D99-A131-4959-A8C2-B8C878BA8C35\",\"resultItemBeans\":[]},{\"eetGuid\":\"51002005-10CF-4D2B-B67F-33FDC91C8165\",\"resultItemBeans\":[]},{\"eetGuid\":\"8098ADDE-9979-4C41-8580-3CC760F8572D\",\"resultItemBeans\":[]},{\"eetGuid\":\"46374702-62BA-4D26-8F8C-55C95F3340DE\",\"resultItemBeans\":[]},{\"eetGuid\":\"6989395D-7FEB-4D70-818B-B7635DB996B2\",\"resultItemBeans\":[]},{\"eetGuid\":\"521185C7-EB29-4718-BDAC-6D3C8FBE7880\",\"resultItemBeans\":[]},{\"eetGuid\":\"AC1C6434-67A8-4A1C-A971-FB20FB2829E7\",\"resultItemBeans\":[]},{\"eetGuid\":\"47A71A72-19C5-4A09-89E0-FA9E01A06F21\",\"resultItemBeans\":[]},{\"eetGuid\":\"A206FC9B-8F35-40E5-9D6C-B8F689DB211D\",\"resultItemBeans\":[]},{\"eetGuid\":\"21473128-ED21-453A-9C12-A3A7798FB6CB\",\"resultItemBeans\":[]},{\"eetGuid\":\"A584A78E-8939-4C01-99EA-32C0679EB3CA\",\"resultItemBeans\":[]},{\"eetGuid\":\"D6B14D7F-6A77-44AF-956A-A63AD07712FC\",\"resultItemBeans\":[]},{\"eetGuid\":\"B96460CC-F898-4256-95B8-2F01810EC6F0\",\"resultItemBeans\":[]},{\"eetGuid\":\"6B56FBBD-3CE1-430B-B23E-5B6D0922F7D8\",\"resultItemBeans\":[]},{\"eetGuid\":\"DFCFD810-5ED3-4315-AC3A-68CE55AD0C58\",\"resultItemBeans\":[]},{\"eetGuid\":\"3D854AC0-0779-4837-AF9B-3141B5412E4E\",\"resultItemBeans\":[]},{\"eetGuid\":\"FFAD2D5A-D397-4415-8195-31A399C3309D\",\"resultItemBeans\":[]},{\"eetGuid\":\"DAFD844C-D133-4E22-B55D-B6CEEB10E8AE\",\"resultItemBeans\":[]},{\"eetGuid\":\"992D7744-EEBF-42A0-A1A6-404D3B823DF5\",\"resultItemBeans\":[]},{\"eetGuid\":\"3BBD796E-0404-4C31-BF23-0A795A5D9DC9\",\"resultItemBeans\":[]},{\"eetGuid\":\"17423175-FA83-4D2D-8F70-C36C7C3351E0\",\"resultItemBeans\":[]},{\"eetGuid\":\"B0F45F9F-14AA-4976-B5CD-548CE44FDF86\",\"resultItemBeans\":[]},{\"eetGuid\":\"618C4E1F-8113-4FA7-A0D2-01BEC8AE7D23\",\"resultItemBeans\":[]},{\"eetGuid\":\"F292E1EF-DE57-4242-A4F6-FCDC70F95121\",\"resultItemBeans\":[]},{\"eetGuid\":\"96A49963-52E4-4617-B3FC-A9686A9325E7\",\"resultItemBeans\":[]},{\"eetGuid\":\"D53FAB93-A60A-4585-B603-0905C5AC2A97\",\"resultItemBeans\":[]},{\"eetGuid\":\"1D63FAAD-1923-44CC-9C5A-847C7280CAD5\",\"resultItemBeans\":[]},{\"eetGuid\":\"B8485141-F2B5-4EF2-ACE1-8F09813B7BBD\",\"resultItemBeans\":[]},{\"eetGuid\":\"88456CB8-220C-488C-9747-6636E426AD57\",\"resultItemBeans\":[]},{\"eetGuid\":\"8C2F1318-3478-40FC-ADE4-46BF8ACE315E\",\"resultItemBeans\":[]},{\"eetGuid\":\"D32513E7-7532-4599-A636-D0C0A95A1592\",\"resultItemBeans\":[]},{\"eetGuid\":\"FEC43E50-D957-4815-AF42-B7E078B8F6B8\",\"resultItemBeans\":[]},{\"eetGuid\":\"510543EC-3B73-4749-8DB7-CC432F7E04D5\",\"resultItemBeans\":[]},{\"eetGuid\":\"0D64DBBC-A8F5-4CCD-89B0-FD16CFF32299\",\"resultItemBeans\":[]},{\"eetGuid\":\"127DEAE6-4496-41B7-8693-69110501A77F\",\"resultItemBeans\":[]},{\"eetGuid\":\"29FC6787-4271-4AD5-B162-D7F49E8B31F9\",\"resultItemBeans\":[]},{\"eetGuid\":\"4D6838FB-E9B6-4614-B4FC-30C2B1C86FF0\",\"resultItemBeans\":[]},{\"eetGuid\":\"F6B1FBE4-0F32-4AFF-8B16-CC0533D30955\",\"resultItemBeans\":[]},{\"eetGuid\":\"7BCD3B13-A4C4-4A25-94FE-42CC1190F7C8\",\"resultItemBeans\":[]},{\"eetGuid\":\"42592A39-2A90-4A4E-835E-9F4F76CFEA5A\",\"resultItemBeans\":[]},{\"eetGuid\":\"1C63AAF9-825F-4BFB-B337-69540DCB859D\",\"resultItemBeans\":[]},{\"eetGuid\":\"098E4C5E-D55B-42FE-ABFB-47D624ABEFFE\",\"resultItemBeans\":[]},{\"eetGuid\":\"95632502-DC65-47C5-B940-254CD3CD5968\",\"resultItemBeans\":[]},{\"eetGuid\":\"EA377B16-842E-4B99-ADB2-7FC5B01927C1\",\"resultItemBeans\":[]},{\"eetGuid\":\"2BFC06CA-C183-46BC-8E7A-255420F5C9CE\",\"resultItemBeans\":[]},{\"eetGuid\":\"B6D45D94-651E-4368-A46F-DA5F90A913F6\",\"resultItemBeans\":[]},{\"eetGuid\":\"F76B1BE8-E31E-432B-A162-1D3474FD868F\",\"resultItemBeans\":[]},{\"eetGuid\":\"FA321226-0D0F-415E-BCFE-261090E11460\",\"resultItemBeans\":[]},{\"eetGuid\":\"EBCFE1C5-B3A6-4D32-930D-39F005916EFC\",\"resultItemBeans\":[]},{\"eetGuid\":\"40309AA2-6929-45C8-85CF-63F3FE7E8431\",\"resultItemBeans\":[]},{\"eetGuid\":\"C4085D95-13B8-4BB6-9736-6F71CF54837C\",\"resultItemBeans\":[]},{\"eetGuid\":\"A9A1948B-DF0F-422F-88A4-A1E9CAA657AD\",\"resultItemBeans\":[]},{\"eetGuid\":\"9CF1D0A9-C895-4845-B96C-B8E4A3CB792A\",\"resultItemBeans\":[]},{\"eetGuid\":\"40101660-CBB0-42E4-A497-555BED413167\",\"resultItemBeans\":[]},{\"eetGuid\":\"AD494D2A-04EC-4212-850D-205A4A080928\",\"resultItemBeans\":[]},{\"eetGuid\":\"BDA7B3E7-2E3B-4B27-9ECE-5267E3C6B477\",\"resultItemBeans\":[]},{\"eetGuid\":\"1F7D8BC8-6C94-494E-A4C5-52EE20CE548B\",\"resultItemBeans\":[]},{\"eetGuid\":\"CC8BBD33-ACBD-4E1D-A34D-11BE82D5F15A\",\"resultItemBeans\":[]},{\"eetGuid\":\"FFF7DD3D-64BB-4D65-BE77-F69A9E07FB3D\",\"resultItemBeans\":[]},{\"eetGuid\":\"61BDD995-CE8A-4EEC-B54A-03F635DE0BA2\",\"resultItemBeans\":[]},{\"eetGuid\":\"FDBBA0B8-F3AC-4918-8F46-F9FBC970A4C4\",\"resultItemBeans\":[]},{\"eetGuid\":\"213C6B19-EC0E-4C1B-84FD-7D3EF8E04C0D\",\"resultItemBeans\":[]},{\"eetGuid\":\"4F74D16E-E515-414E-BE2F-C35A4F7BC39A\",\"resultItemBeans\":[]},{\"eetGuid\":\"AECABED9-1D5A-477F-9263-10F8CF5E9CD7\",\"resultItemBeans\":[]},{\"eetGuid\":\"79003760-3425-4024-A207-5C70926288BE\",\"resultItemBeans\":[]},{\"eetGuid\":\"851AFDA4-C4AA-4947-8A67-94582A603BCD\",\"resultItemBeans\":[]},{\"eetGuid\":\"88E20DB4-C297-4E47-A4ED-64847BBA0184\",\"resultItemBeans\":[]},{\"eetGuid\":\"C0CD5895-B5E7-47E0-8F5D-B11FA8190BE3\",\"resultItemBeans\":[]},{\"eetGuid\":\"B4C40231-797A-4A8F-A695-D1676361E2FC\",\"resultItemBeans\":[]},{\"eetGuid\":\"ED4C9C1C-E218-44FB-B24A-15C27CD8A375\",\"resultItemBeans\":[]},{\"eetGuid\":\"908C11E4-BE78-47CC-93D8-49629CCA537F\",\"resultItemBeans\":[]},{\"eetGuid\":\"20489B6E-2B6A-429C-853C-4E1145A1633A\",\"resultItemBeans\":[]},{\"eetGuid\":\"DA9F4672-6390-492A-AD95-6F424BDF4D61\",\"resultItemBeans\":[]},{\"eetGuid\":\"57DD3E23-032F-48EE-B30D-4E4CDAB4FD04\",\"resultItemBeans\":[]},{\"eetGuid\":\"5717CF35-61BA-4219-9306-8D88AEFCF980\",\"resultItemBeans\":[]},{\"eetGuid\":\"FF2CB132-BF88-4313-8034-FB3C8F2BA0EF\",\"resultItemBeans\":[]},{\"eetGuid\":\"89BA7BC5-F378-49C9-8F46-98E7C81B09B7\",\"resultItemBeans\":[]},{\"eetGuid\":\"FE3E4B0B-6381-49F0-B6A0-DEB550A3EC62\",\"resultItemBeans\":[]},{\"eetGuid\":\"76EEABBE-2742-4C1B-958E-4A8F23B858B3\",\"resultItemBeans\":[]},{\"eetGuid\":\"BA2D4E5A-AD03-4FFB-9492-66532CC1BB29\",\"resultItemBeans\":[]},{\"eetGuid\":\"8F593F68-B2D5-417B-B7C4-51CE9E498AC7\",\"resultItemBeans\":[]},{\"eetGuid\":\"64162FA6-CB82-4E75-A33A-5AF32F3FCE56\",\"resultItemBeans\":[]},{\"eetGuid\":\"2C901D5D-FC94-4366-A744-E0225EA8DED2\",\"resultItemBeans\":[]},{\"eetGuid\":\"4B920DF3-BA19-40DC-8B25-6D837485215C\",\"resultItemBeans\":[]},{\"eetGuid\":\"07A52907-51AB-405F-8F25-AC247194EA36\",\"resultItemBeans\":[]},{\"eetGuid\":\"2A2ECEC1-D235-48CF-B255-AF505248F3B8\",\"resultItemBeans\":[]},{\"eetGuid\":\"E041DA07-C086-4FE5-BF44-7D32397AACA7\",\"resultItemBeans\":[]},{\"eetGuid\":\"5D2248EE-CD16-42AD-ADA7-A4490DB2F7A2\",\"resultItemBeans\":[]},{\"eetGuid\":\"5353C4A4-CFE0-4BCC-B3B0-375F9F8A0D4D\",\"resultItemBeans\":[]},{\"eetGuid\":\"246909E1-DE86-4FF4-8E5B-6CCE246E0451\",\"resultItemBeans\":[]},{\"eetGuid\":\"31052D4A-27DF-4942-8159-92C4CBDA4B0B\",\"resultItemBeans\":[]}],\"empGuid\":\"2A61CA17-4DE1-48D4-824B-EF858BB8725B\",\"systemVersion\":\"11.4.1\",\"channelCode\":\"30\",\"model\":\"iPhone7,2\",\"clientVersion\":\"4.0\",\"systemType\":\"IOS\",\"imei\":\"98AE1C81C48B728466D87F6F33F2631E\"}";

    private Handler handler = new Handler();
    private GetExamTopicListBean getExamTopicListBean;
    private SetExamResultBean mSetExamResultBean;
    private GetExamResultBean mGetExamResultBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://tapi.guanjia.thinkinpower.net/rfInf/getExamTopicList.shtml";
                        String json = "{\n" +
                                "\"channelCode\":\"30\",\n" +
                                "\"clientVersion\":\"4.0\",\n" +
                                "\"eeGuid\":3DFF3057-E5A4-4B47-9637-1155F674B360,\n" +
                                "\"empGuid\":2A61CA17-4DE1-48D4-824B-EF858BB8725B,\n" +
                                "\"imei\":\"98AE1C81C48B728466D87F6F33F2631E\",\n" +
                                "\"model\":\"iPhone9.1\",\n" +
                                "\"systemType\":\"IOS\",\n" +
                                "\"systemVersion\":\"11.4\"\n" +
                                "}";
                        String respone = postJsonRespone(url, json);
                        if (respone != null && respone != "") {
                            try {
                                getExamTopicListBean = JSON.parseObject(respone, GetExamTopicListBean.class, Feature.SupportNonPublicField);
                            } catch (Exception e) {

                            }
                        }
                    }
                }).start();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://tapi.guanjia.thinkinpower.net/rfInf/examResultCommit.shtml";
//                        String json = JSON.toJSONString(mSetExamResultBean);
                        String respone = postJsonRespone(url, jsonResult);
                        if (respone != null && respone != "") {
                            try {
                                mGetExamResultBean = JSON.parseObject(respone, GetExamResultBean.class, Feature.SupportNonPublicField);
                            } catch (Exception e) {

                            }
                        }
                    }
                }).start();
            }
        });
    }


    /**
     * json请求
     */
    private String postJsonRespone(String url, String json) {
        MediaType jsonType = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(jsonType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();//只能用一次response。body()
                setText(responseBody + "");
                return responseBody;
            } else {
                setText(response + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setText(final String msg) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView3.setText(msg);
            }
        });
    }


    /**
     * 接口返回基础类
     */
    public static class Bean {
        private String code;
        private String content;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    /**
     * 考试题目返回数据结构
     */
    public static class GetExamTopicListBean extends Bean {

        private List<ExamExampleTopicBean> examTopics;

        public List<ExamExampleTopicBean> getExamTopics() {
            return examTopics;
        }

        public void setExamTopics(List<ExamExampleTopicBean> examTopics) {
            this.examTopics = examTopics;
        }

        public static class ExamExampleTopicBean {
            /**
             * topicBean : {"eetAutoId":18190,"eetGuid":"8F593F68-B2D5-417B-B7C4-51CE9E498AC7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"284、正确答案是41、69","eetScore":1}
             * topicItemBeans : [{"eetiAutoId":60589,"eetiGuid":"E0673DB2-D13C-4A97-9FB9-A4D64E665330","eetiTiGuid":"0B6E8213-2A86-4B34-A7A0-A81200CA106E","eetiTiName":"41","eetiTiIsCorrect":1},{"eetiAutoId":60590,"eetiGuid":"E85DA4D4-7A53-45B6-8F52-AA7FF110BC31","eetiTiGuid":"60929BF0-F648-4947-AAE5-A81200CA106E","eetiTiName":"69","eetiTiIsCorrect":1},{"eetiAutoId":60591,"eetiGuid":"7B014BA2-8FF1-4299-A47A-01CDC5C97502","eetiTiGuid":"8D426E23-CB96-4DCB-9883-A81200CA106E","eetiTiName":"105","eetiTiIsCorrect":-1},{"eetiAutoId":60592,"eetiGuid":"7F74F28C-DD43-4831-BB41-F1B8189DF59E","eetiTiGuid":"D8A075FD-C40A-4D74-A2A7-A81200CA106E","eetiTiName":"125","eetiTiIsCorrect":-1}]
             */

            private ExamTopicBean topicBean;
            private List<ExamTopicItemBean> topicItemBeans;

            public ExamTopicBean getTopicBean() {
                return topicBean;
            }

            public void setTopicBean(ExamTopicBean topicBean) {
                this.topicBean = topicBean;
            }

            public List<ExamTopicItemBean> getTopicItemBeans() {
                return topicItemBeans;
            }

            public void setTopicItemBeans(List<ExamTopicItemBean> topicItemBeans) {
                this.topicItemBeans = topicItemBeans;
            }

            public static class ExamTopicBean {
                /**
                 * eetAutoId : 18190
                 * eetGuid : 8F593F68-B2D5-417B-B7C4-51CE9E498AC7
                 * eetTtName : 不定项
                 * eetTtType : checkbox
                 * eetTName : 284、正确答案是41、69
                 * eetScore : 1
                 */

                private int eetAutoId;
                private String eetGuid;
                private String eetTtName;
                private String eetTtType;
                private String eetTName;
                private int eetScore;

                public int getEetAutoId() {
                    return eetAutoId;
                }

                public void setEetAutoId(int eetAutoId) {
                    this.eetAutoId = eetAutoId;
                }

                public String getEetGuid() {
                    return eetGuid;
                }

                public void setEetGuid(String eetGuid) {
                    this.eetGuid = eetGuid;
                }

                public String getEetTtName() {
                    return eetTtName;
                }

                public void setEetTtName(String eetTtName) {
                    this.eetTtName = eetTtName;
                }

                public String getEetTtType() {
                    return eetTtType;
                }

                public void setEetTtType(String eetTtType) {
                    this.eetTtType = eetTtType;
                }

                public String getEetTName() {
                    return eetTName;
                }

                public void setEetTName(String eetTName) {
                    this.eetTName = eetTName;
                }

                public int getEetScore() {
                    return eetScore;
                }

                public void setEetScore(int eetScore) {
                    this.eetScore = eetScore;
                }
            }

            public static class ExamTopicItemBean {
                /**
                 * eetiAutoId : 60589
                 * eetiGuid : E0673DB2-D13C-4A97-9FB9-A4D64E665330
                 * eetiTiGuid : 0B6E8213-2A86-4B34-A7A0-A81200CA106E
                 * eetiTiName : 41
                 * eetiTiIsCorrect : 1
                 */

                private int eetiAutoId;
                private String eetiGuid;
                private String eetiTiGuid;
                private String eetiTiName;
                private int eetiTiIsCorrect;

                public int getEetiAutoId() {
                    return eetiAutoId;
                }

                public void setEetiAutoId(int eetiAutoId) {
                    this.eetiAutoId = eetiAutoId;
                }

                public String getEetiGuid() {
                    return eetiGuid;
                }

                public void setEetiGuid(String eetiGuid) {
                    this.eetiGuid = eetiGuid;
                }

                public String getEetiTiGuid() {
                    return eetiTiGuid;
                }

                public void setEetiTiGuid(String eetiTiGuid) {
                    this.eetiTiGuid = eetiTiGuid;
                }

                public String getEetiTiName() {
                    return eetiTiName;
                }

                public void setEetiTiName(String eetiTiName) {
                    this.eetiTiName = eetiTiName;
                }

                public int getEetiTiIsCorrect() {
                    return eetiTiIsCorrect;
                }

                public void setEetiTiIsCorrect(int eetiTiIsCorrect) {
                    this.eetiTiIsCorrect = eetiTiIsCorrect;
                }
            }
        }
    }


    /**
     * 考试提交答案数据结构
     */
    public static class SetExamResultBean {
        private String eeGuid;
        private String startTime;
        private String imei;
        private String model;
        private String channelCode;
        private String clientVersion;
        private String systemVersion;
        private String systemType;
        private String empGuid;
        private List<ExamResultBean> resultBeans;

        public String getEeGuid() {
            return eeGuid;
        }

        public void setEeGuid(String eeGuid) {
            this.eeGuid = eeGuid;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getChannelCode() {
            return channelCode;
        }

        public void setChannelCode(String channelCode) {
            this.channelCode = channelCode;
        }

        public String getClientVersion() {
            return clientVersion;
        }

        public void setClientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
        }

        public String getSystemVersion() {
            return systemVersion;
        }

        public void setSystemVersion(String systemVersion) {
            this.systemVersion = systemVersion;
        }

        public String getSystemType() {
            return systemType;
        }

        public void setSystemType(String systemType) {
            this.systemType = systemType;
        }

        public String getEmpGuid() {
            return empGuid;
        }

        public void setEmpGuid(String empGuid) {
            this.empGuid = empGuid;
        }

        public List<ExamResultBean> getResultBeans() {
            return resultBeans;
        }

        public void setResultBeans(List<ExamResultBean> resultBeans) {
            this.resultBeans = resultBeans;
        }

        public static class ExamResultBean {
            private String eetGuid;
            private ExamResultItemBean resultItemBeans;

            public String getEetGuid() {
                return eetGuid;
            }

            public void setEetGuid(String eetGuid) {
                this.eetGuid = eetGuid;
            }

            public ExamResultItemBean getResultItemBeans() {
                return resultItemBeans;
            }

            public void setResultItemBeans(ExamResultItemBean resultItemBeans) {
                this.resultItemBeans = resultItemBeans;
            }

            public static class ExamResultItemBean {
                private String eetiGuid;
                private String eetiTiGuid;
                private String resultVal;

                public String getEetiGuid() {
                    return eetiGuid;
                }

                public void setEetiGuid(String eetiGuid) {
                    this.eetiGuid = eetiGuid;
                }

                public String getEetiTiGuid() {
                    return eetiTiGuid;
                }

                public void setEetiTiGuid(String eetiTiGuid) {
                    this.eetiTiGuid = eetiTiGuid;
                }

                public String getResultVal() {
                    return resultVal;
                }

                public void setResultVal(String resultVal) {
                    this.resultVal = resultVal;
                }
            }
        }
    }

    /**
     * 提交答案返回数据结构
     */
    public static class GetExamResultBean {
        /**
         * allScore : 100
         * myScore : 0
         * isPass : -1
         * isPassMsg : 抱歉，考试未能通过
         * eeName : 测试培训
         * finishCount : 100
         * useTime : 0:33:32
         * speed : 20.12秒/题
         * rightCount : 0
         * errorCount : 100
         * resultBeans : [{"topicBean":{"eetAutoId":18173,"eetGuid":"D196380E-A3BB-410B-92A5-2BC3F4083737","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"267、正确答案是27、82、108、181","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60521,"eetiGuid":"2C7F872F-8A14-49C9-9143-1244C9546AB8","eetiTiName":"27","eetiTiIsCorrect":1},{"eetiAutoId":60522,"eetiGuid":"81E451B4-88F8-42C4-8ACF-B6479F29BCF8","eetiTiName":"82","eetiTiIsCorrect":1},{"eetiAutoId":60523,"eetiGuid":"62AD6193-C5D6-4B9D-A6EE-B1C29A90FAB9","eetiTiName":"108","eetiTiIsCorrect":1},{"eetiAutoId":60524,"eetiGuid":"D5E07BD0-DD98-48B0-BCCC-36EC44993D01","eetiTiName":"181","eetiTiIsCorrect":1}],"resultItemBeans":[{"eetiGuid":"81E451B4-88F8-42C4-8ACF-B6479F29BCF8","eetiTiGuid":"6CD7E040-0CD3-456C-9F3C-A81200CA1002","resultVal":"82"}]},{"topicBean":{"eetAutoId":18158,"eetGuid":"A89B7D11-03E5-49F1-A2B3-38769944D578","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"252、正确答案是36、74、190","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60461,"eetiGuid":"76257F22-04FB-47BC-BE8B-0D7CDF350D5B","eetiTiName":"36","eetiTiIsCorrect":1},{"eetiAutoId":60462,"eetiGuid":"1CC842E4-B7FA-492E-900B-70BDA209B432","eetiTiName":"60","eetiTiIsCorrect":-1},{"eetiAutoId":60463,"eetiGuid":"0BF76CCB-7F97-425D-8A93-4AE02131EC41","eetiTiName":"74","eetiTiIsCorrect":1},{"eetiAutoId":60464,"eetiGuid":"05E72671-6C37-4ED4-950B-585DBC0490CF","eetiTiName":"190","eetiTiIsCorrect":1}],"resultItemBeans":[{"eetiGuid":"1CC842E4-B7FA-492E-900B-70BDA209B432","eetiTiGuid":"6A211282-F930-4A43-A8E0-A81200CA0FA4","resultVal":"60"}]},{"topicBean":{"eetAutoId":18146,"eetGuid":"6B0CDCF1-BA18-43AE-A66B-C5C8A9830882","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"240、正确答案是5","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60413,"eetiGuid":"A1D884E5-0600-4AFB-B60D-D6991B7A788A","eetiTiName":"5","eetiTiIsCorrect":1},{"eetiAutoId":60414,"eetiGuid":"6B8952BC-9A65-40A9-A0E5-B676BE596A35","eetiTiName":"54","eetiTiIsCorrect":-1},{"eetiAutoId":60415,"eetiGuid":"BF78B686-9EFC-403C-A52A-7AF011BA6CE7","eetiTiName":"139","eetiTiIsCorrect":-1},{"eetiAutoId":60416,"eetiGuid":"1489C827-FC6F-43D1-9E79-0A941070033B","eetiTiName":"150","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18137,"eetGuid":"0FCA7A86-CF3C-47F9-A61C-64FB9FB70E15","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"231、正确答案是26、114、174","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60377,"eetiGuid":"3937AB15-4F96-4693-8B14-B4898C81E6B4","eetiTiName":"26","eetiTiIsCorrect":1},{"eetiAutoId":60378,"eetiGuid":"5955E0C9-A61E-42A8-93ED-6D2F7914C87F","eetiTiName":"41","eetiTiIsCorrect":-1},{"eetiAutoId":60379,"eetiGuid":"27282426-B7B9-4A9D-970C-6742F6645758","eetiTiName":"114","eetiTiIsCorrect":1},{"eetiAutoId":60380,"eetiGuid":"C346646D-99EF-4F90-BA1B-41D7E8ED4C3D","eetiTiName":"174","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18108,"eetGuid":"62CB1CFC-FF22-47B8-B278-8F018845DD79","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"202、正确答案是75、101","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60261,"eetiGuid":"C30C44C3-71D4-470A-9D50-78F768832E85","eetiTiName":"36","eetiTiIsCorrect":-1},{"eetiAutoId":60262,"eetiGuid":"8706545A-1487-4103-BCB6-BFAB1C4D1F5A","eetiTiName":"75","eetiTiIsCorrect":1},{"eetiAutoId":60263,"eetiGuid":"9C66299E-75CA-49FF-A607-52FDD357F25D","eetiTiName":"101","eetiTiIsCorrect":1},{"eetiAutoId":60264,"eetiGuid":"67A53132-7DF9-4B69-A07A-2CDCBF728165","eetiTiName":"172","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18130,"eetGuid":"518CA96E-AEF2-4B1A-9F80-368CCB535ACF","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"224、正确答案是31","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60349,"eetiGuid":"B6980DB8-9233-41FF-89A5-C476C02EA8DC","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60350,"eetiGuid":"2F5584D9-A15F-411C-927E-37C499A735CA","eetiTiName":"96","eetiTiIsCorrect":-1},{"eetiAutoId":60351,"eetiGuid":"34CAE21D-2EB0-41D1-BDD2-F8C718CF9E36","eetiTiName":"126","eetiTiIsCorrect":-1},{"eetiAutoId":60352,"eetiGuid":"CBA79E6D-41C6-4028-BA60-E61B1C8670E4","eetiTiName":"197","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18203,"eetGuid":"81674AC8-710C-4CD0-9A29-ADDA76915D2A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"297、正确答案是23、31、46","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60641,"eetiGuid":"8988B251-D58C-4673-9094-868C1700FCF1","eetiTiName":"23","eetiTiIsCorrect":1},{"eetiAutoId":60642,"eetiGuid":"989C4316-5159-4FFD-8061-DC5687024EA7","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60643,"eetiGuid":"DB066178-460C-4671-AF2D-6B5A71FE727D","eetiTiName":"46","eetiTiIsCorrect":1},{"eetiAutoId":60644,"eetiGuid":"A81577D4-261D-4783-8575-1967821E00D5","eetiTiName":"79","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18196,"eetGuid":"91FCB340-8885-4D2C-9893-4DFFE0C0BE5B","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"290、正确答案是31","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60613,"eetiGuid":"91EF5A90-F4BA-4533-ACC8-889282608C6F","eetiTiName":"9","eetiTiIsCorrect":-1},{"eetiAutoId":60614,"eetiGuid":"D103C59E-7E91-4425-9246-2E08ACB489DD","eetiTiName":"35","eetiTiIsCorrect":-1},{"eetiAutoId":60615,"eetiGuid":"93730FB6-F137-4109-A0D2-95972743D86D","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60616,"eetiGuid":"A7125DC5-6F42-4D05-9940-4FF1B894E608","eetiTiName":"168","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18136,"eetGuid":"83E2B847-AABC-426E-81C6-FDD711C7CAFD","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"230、正确答案是84","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60373,"eetiGuid":"E6F28564-B1E1-42E8-9D1E-CC6D1FE2E587","eetiTiName":"31","eetiTiIsCorrect":-1},{"eetiAutoId":60374,"eetiGuid":"25D6A881-6A1B-422C-92DD-4D147275C572","eetiTiName":"44","eetiTiIsCorrect":-1},{"eetiAutoId":60375,"eetiGuid":"CFEB2492-943C-427A-BF05-92388E76395C","eetiTiName":"48","eetiTiIsCorrect":-1},{"eetiAutoId":60376,"eetiGuid":"E7790954-AA50-4171-B511-D57FE13DF0D1","eetiTiName":"84","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18160,"eetGuid":"DA830D99-A131-4959-A8C2-B8C878BA8C35","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"254、正确答案是5、152","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60469,"eetiGuid":"1EA26981-0688-4BFF-95FF-468B8CCEA837","eetiTiName":"5","eetiTiIsCorrect":1},{"eetiAutoId":60470,"eetiGuid":"17553ADD-A920-467E-AD63-35CB116859B8","eetiTiName":"35","eetiTiIsCorrect":-1},{"eetiAutoId":60471,"eetiGuid":"694D184B-F537-45A1-BA84-B7E3D6AB0639","eetiTiName":"143","eetiTiIsCorrect":-1},{"eetiAutoId":60472,"eetiGuid":"87E1C72C-8587-4424-A381-0E6C93A11A7F","eetiTiName":"152","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18167,"eetGuid":"51002005-10CF-4D2B-B67F-33FDC91C8165","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"261、正确答案是64、82、184","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60497,"eetiGuid":"5606F049-2B35-43B5-9300-C95C912F6144","eetiTiName":"29","eetiTiIsCorrect":-1},{"eetiAutoId":60498,"eetiGuid":"F276C72F-77B6-4855-8227-F918FFFE75C0","eetiTiName":"64","eetiTiIsCorrect":1},{"eetiAutoId":60499,"eetiGuid":"A3B75FF3-9F61-4E6F-A635-BEF549B1B740","eetiTiName":"82","eetiTiIsCorrect":1},{"eetiAutoId":60500,"eetiGuid":"A00B6E01-68A5-49AA-B348-F5D76B344674","eetiTiName":"184","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18128,"eetGuid":"8098ADDE-9979-4C41-8580-3CC760F8572D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"222、正确答案是23、120","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60341,"eetiGuid":"D22C92E4-D9AB-4EBB-B623-7B76C5586BFC","eetiTiName":"23","eetiTiIsCorrect":1},{"eetiAutoId":60342,"eetiGuid":"AC894C34-B023-4897-8615-8EF7613C7F6D","eetiTiName":"59","eetiTiIsCorrect":-1},{"eetiAutoId":60343,"eetiGuid":"B424B718-9ADD-4D58-9FE9-F8E91A63A975","eetiTiName":"105","eetiTiIsCorrect":-1},{"eetiAutoId":60344,"eetiGuid":"9366972C-FBB0-4F64-BB84-FEFF0F7E6518","eetiTiName":"120","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18109,"eetGuid":"46374702-62BA-4D26-8F8C-55C95F3340DE","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"203、正确答案是69、105、151","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60265,"eetiGuid":"68939437-DBAD-44C4-B67C-2F7B91E53E29","eetiTiName":"23","eetiTiIsCorrect":-1},{"eetiAutoId":60266,"eetiGuid":"0A6B2936-56A8-4670-B383-4407F9666163","eetiTiName":"69","eetiTiIsCorrect":1},{"eetiAutoId":60267,"eetiGuid":"AF2ECB0C-1645-48F9-A126-D748E89600FA","eetiTiName":"105","eetiTiIsCorrect":1},{"eetiAutoId":60268,"eetiGuid":"0E9A8C19-46BE-4358-94C1-B4DC298715FF","eetiTiName":"151","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18201,"eetGuid":"6989395D-7FEB-4D70-818B-B7635DB996B2","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"295、正确答案是23、113","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60633,"eetiGuid":"D8010B8B-3FAB-4CA9-8B66-C0C362D15D8B","eetiTiName":"23","eetiTiIsCorrect":1},{"eetiAutoId":60634,"eetiGuid":"43125C90-BCC9-4D6E-945D-29E30ACE2F5F","eetiTiName":"67","eetiTiIsCorrect":-1},{"eetiAutoId":60635,"eetiGuid":"CB0B44C7-AAD7-402F-8CDE-BB1B4BB6649C","eetiTiName":"113","eetiTiIsCorrect":1},{"eetiAutoId":60636,"eetiGuid":"C60E680E-127A-4621-99B1-865C6EC85949","eetiTiName":"148","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18107,"eetGuid":"521185C7-EB29-4718-BDAC-6D3C8FBE7880","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"201、正确答案是27、49、65","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60257,"eetiGuid":"C1956D42-7777-4808-8E0D-600000F68010","eetiTiName":"27","eetiTiIsCorrect":1},{"eetiAutoId":60258,"eetiGuid":"4D103EB8-993E-4C9D-99F8-CEC014887426","eetiTiName":"49","eetiTiIsCorrect":1},{"eetiAutoId":60259,"eetiGuid":"0AD331E6-7635-4E6A-B900-37CBD0527B24","eetiTiName":"65","eetiTiIsCorrect":1},{"eetiAutoId":60260,"eetiGuid":"1B9C02ED-3DB0-4FE0-B4DB-0A5EB4A4358E","eetiTiName":"110","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18113,"eetGuid":"AC1C6434-67A8-4A1C-A971-FB20FB2829E7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"207、正确答案是4","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60281,"eetiGuid":"7BCB9E56-0EE2-46BE-9593-8F4CA3633065","eetiTiName":"4","eetiTiIsCorrect":1},{"eetiAutoId":60282,"eetiGuid":"2C568F2C-C586-475D-9A68-6F792283B450","eetiTiName":"30","eetiTiIsCorrect":-1},{"eetiAutoId":60283,"eetiGuid":"2343ED6A-3926-4884-A9A4-299BF539A9FF","eetiTiName":"87","eetiTiIsCorrect":-1},{"eetiAutoId":60284,"eetiGuid":"D66BF05F-9286-4BC9-AC5E-726EA022EB66","eetiTiName":"191","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18199,"eetGuid":"47A71A72-19C5-4A09-89E0-FA9E01A06F21","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"293、正确答案是31","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60625,"eetiGuid":"F298C1DA-7554-49BD-9DBA-8A1F7EA8DC45","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60626,"eetiGuid":"7F3CF14F-40FB-4494-9763-DD0287CBFC73","eetiTiName":"77","eetiTiIsCorrect":-1},{"eetiAutoId":60627,"eetiGuid":"C4C9E459-F8E6-4728-B2DB-515C8B098805","eetiTiName":"129","eetiTiIsCorrect":-1},{"eetiAutoId":60628,"eetiGuid":"75D53C39-1EAD-4772-94C9-B8283C541AF0","eetiTiName":"146","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18179,"eetGuid":"A206FC9B-8F35-40E5-9D6C-B8F689DB211D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"273、正确答案是60、87、163","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60545,"eetiGuid":"50CF3784-E9CE-4EE8-BADB-7E3D59EDC24C","eetiTiName":"14","eetiTiIsCorrect":-1},{"eetiAutoId":60546,"eetiGuid":"6C6925E2-3825-4706-98FE-99BAA5210EA0","eetiTiName":"60","eetiTiIsCorrect":1},{"eetiAutoId":60547,"eetiGuid":"2AC98AEA-6296-47DF-A4B0-977CCC23201A","eetiTiName":"87","eetiTiIsCorrect":1},{"eetiAutoId":60548,"eetiGuid":"AB6C1607-66A6-4048-954C-46E84D56D35E","eetiTiName":"163","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18142,"eetGuid":"21473128-ED21-453A-9C12-A3A7798FB6CB","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"236、正确答案是34、176","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60397,"eetiGuid":"D868554A-B5FE-4E4F-9F91-A99FA47CE539","eetiTiName":"12","eetiTiIsCorrect":-1},{"eetiAutoId":60398,"eetiGuid":"0EF0D641-5554-46D1-B804-9B1950A09F90","eetiTiName":"34","eetiTiIsCorrect":1},{"eetiAutoId":60399,"eetiGuid":"C28DC9B7-B24E-4705-B14C-D63965C30FEC","eetiTiName":"73","eetiTiIsCorrect":-1},{"eetiAutoId":60400,"eetiGuid":"CC8B4FBF-365B-4667-A23D-788E6A5DC6C7","eetiTiName":"176","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18145,"eetGuid":"A584A78E-8939-4C01-99EA-32C0679EB3CA","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"239、正确答案是89、146、167","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60409,"eetiGuid":"E4167023-215D-416B-BCFD-5D0DCEC69596","eetiTiName":"14","eetiTiIsCorrect":-1},{"eetiAutoId":60410,"eetiGuid":"A1FFCEEB-0AE0-4C4C-942F-B49708D6C90C","eetiTiName":"89","eetiTiIsCorrect":1},{"eetiAutoId":60411,"eetiGuid":"386545A6-8C06-4F55-93DD-00ED6C96F1EC","eetiTiName":"146","eetiTiIsCorrect":1},{"eetiAutoId":60412,"eetiGuid":"9CC928E3-F65C-49B2-AC8F-12D9997764D0","eetiTiName":"167","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18122,"eetGuid":"D6B14D7F-6A77-44AF-956A-A63AD07712FC","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"216、正确答案是122、133","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60317,"eetiGuid":"C479348D-1FC3-4E40-8C9B-FE3334DDF3AD","eetiTiName":"6","eetiTiIsCorrect":-1},{"eetiAutoId":60318,"eetiGuid":"FD5B999E-B4B4-4F12-98C0-D175FBEDEAD0","eetiTiName":"59","eetiTiIsCorrect":-1},{"eetiAutoId":60319,"eetiGuid":"E154AB46-C73F-4F51-99FD-C6E7BF653DAE","eetiTiName":"122","eetiTiIsCorrect":1},{"eetiAutoId":60320,"eetiGuid":"D2A9ABD4-7240-4EBD-94F0-4030D7F761F1","eetiTiName":"133","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18121,"eetGuid":"B96460CC-F898-4256-95B8-2F01810EC6F0","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"215、正确答案是26、78、133","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60313,"eetiGuid":"3BE6F34D-AF98-4255-B468-446A4878DD42","eetiTiName":"26","eetiTiIsCorrect":1},{"eetiAutoId":60314,"eetiGuid":"BF986901-6DD5-43D5-A4EB-775D2CB48CAA","eetiTiName":"78","eetiTiIsCorrect":1},{"eetiAutoId":60315,"eetiGuid":"56573C92-628E-4733-94AE-7AD28EDC4804","eetiTiName":"133","eetiTiIsCorrect":1},{"eetiAutoId":60316,"eetiGuid":"46329D78-79BD-4BC2-87AA-7A8294FECBE7","eetiTiName":"174","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18138,"eetGuid":"6B56FBBD-3CE1-430B-B23E-5B6D0922F7D8","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"232、正确答案是93、123、162","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60381,"eetiGuid":"D945D8F6-A4E3-4FA7-B106-7167358C3131","eetiTiName":"22","eetiTiIsCorrect":-1},{"eetiAutoId":60382,"eetiGuid":"407DCAD8-301E-4F22-BD89-082DE14FC468","eetiTiName":"93","eetiTiIsCorrect":1},{"eetiAutoId":60383,"eetiGuid":"D73256A0-4002-4904-8AB6-804F17955CA6","eetiTiName":"123","eetiTiIsCorrect":1},{"eetiAutoId":60384,"eetiGuid":"6AE9C75A-291E-43E1-B129-09E21F72EE55","eetiTiName":"162","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18175,"eetGuid":"DFCFD810-5ED3-4315-AC3A-68CE55AD0C58","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"269、正确答案是10、131","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60529,"eetiGuid":"A6FA4E72-654A-4F51-BB26-8638CE096DE4","eetiTiName":"10","eetiTiIsCorrect":1},{"eetiAutoId":60530,"eetiGuid":"FDBE7DDC-FFB4-47AB-B7B1-6D7F33F016B8","eetiTiName":"38","eetiTiIsCorrect":-1},{"eetiAutoId":60531,"eetiGuid":"35F0B67B-EDA1-4162-839F-D087BAE71678","eetiTiName":"131","eetiTiIsCorrect":1},{"eetiAutoId":60532,"eetiGuid":"3FE46FBF-C57A-4C99-BB6E-0808AC430DCC","eetiTiName":"199","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18205,"eetGuid":"3D854AC0-0779-4837-AF9B-3141B5412E4E","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"299、正确答案是117","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60649,"eetiGuid":"D60E72BD-C3D2-465C-8535-6897C8470455","eetiTiName":"24","eetiTiIsCorrect":-1},{"eetiAutoId":60650,"eetiGuid":"AAED9636-27AA-46A6-B830-B001802892D2","eetiTiName":"93","eetiTiIsCorrect":-1},{"eetiAutoId":60651,"eetiGuid":"C6F2C665-32B4-4C50-9573-EC61685CCD2F","eetiTiName":"117","eetiTiIsCorrect":1},{"eetiAutoId":60652,"eetiGuid":"07077038-704E-422C-BD1C-24EC162C6B6A","eetiTiName":"136","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18132,"eetGuid":"FFAD2D5A-D397-4415-8195-31A399C3309D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"226、正确答案是79、129","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60357,"eetiGuid":"C1E9BE2B-2E66-47E3-A897-1A486B5E0DDA","eetiTiName":"50","eetiTiIsCorrect":-1},{"eetiAutoId":60358,"eetiGuid":"3F40DF85-BF92-49C4-A7D7-85407A20E9F0","eetiTiName":"79","eetiTiIsCorrect":1},{"eetiAutoId":60359,"eetiGuid":"73F9864B-3435-428B-A6E1-6144A943B841","eetiTiName":"129","eetiTiIsCorrect":1},{"eetiAutoId":60360,"eetiGuid":"1E4FFBCD-513C-4706-AA7D-5FF3C1D24ACD","eetiTiName":"193","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18202,"eetGuid":"DAFD844C-D133-4E22-B55D-B6CEEB10E8AE","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"296、正确答案是45、101","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60637,"eetiGuid":"4A2CF7BC-E194-4C0F-AB95-B54EB3E536B4","eetiTiName":"42","eetiTiIsCorrect":-1},{"eetiAutoId":60638,"eetiGuid":"330AE02B-A802-474B-9514-C413E9507D0C","eetiTiName":"45","eetiTiIsCorrect":1},{"eetiAutoId":60639,"eetiGuid":"98D1D46B-9B67-4FB1-993F-A269B5822BFF","eetiTiName":"101","eetiTiIsCorrect":1},{"eetiAutoId":60640,"eetiGuid":"29BF6379-6A2A-4728-8EB3-A854E6043F85","eetiTiName":"181","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18164,"eetGuid":"992D7744-EEBF-42A0-A1A6-404D3B823DF5","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"258、正确答案是42、164","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60485,"eetiGuid":"10C2CBD2-BB49-432E-8FA1-409820C87C3C","eetiTiName":"42","eetiTiIsCorrect":1},{"eetiAutoId":60486,"eetiGuid":"4440AF2E-952C-4442-8B4C-77B079C9A509","eetiTiName":"58","eetiTiIsCorrect":-1},{"eetiAutoId":60487,"eetiGuid":"7294CA57-58EB-4880-9F19-B015A5CB45D2","eetiTiName":"113","eetiTiIsCorrect":-1},{"eetiAutoId":60488,"eetiGuid":"88049375-5CDB-40B3-BB40-978779E407AC","eetiTiName":"164","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18129,"eetGuid":"3BBD796E-0404-4C31-BF23-0A795A5D9DC9","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"223、正确答案是183","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60345,"eetiGuid":"9ABC542A-EF6B-4592-A716-624A4A70B85C","eetiTiName":"20","eetiTiIsCorrect":-1},{"eetiAutoId":60346,"eetiGuid":"D8EAAF55-2505-4C18-BC10-F0A943BB581A","eetiTiName":"89","eetiTiIsCorrect":-1},{"eetiAutoId":60347,"eetiGuid":"ED5EBE1E-DC73-4310-A8D6-1946DE9A5D32","eetiTiName":"116","eetiTiIsCorrect":-1},{"eetiAutoId":60348,"eetiGuid":"058FF8DA-686A-4FBB-B7AF-F21E0476CD82","eetiTiName":"183","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18153,"eetGuid":"17423175-FA83-4D2D-8F70-C36C7C3351E0","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"247、正确答案是149、158","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60441,"eetiGuid":"273FFD21-7322-4282-8029-7DF8BA942638","eetiTiName":"48","eetiTiIsCorrect":-1},{"eetiAutoId":60442,"eetiGuid":"FD779359-A71D-4D8E-BB9B-E546BFB826F8","eetiTiName":"55","eetiTiIsCorrect":-1},{"eetiAutoId":60443,"eetiGuid":"C301FC99-E51C-45C9-9132-38F8CE2254E9","eetiTiName":"149","eetiTiIsCorrect":1},{"eetiAutoId":60444,"eetiGuid":"062C8695-3591-43FE-B050-BD89F5508072","eetiTiName":"158","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18131,"eetGuid":"B0F45F9F-14AA-4976-B5CD-548CE44FDF86","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"225、正确答案是15、98","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60353,"eetiGuid":"3A2B34AC-4164-422B-9065-E1BCD476B075","eetiTiName":"15","eetiTiIsCorrect":1},{"eetiAutoId":60354,"eetiGuid":"01346821-82FC-4DBA-901D-377D337D4D6E","eetiTiName":"98","eetiTiIsCorrect":1},{"eetiAutoId":60355,"eetiGuid":"D962EF4B-C850-4A53-A100-C4CCB1883856","eetiTiName":"107","eetiTiIsCorrect":-1},{"eetiAutoId":60356,"eetiGuid":"CA54E407-78C4-4EDF-8BBC-B345F5F0080A","eetiTiName":"175","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18195,"eetGuid":"618C4E1F-8113-4FA7-A0D2-01BEC8AE7D23","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"289、正确答案是61、99","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60609,"eetiGuid":"364D122F-A72F-4D63-9B00-2BB93254EF80","eetiTiName":"19","eetiTiIsCorrect":-1},{"eetiAutoId":60610,"eetiGuid":"D59C972C-98EC-463F-B9F9-7EF956D3F2D0","eetiTiName":"61","eetiTiIsCorrect":1},{"eetiAutoId":60611,"eetiGuid":"F4797880-ED4B-431C-9CA0-481A3CB5E08A","eetiTiName":"99","eetiTiIsCorrect":1},{"eetiAutoId":60612,"eetiGuid":"3BDACA2B-2A1E-48BC-A01E-3B68B19E3891","eetiTiName":"129","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18172,"eetGuid":"F292E1EF-DE57-4242-A4F6-FCDC70F95121","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"266、正确答案是77、198","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60517,"eetiGuid":"1B3282C5-0C2E-479D-9692-D9CACC826B33","eetiTiName":"2","eetiTiIsCorrect":-1},{"eetiAutoId":60518,"eetiGuid":"7E199293-9CA5-4FBC-935E-C5DBA9C8A87D","eetiTiName":"67","eetiTiIsCorrect":-1},{"eetiAutoId":60519,"eetiGuid":"EE012685-78CD-4810-8BC9-147A4DBBC3C1","eetiTiName":"77","eetiTiIsCorrect":1},{"eetiAutoId":60520,"eetiGuid":"F16EDF38-3665-4D98-AB0B-C074E511EF08","eetiTiName":"198","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18159,"eetGuid":"96A49963-52E4-4617-B3FC-A9686A9325E7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"253、正确答案是24","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60465,"eetiGuid":"BFC86DBF-2B83-4CFA-B50B-F167444D4E2F","eetiTiName":"24","eetiTiIsCorrect":1},{"eetiAutoId":60466,"eetiGuid":"3E622ED7-B8A1-44BC-A643-0127F01FEB48","eetiTiName":"32","eetiTiIsCorrect":-1},{"eetiAutoId":60467,"eetiGuid":"EA139CCA-0809-48E4-845C-1A818FBDB963","eetiTiName":"134","eetiTiIsCorrect":-1},{"eetiAutoId":60468,"eetiGuid":"B1CE0F54-31B2-4535-9A24-BA954ECC272F","eetiTiName":"182","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18191,"eetGuid":"D53FAB93-A60A-4585-B603-0905C5AC2A97","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"285、正确答案是27、136、151","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60593,"eetiGuid":"6216A15D-B2E5-4D16-860D-74FFA13C8C48","eetiTiName":"13","eetiTiIsCorrect":-1},{"eetiAutoId":60594,"eetiGuid":"05D0D7E6-1C64-4435-AB4C-33EF8729CBAE","eetiTiName":"27","eetiTiIsCorrect":1},{"eetiAutoId":60595,"eetiGuid":"729272B5-9E4D-47CD-B2D4-3878A4DEFE40","eetiTiName":"136","eetiTiIsCorrect":1},{"eetiAutoId":60596,"eetiGuid":"01B3F231-5DE7-4A86-BB97-47A7672AF0EA","eetiTiName":"151","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18197,"eetGuid":"1D63FAAD-1923-44CC-9C5A-847C7280CAD5","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"291、正确答案是147","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60617,"eetiGuid":"04F6B2B0-629D-4B59-8F51-F87769D4FB2F","eetiTiName":"36","eetiTiIsCorrect":-1},{"eetiAutoId":60618,"eetiGuid":"17D69368-CCBD-4494-8D47-F122B3E93FA6","eetiTiName":"37","eetiTiIsCorrect":-1},{"eetiAutoId":60619,"eetiGuid":"39E723EB-8390-4026-8C24-2506CB607FC9","eetiTiName":"147","eetiTiIsCorrect":1},{"eetiAutoId":60620,"eetiGuid":"152770B5-4E17-4C73-BFBD-8E75D10C5A09","eetiTiName":"187","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18194,"eetGuid":"B8485141-F2B5-4EF2-ACE1-8F09813B7BBD","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"288、正确答案是56、117、148","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60605,"eetiGuid":"124290E8-4D65-424B-B960-01A1CC412F61","eetiTiName":"27","eetiTiIsCorrect":-1},{"eetiAutoId":60606,"eetiGuid":"98057D91-FAA7-44BA-8901-B9A6226FC405","eetiTiName":"56","eetiTiIsCorrect":1},{"eetiAutoId":60607,"eetiGuid":"366A512B-6556-47B4-95E7-D4BBFBD56CC8","eetiTiName":"117","eetiTiIsCorrect":1},{"eetiAutoId":60608,"eetiGuid":"36B9D33F-DCDA-47B1-9F2E-C561F2B5563E","eetiTiName":"148","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18118,"eetGuid":"88456CB8-220C-488C-9747-6636E426AD57","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"212、正确答案是34、109、169","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60301,"eetiGuid":"55CBF6EF-3E63-47B9-A910-F786F8B921CA","eetiTiName":"34","eetiTiIsCorrect":1},{"eetiAutoId":60302,"eetiGuid":"DA56D70C-18AC-40BA-8A56-ACD99E7F0B9C","eetiTiName":"65","eetiTiIsCorrect":-1},{"eetiAutoId":60303,"eetiGuid":"FE0F6F66-5254-46F8-9FE3-872E35EC2890","eetiTiName":"109","eetiTiIsCorrect":1},{"eetiAutoId":60304,"eetiGuid":"0C8FB677-CB1A-45C5-917C-A7118AFD80E0","eetiTiName":"169","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18187,"eetGuid":"8C2F1318-3478-40FC-ADE4-46BF8ACE315E","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"281、正确答案是34、108、128","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60577,"eetiGuid":"4FC34A3D-6823-4477-B1BD-95E31DB0DF35","eetiTiName":"34","eetiTiIsCorrect":1},{"eetiAutoId":60578,"eetiGuid":"1BD527D2-5009-4789-A581-2F6C609ECD5B","eetiTiName":"93","eetiTiIsCorrect":-1},{"eetiAutoId":60579,"eetiGuid":"BBD4C305-B1F8-433C-8FC7-97D8B96C0A75","eetiTiName":"108","eetiTiIsCorrect":1},{"eetiAutoId":60580,"eetiGuid":"18805AD0-42C8-4D5F-A47C-F6C35D81F3BB","eetiTiName":"128","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18125,"eetGuid":"D32513E7-7532-4599-A636-D0C0A95A1592","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"219、正确答案是31、149","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60329,"eetiGuid":"9F2D853E-2104-42F6-81F1-099A63013F83","eetiTiName":"3","eetiTiIsCorrect":-1},{"eetiAutoId":60330,"eetiGuid":"CD0D72B0-A80E-4541-BBB5-486D405868DD","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60331,"eetiGuid":"527F9CB0-12F2-474F-AD97-3F6DD004F0B7","eetiTiName":"44","eetiTiIsCorrect":-1},{"eetiAutoId":60332,"eetiGuid":"A29325A6-D82C-4A68-A5E0-7C06B195DC1A","eetiTiName":"149","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18147,"eetGuid":"FEC43E50-D957-4815-AF42-B7E078B8F6B8","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"241、正确答案是73、120","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60417,"eetiGuid":"6255F465-8765-4A6F-B263-04DD6DD8E777","eetiTiName":"10","eetiTiIsCorrect":-1},{"eetiAutoId":60418,"eetiGuid":"1E190449-1C31-4A39-84AA-D77532DCA70E","eetiTiName":"73","eetiTiIsCorrect":1},{"eetiAutoId":60419,"eetiGuid":"818AD20A-02C8-41D2-9F95-87BABE07C799","eetiTiName":"120","eetiTiIsCorrect":1},{"eetiAutoId":60420,"eetiGuid":"82D121B0-95D9-47DF-B143-EAD3FF864B04","eetiTiName":"130","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18149,"eetGuid":"510543EC-3B73-4749-8DB7-CC432F7E04D5","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"243、正确答案是34、68、156","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60425,"eetiGuid":"D81677E2-D7BA-4014-BF06-F6FCC6E54139","eetiTiName":"34","eetiTiIsCorrect":1},{"eetiAutoId":60426,"eetiGuid":"79D497F9-E8D3-437E-83A4-F944FA5CD4DF","eetiTiName":"46","eetiTiIsCorrect":-1},{"eetiAutoId":60427,"eetiGuid":"D4F7594F-9F8F-4930-BEA2-4C0275116FF3","eetiTiName":"68","eetiTiIsCorrect":1},{"eetiAutoId":60428,"eetiGuid":"B3B9FC09-DEAC-4625-BCD9-57EB858E0422","eetiTiName":"156","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18143,"eetGuid":"0D64DBBC-A8F5-4CCD-89B0-FD16CFF32299","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"237、正确答案是55、63","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60401,"eetiGuid":"21115F4C-A096-4B5A-8334-6EFF91AEBD06","eetiTiName":"37","eetiTiIsCorrect":-1},{"eetiAutoId":60402,"eetiGuid":"0BC4CB54-74C7-4D34-8D79-98EC0705D9C5","eetiTiName":"55","eetiTiIsCorrect":1},{"eetiAutoId":60403,"eetiGuid":"6DAC110E-4030-444C-A153-D032F51D3F6D","eetiTiName":"63","eetiTiIsCorrect":1},{"eetiAutoId":60404,"eetiGuid":"D94E01A0-DC1F-433F-AF29-A583A9CA3F3E","eetiTiName":"149","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18165,"eetGuid":"127DEAE6-4496-41B7-8693-69110501A77F","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"259、正确答案是74","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60489,"eetiGuid":"4D6A5D63-2DE5-4921-B9C0-F414038A20B2","eetiTiName":"40","eetiTiIsCorrect":-1},{"eetiAutoId":60490,"eetiGuid":"9D651050-2BDD-4B54-893E-DD7E31825E94","eetiTiName":"74","eetiTiIsCorrect":1},{"eetiAutoId":60491,"eetiGuid":"ABE0C644-B5A9-4298-A584-4FCB092B4C41","eetiTiName":"125","eetiTiIsCorrect":-1},{"eetiAutoId":60492,"eetiGuid":"186AE4CD-5264-4BC4-BC82-109AB7FB20B2","eetiTiName":"143","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18116,"eetGuid":"29FC6787-4271-4AD5-B162-D7F49E8B31F9","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"210、正确答案是24、89、120","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60293,"eetiGuid":"24F5D2FA-FDF8-40ED-98BD-8507459672F9","eetiTiName":"24","eetiTiIsCorrect":1},{"eetiAutoId":60294,"eetiGuid":"AABB3971-ECD6-4276-8C38-D47271ABDBF7","eetiTiName":"89","eetiTiIsCorrect":1},{"eetiAutoId":60295,"eetiGuid":"C3E9201B-31C1-4564-8C67-F9F895FF91BC","eetiTiName":"120","eetiTiIsCorrect":1},{"eetiAutoId":60296,"eetiGuid":"AFA559B2-F270-4A04-B12C-DD026D5514C4","eetiTiName":"151","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18133,"eetGuid":"4D6838FB-E9B6-4614-B4FC-30C2B1C86FF0","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"227、正确答案是50、91、99、194","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60361,"eetiGuid":"E0ADA69D-C00C-47D6-A108-6717897D7FE4","eetiTiName":"50","eetiTiIsCorrect":1},{"eetiAutoId":60362,"eetiGuid":"6CD72B7F-9A00-4A20-A825-E1A3761D5F73","eetiTiName":"91","eetiTiIsCorrect":1},{"eetiAutoId":60363,"eetiGuid":"36E1AF67-A25C-4E99-B636-FFACC884D99A","eetiTiName":"99","eetiTiIsCorrect":1},{"eetiAutoId":60364,"eetiGuid":"69BA431D-1543-4E73-9DAB-6C4E9E750C31","eetiTiName":"194","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18168,"eetGuid":"F6B1FBE4-0F32-4AFF-8B16-CC0533D30955","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"262、正确答案是29、88、150","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60501,"eetiGuid":"B08E71F0-4862-498D-B25C-2B5E603E8E53","eetiTiName":"29","eetiTiIsCorrect":1},{"eetiAutoId":60502,"eetiGuid":"9732F345-4052-42B1-87D8-475115C0A4E6","eetiTiName":"88","eetiTiIsCorrect":1},{"eetiAutoId":60503,"eetiGuid":"AC78C8EA-B074-4469-9F66-DA9D1B59E89B","eetiTiName":"110","eetiTiIsCorrect":-1},{"eetiAutoId":60504,"eetiGuid":"2A0B63DB-3DDC-4D30-82D7-736AF84DF59B","eetiTiName":"150","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18166,"eetGuid":"7BCD3B13-A4C4-4A25-94FE-42CC1190F7C8","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"260、正确答案是45、99、116","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60493,"eetiGuid":"D9B9710A-2189-4EAB-BE40-D71E2F0AD287","eetiTiName":"45","eetiTiIsCorrect":1},{"eetiAutoId":60494,"eetiGuid":"BB639969-23AD-41B1-80BA-D260FF23C2B6","eetiTiName":"99","eetiTiIsCorrect":1},{"eetiAutoId":60495,"eetiGuid":"8BDB58DA-E738-4366-BCCE-370CC9E3EAED","eetiTiName":"116","eetiTiIsCorrect":1},{"eetiAutoId":60496,"eetiGuid":"D67D19CA-562D-4BF5-AF3D-A7BFB226E24B","eetiTiName":"132","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18206,"eetGuid":"42592A39-2A90-4A4E-835E-9F4F76CFEA5A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"300、正确答案是15、96、168","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60653,"eetiGuid":"B958D9ED-67FC-4C14-9B97-B1DDB11375A3","eetiTiName":"15","eetiTiIsCorrect":1},{"eetiAutoId":60654,"eetiGuid":"28A2C34C-2347-4FB4-92FD-5D359B73D4AC","eetiTiName":"105","eetiTiIsCorrect":-1},{"eetiAutoId":60655,"eetiGuid":"A45BDD7F-736F-4821-810A-AB77D6178DB9","eetiTiName":"96","eetiTiIsCorrect":1},{"eetiAutoId":60656,"eetiGuid":"BFDD1D86-EABF-4F36-B00A-BFB0ABEC0F28","eetiTiName":"168","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18183,"eetGuid":"1C63AAF9-825F-4BFB-B337-69540DCB859D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"277、正确答案是24、75、176","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60561,"eetiGuid":"F6371B05-D5E4-4532-A6F5-9399F7910255","eetiTiName":"24","eetiTiIsCorrect":1},{"eetiAutoId":60562,"eetiGuid":"7F54716F-F81B-410F-B9A7-DF8B3B184C93","eetiTiName":"61","eetiTiIsCorrect":-1},{"eetiAutoId":60563,"eetiGuid":"D29C99D9-5A63-4B6E-9C9D-85D969AE7F00","eetiTiName":"75","eetiTiIsCorrect":1},{"eetiAutoId":60564,"eetiGuid":"FAD26698-D948-4BF9-AE18-DAB8DA92317A","eetiTiName":"176","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18181,"eetGuid":"098E4C5E-D55B-42FE-ABFB-47D624ABEFFE","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"275、正确答案是33、70","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60553,"eetiGuid":"1E7F07A9-4552-4A0E-BC6F-6E8D305E4BDA","eetiTiName":"33","eetiTiIsCorrect":1},{"eetiAutoId":60554,"eetiGuid":"6E64E5EF-0999-44EB-988E-4E93A38CB8AE","eetiTiName":"70","eetiTiIsCorrect":1},{"eetiAutoId":60555,"eetiGuid":"29B886C8-7CBE-4F52-9809-D939E359D99F","eetiTiName":"130","eetiTiIsCorrect":-1},{"eetiAutoId":60556,"eetiGuid":"A86AD7A4-A3B8-41F4-ADC4-09E4386275A4","eetiTiName":"199","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18151,"eetGuid":"95632502-DC65-47C5-B940-254CD3CD5968","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"245、正确答案是70、126、145","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60433,"eetiGuid":"669648EF-CC19-48CA-91E5-21DC9F30F9B4","eetiTiName":"11","eetiTiIsCorrect":-1},{"eetiAutoId":60434,"eetiGuid":"938B7B1C-C156-40F6-AD81-46D24BE6846C","eetiTiName":"70","eetiTiIsCorrect":1},{"eetiAutoId":60435,"eetiGuid":"FBAF86A3-89FB-4DCE-ACC0-E269378B33F4","eetiTiName":"126","eetiTiIsCorrect":1},{"eetiAutoId":60436,"eetiGuid":"28FF96B0-E2D8-4311-B5BB-C45D3B5CFA06","eetiTiName":"145","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18154,"eetGuid":"EA377B16-842E-4B99-ADB2-7FC5B01927C1","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"248、正确答案是21、84、140","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60445,"eetiGuid":"BF08E091-4101-4A7C-B46D-8347CF66AE6D","eetiTiName":"21","eetiTiIsCorrect":1},{"eetiAutoId":60446,"eetiGuid":"CB8C2123-857A-4C01-9836-2F312807C205","eetiTiName":"84","eetiTiIsCorrect":1},{"eetiAutoId":60447,"eetiGuid":"3CDFAB86-5CC4-4BB9-8C67-36278E4503CE","eetiTiName":"137","eetiTiIsCorrect":-1},{"eetiAutoId":60448,"eetiGuid":"820364A8-ABD2-46EF-A231-B2800D7F643D","eetiTiName":"140","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18188,"eetGuid":"2BFC06CA-C183-46BC-8E7A-255420F5C9CE","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"282、正确答案是141、151","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60581,"eetiGuid":"DBE9D3AF-C2D7-4CA4-81FA-8D4FE7F52665","eetiTiName":"25","eetiTiIsCorrect":-1},{"eetiAutoId":60582,"eetiGuid":"4CFE98B4-F5B6-4A23-A43F-75EC1A768762","eetiTiName":"84","eetiTiIsCorrect":-1},{"eetiAutoId":60583,"eetiGuid":"D8046EA4-71F7-4230-B993-5C8EA61A64C7","eetiTiName":"141","eetiTiIsCorrect":1},{"eetiAutoId":60584,"eetiGuid":"BD144760-2B19-4D57-9BB6-87562E3DE137","eetiTiName":"151","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18162,"eetGuid":"B6D45D94-651E-4368-A46F-DA5F90A913F6","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"256、正确答案是28、82、86","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60477,"eetiGuid":"A582A744-3BE2-4941-9102-FA100A69E7B5","eetiTiName":"28","eetiTiIsCorrect":1},{"eetiAutoId":60478,"eetiGuid":"ED7AC801-5286-47B7-8F2B-1349C8757A41","eetiTiName":"82","eetiTiIsCorrect":1},{"eetiAutoId":60479,"eetiGuid":"255C77AD-DEBD-4FAE-85AF-3A4340102E5C","eetiTiName":"86","eetiTiIsCorrect":1},{"eetiAutoId":60480,"eetiGuid":"C90781B6-8D6F-45A5-99CC-82775896C0FF","eetiTiName":"129","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18204,"eetGuid":"F76B1BE8-E31E-432B-A162-1D3474FD868F","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"298、正确答案是158","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60645,"eetiGuid":"97EFD95B-4FF3-4C10-98BD-EF73BBAEA693","eetiTiName":"33","eetiTiIsCorrect":-1},{"eetiAutoId":60646,"eetiGuid":"CFB71B12-87A0-47B6-B3A2-AA675DD1929A","eetiTiName":"62","eetiTiIsCorrect":-1},{"eetiAutoId":60647,"eetiGuid":"17515AB6-C4C2-4A45-9954-BF14BDD471B0","eetiTiName":"101","eetiTiIsCorrect":-1},{"eetiAutoId":60648,"eetiGuid":"E10A8724-56B7-4C1D-B71E-AC2EA42512AA","eetiTiName":"158","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18171,"eetGuid":"FA321226-0D0F-415E-BCFE-261090E11460","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"265、正确答案是127、187","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60513,"eetiGuid":"3D3E807C-D5D4-492A-994A-A07EC8091D4A","eetiTiName":"11","eetiTiIsCorrect":-1},{"eetiAutoId":60514,"eetiGuid":"79346D6F-40F3-4BD7-9D8A-F47EFCF1149B","eetiTiName":"88","eetiTiIsCorrect":-1},{"eetiAutoId":60515,"eetiGuid":"FF82EAD6-9142-4739-AE90-29A11E13363E","eetiTiName":"127","eetiTiIsCorrect":1},{"eetiAutoId":60516,"eetiGuid":"17426965-351D-4969-BD2C-35A054CDE5A4","eetiTiName":"187","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18141,"eetGuid":"EBCFE1C5-B3A6-4D32-930D-39F005916EFC","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"235、正确答案是100","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60393,"eetiGuid":"E4041533-537B-49EA-B942-79AF48A0D046","eetiTiName":"28","eetiTiIsCorrect":-1},{"eetiAutoId":60394,"eetiGuid":"CC25B9CD-BAAE-4538-AA58-0272CC4E0114","eetiTiName":"76","eetiTiIsCorrect":-1},{"eetiAutoId":60395,"eetiGuid":"EE7FDAEB-3B06-46A3-A72F-DEB8F0B225EC","eetiTiName":"96","eetiTiIsCorrect":-1},{"eetiAutoId":60396,"eetiGuid":"D528DEA1-7A88-4763-BB9B-AB00951CB96B","eetiTiName":"100","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18180,"eetGuid":"40309AA2-6929-45C8-85CF-63F3FE7E8431","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"274、正确答案是115、142","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60549,"eetiGuid":"CECF0292-5EAF-426C-9A86-2CEF10A39261","eetiTiName":"39","eetiTiIsCorrect":-1},{"eetiAutoId":60550,"eetiGuid":"F4A713F2-0983-45E4-B709-C596178EB346","eetiTiName":"67","eetiTiIsCorrect":-1},{"eetiAutoId":60551,"eetiGuid":"B1226DA2-F4D1-431F-B209-092F041B22D9","eetiTiName":"115","eetiTiIsCorrect":1},{"eetiAutoId":60552,"eetiGuid":"A289BC35-D509-45EA-B5DC-6D5260E5FFF3","eetiTiName":"142","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18198,"eetGuid":"C4085D95-13B8-4BB6-9736-6F71CF54837C","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"292、正确答案是77、129、149","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60621,"eetiGuid":"CCCC82BA-F7EE-4158-8EF0-66F374BC3C77","eetiTiName":"38","eetiTiIsCorrect":-1},{"eetiAutoId":60622,"eetiGuid":"0D3BA9A2-AC02-45DA-812A-A183F3556E5F","eetiTiName":"77","eetiTiIsCorrect":1},{"eetiAutoId":60623,"eetiGuid":"6D1CF9C3-C2F7-407D-B69C-E51C05CF53CF","eetiTiName":"129","eetiTiIsCorrect":1},{"eetiAutoId":60624,"eetiGuid":"CD2BBF1A-30BC-4933-9B51-EC55A092B86A","eetiTiName":"149","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18135,"eetGuid":"A9A1948B-DF0F-422F-88A4-A1E9CAA657AD","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"229、正确答案是41、66、85","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60369,"eetiGuid":"B261E7CA-5BB1-4705-BCCB-05582CB95170","eetiTiName":"41","eetiTiIsCorrect":1},{"eetiAutoId":60370,"eetiGuid":"3653D178-B1D7-4741-ADB9-7CCB7254EB4C","eetiTiName":"66","eetiTiIsCorrect":1},{"eetiAutoId":60371,"eetiGuid":"05AEEC9B-207D-433D-9D0D-89487B6DDA1E","eetiTiName":"85","eetiTiIsCorrect":1},{"eetiAutoId":60372,"eetiGuid":"1C376C96-A48E-423E-A18B-6562230ECA04","eetiTiName":"113","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18110,"eetGuid":"9CF1D0A9-C895-4845-B96C-B8E4A3CB792A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"204、正确答案是36、53、121","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60269,"eetiGuid":"6D1C1D81-3EE3-496C-A6AD-E1D8DCF8E497","eetiTiName":"36","eetiTiIsCorrect":1},{"eetiAutoId":60270,"eetiGuid":"535905A3-EE06-4AA5-91D2-21264389A6FE","eetiTiName":"53","eetiTiIsCorrect":1},{"eetiAutoId":60271,"eetiGuid":"03604540-11C7-4CEF-A077-51223FDDE571","eetiTiName":"110","eetiTiIsCorrect":-1},{"eetiAutoId":60272,"eetiGuid":"9C771DF6-97EC-49C2-97F7-04DC64D4F2EE","eetiTiName":"121","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18119,"eetGuid":"40101660-CBB0-42E4-A497-555BED413167","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"213、正确答案是38、75","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60305,"eetiGuid":"ACDAD3B9-1B82-4C93-A55E-11B68461DC77","eetiTiName":"38","eetiTiIsCorrect":1},{"eetiAutoId":60306,"eetiGuid":"C68D1827-5EA8-4020-B6DC-5F2D6C06C75D","eetiTiName":"72","eetiTiIsCorrect":-1},{"eetiAutoId":60307,"eetiGuid":"6199A074-F6EE-423D-B31B-669D23C9D76A","eetiTiName":"75","eetiTiIsCorrect":1},{"eetiAutoId":60308,"eetiGuid":"215AD8B9-58C8-4117-999B-9C06E79CE7A6","eetiTiName":"148","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18150,"eetGuid":"AD494D2A-04EC-4212-850D-205A4A080928","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"244、正确答案是13","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60429,"eetiGuid":"A23B4A39-4EC6-4723-8190-0FACD1554462","eetiTiName":"13","eetiTiIsCorrect":1},{"eetiAutoId":60430,"eetiGuid":"FDA5068B-77D7-4760-862E-D334E2DCEDA4","eetiTiName":"85","eetiTiIsCorrect":-1},{"eetiAutoId":60431,"eetiGuid":"8B9DB043-A8A5-4B25-8F7D-0471BDE86026","eetiTiName":"135","eetiTiIsCorrect":-1},{"eetiAutoId":60432,"eetiGuid":"942949C5-4D72-46E0-8814-59224DD9461F","eetiTiName":"191","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18114,"eetGuid":"BDA7B3E7-2E3B-4B27-9ECE-5267E3C6B477","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"208、正确答案是65、86、193","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60285,"eetiGuid":"12A66609-A432-4052-9E8B-8F84DDD6DF6E","eetiTiName":"31","eetiTiIsCorrect":-1},{"eetiAutoId":60286,"eetiGuid":"123F795D-BF2C-4A4E-865F-AFB69657BA96","eetiTiName":"65","eetiTiIsCorrect":1},{"eetiAutoId":60287,"eetiGuid":"9DF6163A-7148-4E80-B106-714B2C4271B5","eetiTiName":"86","eetiTiIsCorrect":1},{"eetiAutoId":60288,"eetiGuid":"46264B8C-D9D8-4B57-81D9-A95D04A37E33","eetiTiName":"193","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18200,"eetGuid":"1F7D8BC8-6C94-494E-A4C5-52EE20CE548B","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"294、正确答案是39、69、86","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60629,"eetiGuid":"1532F266-6DB9-48F5-8FAC-2ABD16B48FC9","eetiTiName":"39","eetiTiIsCorrect":1},{"eetiAutoId":60630,"eetiGuid":"14802915-40FD-40C9-96FC-51830024AFBD","eetiTiName":"69","eetiTiIsCorrect":1},{"eetiAutoId":60631,"eetiGuid":"7A8EA595-5660-4140-A4E9-BC6D07DC809B","eetiTiName":"86","eetiTiIsCorrect":1},{"eetiAutoId":60632,"eetiGuid":"FE6D0841-84B2-495E-BC5A-ABC53CB2F66A","eetiTiName":"131","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18176,"eetGuid":"CC8BBD33-ACBD-4E1D-A34D-11BE82D5F15A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"270、正确答案是72","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60533,"eetiGuid":"B857351C-8967-4A88-8D67-849D3083028A","eetiTiName":"17","eetiTiIsCorrect":-1},{"eetiAutoId":60534,"eetiGuid":"CB2E789D-AC50-458B-B4F0-B9FE2CE0F202","eetiTiName":"72","eetiTiIsCorrect":1},{"eetiAutoId":60535,"eetiGuid":"42B696B4-B441-45BF-ABA0-A1D33034883D","eetiTiName":"132","eetiTiIsCorrect":-1},{"eetiAutoId":60536,"eetiGuid":"45969870-A5CB-4680-8F0D-3434FC2A0125","eetiTiName":"171","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18156,"eetGuid":"FFF7DD3D-64BB-4D65-BE77-F69A9E07FB3D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"250、正确答案是45","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60453,"eetiGuid":"102ADC3D-2215-48D3-A709-70601F99B39C","eetiTiName":"45","eetiTiIsCorrect":1},{"eetiAutoId":60454,"eetiGuid":"986B0739-5DDC-4CC8-9E5F-2FF3654748FE","eetiTiName":"49","eetiTiIsCorrect":-1},{"eetiAutoId":60455,"eetiGuid":"FC83DAEE-A574-4395-9379-F2D9C9FB93D9","eetiTiName":"87","eetiTiIsCorrect":-1},{"eetiAutoId":60456,"eetiGuid":"FB0727FF-F4E4-432D-ADF6-08DE1B3CD23C","eetiTiName":"191","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18134,"eetGuid":"61BDD995-CE8A-4EEC-B54A-03F635DE0BA2","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"228、正确答案是46、69、157","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60365,"eetiGuid":"45F14796-B455-4255-9E41-FAA2131715A6","eetiTiName":"46","eetiTiIsCorrect":1},{"eetiAutoId":60366,"eetiGuid":"D5BE97A1-3E6B-4EC5-8B42-5CA41A984F96","eetiTiName":"69","eetiTiIsCorrect":1},{"eetiAutoId":60367,"eetiGuid":"F3B0A7A4-D614-4305-8684-F4F026DDB4B9","eetiTiName":"108","eetiTiIsCorrect":-1},{"eetiAutoId":60368,"eetiGuid":"417A8791-0D80-416D-B32B-A2CB1E65FFE3","eetiTiName":"157","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18148,"eetGuid":"FDBBA0B8-F3AC-4918-8F46-F9FBC970A4C4","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"242、正确答案是68、72","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60421,"eetiGuid":"2387DACF-52E7-4670-9D38-164D4247AA63","eetiTiName":"34","eetiTiIsCorrect":-1},{"eetiAutoId":60422,"eetiGuid":"FAAC5CEA-0CC3-4A43-80A0-962354F8B9B4","eetiTiName":"68","eetiTiIsCorrect":1},{"eetiAutoId":60423,"eetiGuid":"D1F715F0-A080-4C5C-823A-4740DA71C49E","eetiTiName":"72","eetiTiIsCorrect":1},{"eetiAutoId":60424,"eetiGuid":"2D1E6BEC-CACC-42E5-A72A-D7379F64126D","eetiTiName":"160","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18169,"eetGuid":"213C6B19-EC0E-4C1B-84FD-7D3EF8E04C0D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"263、正确答案是36、127","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60505,"eetiGuid":"D62BC0F2-677B-4EE3-AA3A-25C9AB195FE5","eetiTiName":"28","eetiTiIsCorrect":-1},{"eetiAutoId":60506,"eetiGuid":"5CA88E93-F19C-4214-B52B-3E698E25B870","eetiTiName":"36","eetiTiIsCorrect":1},{"eetiAutoId":60507,"eetiGuid":"3A5E78A1-1DF0-4C74-8D75-759DEA9F6A32","eetiTiName":"127","eetiTiIsCorrect":1},{"eetiAutoId":60508,"eetiGuid":"723C425B-AA80-4C26-846B-717EB8D07D6F","eetiTiName":"176","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18117,"eetGuid":"4F74D16E-E515-414E-BE2F-C35A4F7BC39A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"211、正确答案是20、64、99、194","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60297,"eetiGuid":"7D181131-412F-456D-8F08-8D95B192BE5E","eetiTiName":"20","eetiTiIsCorrect":1},{"eetiAutoId":60298,"eetiGuid":"AE57FAF2-010F-4132-92F0-C7711578EB1A","eetiTiName":"64","eetiTiIsCorrect":1},{"eetiAutoId":60299,"eetiGuid":"F33BDBB0-AF7B-49D2-ADF9-D132DC41DD68","eetiTiName":"99","eetiTiIsCorrect":1},{"eetiAutoId":60300,"eetiGuid":"DCDD0210-99B6-4F9C-9606-0F444A4DA8E2","eetiTiName":"194","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18174,"eetGuid":"AECABED9-1D5A-477F-9263-10F8CF5E9CD7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"268、正确答案是60","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60525,"eetiGuid":"55483B99-C8A7-4016-8D5B-B49EA4C55418","eetiTiName":"20","eetiTiIsCorrect":-1},{"eetiAutoId":60526,"eetiGuid":"552F8073-CA2A-465C-9E8B-3A1C9A21E1A6","eetiTiName":"40","eetiTiIsCorrect":-1},{"eetiAutoId":60527,"eetiGuid":"8209F1F2-94E3-44C8-85C3-2878A544EFA5","eetiTiName":"60","eetiTiIsCorrect":1},{"eetiAutoId":60528,"eetiGuid":"C5F845AD-BBD4-48BC-AEFB-7DA050F6D07C","eetiTiName":"193","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18127,"eetGuid":"79003760-3425-4024-A207-5C70926288BE","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"221、正确答案是8、114","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60337,"eetiGuid":"ED1C3DE7-31BD-498F-AF79-B0ACFC880A76","eetiTiName":"8","eetiTiIsCorrect":1},{"eetiAutoId":60338,"eetiGuid":"3BE0D4BF-ED3C-4E04-BA2E-280FE4752B68","eetiTiName":"21","eetiTiIsCorrect":-1},{"eetiAutoId":60339,"eetiGuid":"43CA3B60-B635-48AB-A1E7-5A8ECB3723B0","eetiTiName":"27","eetiTiIsCorrect":-1},{"eetiAutoId":60340,"eetiGuid":"24184934-0A8C-47BC-8816-644FC82A7FDD","eetiTiName":"114","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18126,"eetGuid":"851AFDA4-C4AA-4947-8A67-94582A603BCD","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"220、正确答案是29、133","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60333,"eetiGuid":"A329C14A-B9E0-455F-BFDF-4DF8DC274679","eetiTiName":"29","eetiTiIsCorrect":1},{"eetiAutoId":60334,"eetiGuid":"3D920A51-B26B-4167-9A05-74842DDB0C53","eetiTiName":"100","eetiTiIsCorrect":-1},{"eetiAutoId":60335,"eetiGuid":"EE0F8AD2-2C3B-45EC-B416-83E21A07B74F","eetiTiName":"133","eetiTiIsCorrect":1},{"eetiAutoId":60336,"eetiGuid":"229E7C8C-903F-4A8C-929B-7CE855E46BA6","eetiTiName":"178","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18161,"eetGuid":"88E20DB4-C297-4E47-A4ED-64847BBA0184","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"255、正确答案是77、133、190","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60473,"eetiGuid":"E83A31C2-C24B-45D5-9856-861E5C68F84F","eetiTiName":"31","eetiTiIsCorrect":-1},{"eetiAutoId":60474,"eetiGuid":"6D7C40E8-58C2-4B87-8617-CB7688A1536A","eetiTiName":"77","eetiTiIsCorrect":1},{"eetiAutoId":60475,"eetiGuid":"9DD99058-2C1B-41BB-A897-064680756443","eetiTiName":"133","eetiTiIsCorrect":1},{"eetiAutoId":60476,"eetiGuid":"14BBDB66-F38E-4D78-B8F6-9B083523F29E","eetiTiName":"190","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18139,"eetGuid":"C0CD5895-B5E7-47E0-8F5D-B11FA8190BE3","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"233、正确答案是19","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60385,"eetiGuid":"46ECCFBA-99ED-4E14-9EC9-175E39FC1260","eetiTiName":"19","eetiTiIsCorrect":1},{"eetiAutoId":60386,"eetiGuid":"D56DB9FD-FB27-487B-A353-3A4FB6CD4149","eetiTiName":"43","eetiTiIsCorrect":-1},{"eetiAutoId":60387,"eetiGuid":"68E79C50-1862-4013-968C-0077036C8022","eetiTiName":"47","eetiTiIsCorrect":-1},{"eetiAutoId":60388,"eetiGuid":"D3A346FF-74C6-4506-A317-1CD218E0F3D1","eetiTiName":"156","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18115,"eetGuid":"B4C40231-797A-4A8F-A695-D1676361E2FC","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"209、正确答案是35、121、143","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60289,"eetiGuid":"C8D5DFC6-72E1-4D0D-B448-F775D2C9BE4C","eetiTiName":"35","eetiTiIsCorrect":1},{"eetiAutoId":60290,"eetiGuid":"5639D1BA-A486-45FA-8F25-7A97356FCA55","eetiTiName":"97","eetiTiIsCorrect":-1},{"eetiAutoId":60291,"eetiGuid":"2AE871F3-0834-4913-9E8E-83CCE1EDA8BF","eetiTiName":"121","eetiTiIsCorrect":1},{"eetiAutoId":60292,"eetiGuid":"16099AA4-3144-4C2F-98F3-4822CFE9781E","eetiTiName":"143","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18189,"eetGuid":"ED4C9C1C-E218-44FB-B24A-15C27CD8A375","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"283、正确答案是9、94、154","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60585,"eetiGuid":"4965AFD3-F4AE-4C20-ADDB-538C56D008B9","eetiTiName":"9","eetiTiIsCorrect":1},{"eetiAutoId":60586,"eetiGuid":"429487EB-CD3A-4108-BB60-470C143F6779","eetiTiName":"94","eetiTiIsCorrect":1},{"eetiAutoId":60587,"eetiGuid":"1792BB2F-C452-4881-86C0-0AB0D6FBED30","eetiTiName":"133","eetiTiIsCorrect":-1},{"eetiAutoId":60588,"eetiGuid":"4524C014-499E-45DE-A044-A854BBC8BC9B","eetiTiName":"154","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18152,"eetGuid":"908C11E4-BE78-47CC-93D8-49629CCA537F","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"246、正确答案是77、137","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60437,"eetiGuid":"DD41CDB1-0F81-40CB-A1EB-BD9B0801B23C","eetiTiName":"33","eetiTiIsCorrect":-1},{"eetiAutoId":60438,"eetiGuid":"10CB8385-E4E8-4F36-90BC-1875657D14DB","eetiTiName":"39","eetiTiIsCorrect":-1},{"eetiAutoId":60439,"eetiGuid":"A43C1167-3FA1-4BB8-A2B4-2E7C1D0E3A91","eetiTiName":"77","eetiTiIsCorrect":1},{"eetiAutoId":60440,"eetiGuid":"332FF04E-8B45-4560-AD95-4A020B5A7D9A","eetiTiName":"137","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18163,"eetGuid":"20489B6E-2B6A-429C-853C-4E1145A1633A","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"257、正确答案是199","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60481,"eetiGuid":"E084DC4C-E7BE-4097-8536-80B390D13C81","eetiTiName":"29","eetiTiIsCorrect":-1},{"eetiAutoId":60482,"eetiGuid":"A17CAB41-66FD-4A7F-AA37-8088225C8E0D","eetiTiName":"39","eetiTiIsCorrect":-1},{"eetiAutoId":60483,"eetiGuid":"F0B5F3D3-75FB-4184-8D90-3CAF970ECEA9","eetiTiName":"124","eetiTiIsCorrect":-1},{"eetiAutoId":60484,"eetiGuid":"BFED7BBF-D438-4C98-83AA-A8FA6B49F50E","eetiTiName":"199","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18170,"eetGuid":"DA9F4672-6390-492A-AD95-6F424BDF4D61","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"264、正确答案是35、137","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60509,"eetiGuid":"05382227-6434-4CED-BB18-BAEC962757CB","eetiTiName":"31","eetiTiIsCorrect":-1},{"eetiAutoId":60510,"eetiGuid":"8754AD0E-F0EC-4C75-9ACF-C85C83554585","eetiTiName":"35","eetiTiIsCorrect":1},{"eetiAutoId":60511,"eetiGuid":"E61F4CD7-D047-4443-881D-DDE393CC64CA","eetiTiName":"137","eetiTiIsCorrect":1},{"eetiAutoId":60512,"eetiGuid":"6E7A9635-8166-4954-9F79-B07D10FCE184","eetiTiName":"161","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18192,"eetGuid":"57DD3E23-032F-48EE-B30D-4E4CDAB4FD04","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"286、正确答案是32、45、133、172","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60597,"eetiGuid":"D88551ED-F581-4CA5-92B8-ED277669FB36","eetiTiName":"32","eetiTiIsCorrect":1},{"eetiAutoId":60598,"eetiGuid":"EB682930-101A-407C-A8E0-F5380A5B8FBF","eetiTiName":"45","eetiTiIsCorrect":1},{"eetiAutoId":60599,"eetiGuid":"74C8DFA6-7428-4C4C-8BD8-C2ACE09434F6","eetiTiName":"133","eetiTiIsCorrect":1},{"eetiAutoId":60600,"eetiGuid":"D05E7A47-714F-49BA-B199-887F89BAB5D5","eetiTiName":"172","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18123,"eetGuid":"5717CF35-61BA-4219-9306-8D88AEFCF980","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"217、正确答案是98、163","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60321,"eetiGuid":"C55F5E40-F01F-4441-8CB0-107DAD2535E9","eetiTiName":"36","eetiTiIsCorrect":-1},{"eetiAutoId":60322,"eetiGuid":"361AC02A-12CF-4EF4-B3F7-B6EE5C56B40C","eetiTiName":"98","eetiTiIsCorrect":1},{"eetiAutoId":60323,"eetiGuid":"6C684220-114A-4D6E-B95C-7841095E535E","eetiTiName":"141","eetiTiIsCorrect":-1},{"eetiAutoId":60324,"eetiGuid":"A130F85D-AE45-45D7-964D-146CACC282C9","eetiTiName":"163","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18178,"eetGuid":"FF2CB132-BF88-4313-8034-FB3C8F2BA0EF","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"272、正确答案是41、195","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60541,"eetiGuid":"0B4BFE72-D103-4B28-884B-0DCED3B4534F","eetiTiName":"41","eetiTiIsCorrect":1},{"eetiAutoId":60542,"eetiGuid":"4042769A-3BF4-41B6-9F6B-31DAB37D0482","eetiTiName":"53","eetiTiIsCorrect":-1},{"eetiAutoId":60543,"eetiGuid":"43F485C0-2AC0-4118-97B5-5DBF2026934E","eetiTiName":"128","eetiTiIsCorrect":-1},{"eetiAutoId":60544,"eetiGuid":"0BE912FA-DDAB-4215-B08E-D2C40FDA0040","eetiTiName":"195","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18112,"eetGuid":"89BA7BC5-F378-49C9-8F46-98E7C81B09B7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"206、正确答案是33、101、164","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60277,"eetiGuid":"1797A713-4A12-4C9E-B93D-50838FD9B400","eetiTiName":"33","eetiTiIsCorrect":1},{"eetiAutoId":60278,"eetiGuid":"E1835E7D-37A6-45DA-941B-634C7EBB2024","eetiTiName":"39","eetiTiIsCorrect":-1},{"eetiAutoId":60279,"eetiGuid":"D28FADE9-1101-4486-BD93-C9CA93D13CE0","eetiTiName":"101","eetiTiIsCorrect":1},{"eetiAutoId":60280,"eetiGuid":"D4A88DC2-968C-4D1A-9C9B-424780E483B6","eetiTiName":"164","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18124,"eetGuid":"FE3E4B0B-6381-49F0-B6A0-DEB550A3EC62","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"218、正确答案是191","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60325,"eetiGuid":"65FD5F98-F4F7-43CB-95B6-09B595457DB2","eetiTiName":"41","eetiTiIsCorrect":-1},{"eetiAutoId":60326,"eetiGuid":"93A37CBD-282B-4A14-B772-C1AAD922AD01","eetiTiName":"98","eetiTiIsCorrect":-1},{"eetiAutoId":60327,"eetiGuid":"A1881EEE-EDA5-4149-9824-B5C3A1CC6B10","eetiTiName":"120","eetiTiIsCorrect":-1},{"eetiAutoId":60328,"eetiGuid":"91966367-0830-49AB-A70C-68C08A82D892","eetiTiName":"191","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18186,"eetGuid":"76EEABBE-2742-4C1B-958E-4A8F23B858B3","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"280、正确答案是32、92","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60573,"eetiGuid":"402DED53-EE21-4877-8F3D-75B89908B256","eetiTiName":"32","eetiTiIsCorrect":1},{"eetiAutoId":60574,"eetiGuid":"B1C8CEC5-722B-452F-B5DC-DF59837C9F08","eetiTiName":"48","eetiTiIsCorrect":-1},{"eetiAutoId":60575,"eetiGuid":"FC742CC3-08E8-4615-9A64-50D426C3328B","eetiTiName":"92","eetiTiIsCorrect":1},{"eetiAutoId":60576,"eetiGuid":"18059D23-37A1-4F79-867A-62772C51E627","eetiTiName":"152","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18111,"eetGuid":"BA2D4E5A-AD03-4FFB-9492-66532CC1BB29","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"205、正确答案是10、86、150","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60273,"eetiGuid":"71982904-C2A9-4832-97AD-2BD2E56DF594","eetiTiName":"10","eetiTiIsCorrect":1},{"eetiAutoId":60274,"eetiGuid":"831B405B-86ED-486B-B8E5-86B394966C10","eetiTiName":"86","eetiTiIsCorrect":1},{"eetiAutoId":60275,"eetiGuid":"5306ABD6-97F9-46B6-B412-5DCF66F273B1","eetiTiName":"150","eetiTiIsCorrect":1},{"eetiAutoId":60276,"eetiGuid":"20A05DEA-316F-4AD9-A4EE-9F8740FFEB4F","eetiTiName":"166","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18190,"eetGuid":"8F593F68-B2D5-417B-B7C4-51CE9E498AC7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"284、正确答案是41、69","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60589,"eetiGuid":"E0673DB2-D13C-4A97-9FB9-A4D64E665330","eetiTiName":"41","eetiTiIsCorrect":1},{"eetiAutoId":60590,"eetiGuid":"E85DA4D4-7A53-45B6-8F52-AA7FF110BC31","eetiTiName":"69","eetiTiIsCorrect":1},{"eetiAutoId":60591,"eetiGuid":"7B014BA2-8FF1-4299-A47A-01CDC5C97502","eetiTiName":"105","eetiTiIsCorrect":-1},{"eetiAutoId":60592,"eetiGuid":"7F74F28C-DD43-4831-BB41-F1B8189DF59E","eetiTiName":"125","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18144,"eetGuid":"64162FA6-CB82-4E75-A33A-5AF32F3FCE56","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"238、正确答案是2、90","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60405,"eetiGuid":"FEFD8CC7-D7E2-4527-AF35-8222FFB78B07","eetiTiName":"2","eetiTiIsCorrect":1},{"eetiAutoId":60406,"eetiGuid":"B4AD85BD-D1DD-4C20-BBA6-4752DB62C96C","eetiTiName":"10","eetiTiIsCorrect":-1},{"eetiAutoId":60407,"eetiGuid":"64F1F141-493B-450A-B639-02A085144A9C","eetiTiName":"90","eetiTiIsCorrect":1},{"eetiAutoId":60408,"eetiGuid":"976FBF22-C479-4CB3-8DA9-77153336394D","eetiTiName":"200","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18177,"eetGuid":"2C901D5D-FC94-4366-A744-E0225EA8DED2","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"271、正确答案是49、145、183","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60537,"eetiGuid":"169880AA-C79D-4EA4-9032-1E853249B497","eetiTiName":"49","eetiTiIsCorrect":1},{"eetiAutoId":60538,"eetiGuid":"04D05F80-4800-470B-94BE-4EBD7E4CC9D7","eetiTiName":"69","eetiTiIsCorrect":-1},{"eetiAutoId":60539,"eetiGuid":"01A5EA57-DD3D-4B85-80C1-2113EF1AA2E8","eetiTiName":"145","eetiTiIsCorrect":1},{"eetiAutoId":60540,"eetiGuid":"3A80F954-4CD3-4984-839C-316D0E3CF450","eetiTiName":"183","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18185,"eetGuid":"4B920DF3-BA19-40DC-8B25-6D837485215C","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"279、正确答案是38","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60569,"eetiGuid":"35E6C9CF-E093-4FEE-88EB-F6CAB7D7352E","eetiTiName":"38","eetiTiIsCorrect":1},{"eetiAutoId":60570,"eetiGuid":"CF9504EB-6647-4E1E-AC3B-19AC2CA100B4","eetiTiName":"39","eetiTiIsCorrect":-1},{"eetiAutoId":60571,"eetiGuid":"F6956B4B-39E2-43D3-8EA9-7F3E441EB9C8","eetiTiName":"49","eetiTiIsCorrect":-1},{"eetiAutoId":60572,"eetiGuid":"A2CB49E0-A9AD-480E-96ED-F5C4F8F2A93E","eetiTiName":"85","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18140,"eetGuid":"07A52907-51AB-405F-8F25-AC247194EA36","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"234、正确答案是5、40","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60389,"eetiGuid":"FA1EFE2F-16EA-4CBA-AF69-7CD62AC264AE","eetiTiName":"5","eetiTiIsCorrect":1},{"eetiAutoId":60390,"eetiGuid":"4E36A74B-E718-4B5F-8F94-ED19A60E5792","eetiTiName":"6","eetiTiIsCorrect":-1},{"eetiAutoId":60391,"eetiGuid":"27CC7476-83B8-4121-A4CE-FA4C7F3DC1C2","eetiTiName":"40","eetiTiIsCorrect":1},{"eetiAutoId":60392,"eetiGuid":"C5E66417-89BC-4525-8500-50376F466B24","eetiTiName":"137","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18184,"eetGuid":"2A2ECEC1-D235-48CF-B255-AF505248F3B8","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"278、正确答案是34、53","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60565,"eetiGuid":"73A8A53D-D309-4A1E-817A-487D5AB52B4F","eetiTiName":"8","eetiTiIsCorrect":-1},{"eetiAutoId":60566,"eetiGuid":"E89DEEBF-8CE9-412C-BB20-E004EF3CBC79","eetiTiName":"34","eetiTiIsCorrect":1},{"eetiAutoId":60567,"eetiGuid":"57969DF5-20EF-44CA-BBE5-B500E57D8A7E","eetiTiName":"53","eetiTiIsCorrect":1},{"eetiAutoId":60568,"eetiGuid":"7A7EC97E-E9EB-42DC-8B5E-0A7E8E25D479","eetiTiName":"141","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18157,"eetGuid":"E041DA07-C086-4FE5-BF44-7D32397AACA7","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"251、正确答案是31","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60457,"eetiGuid":"4B38D2C3-C30D-4C26-9A44-1E7D03370500","eetiTiName":"31","eetiTiIsCorrect":1},{"eetiAutoId":60458,"eetiGuid":"A3BB3199-BD8A-457F-967F-C416E2739068","eetiTiName":"35","eetiTiIsCorrect":-1},{"eetiAutoId":60459,"eetiGuid":"58A77ADC-CDE6-495A-B653-2F64C55CA2E2","eetiTiName":"100","eetiTiIsCorrect":-1},{"eetiAutoId":60460,"eetiGuid":"FEEAF81B-FAB2-47AE-BA39-E5F10BAFFD6C","eetiTiName":"167","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18155,"eetGuid":"5D2248EE-CD16-42AD-ADA7-A4490DB2F7A2","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"249、正确答案是28","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60449,"eetiGuid":"9FFF55E7-EF1E-43E7-A652-9FC8112901BE","eetiTiName":"28","eetiTiIsCorrect":1},{"eetiAutoId":60450,"eetiGuid":"AF7A3927-C0E0-4BE7-9414-1A5811D04FE2","eetiTiName":"78","eetiTiIsCorrect":-1},{"eetiAutoId":60451,"eetiGuid":"A16925DE-2C56-4227-9ABB-D2B4D9D5C088","eetiTiName":"129","eetiTiIsCorrect":-1},{"eetiAutoId":60452,"eetiGuid":"25EB5DEF-A659-4810-948A-CE19D116F09C","eetiTiName":"192","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18120,"eetGuid":"5353C4A4-CFE0-4BCC-B3B0-375F9F8A0D4D","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"214、正确答案是3、132","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60309,"eetiGuid":"2021191A-5031-4841-92DB-F92B5699B687","eetiTiName":"3","eetiTiIsCorrect":1},{"eetiAutoId":60310,"eetiGuid":"F58EF0E0-7728-4C21-9D1E-4404F82C9A74","eetiTiName":"85","eetiTiIsCorrect":-1},{"eetiAutoId":60311,"eetiGuid":"CD45B695-D05B-4D14-8798-3A26CFCA391B","eetiTiName":"132","eetiTiIsCorrect":1},{"eetiAutoId":60312,"eetiGuid":"6E452A6D-B0C0-401B-BF5B-B19BC5B205A6","eetiTiName":"185","eetiTiIsCorrect":-1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18193,"eetGuid":"246909E1-DE86-4FF4-8E5B-6CCE246E0451","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"287、正确答案是7、119、140","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60601,"eetiGuid":"CEEF9BFA-7550-4F06-BE85-8C52F1FA0136","eetiTiName":"7","eetiTiIsCorrect":1},{"eetiAutoId":60602,"eetiGuid":"4FBE1C4D-4D81-4F25-83C3-BEF5BFDBDED7","eetiTiName":"86","eetiTiIsCorrect":-1},{"eetiAutoId":60603,"eetiGuid":"15AEC183-6D95-45A2-9313-C0CE2B409C72","eetiTiName":"119","eetiTiIsCorrect":1},{"eetiAutoId":60604,"eetiGuid":"6526F2C4-D6D1-4FDD-8E7A-F9B270DBAAFB","eetiTiName":"140","eetiTiIsCorrect":1}],"resultItemBeans":[]},{"topicBean":{"eetAutoId":18182,"eetGuid":"31052D4A-27DF-4942-8159-92C4CBDA4B0B","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"276、正确答案是26、107","eetScore":1,"isCorrect":-1},"topicItemBeans":[{"eetiAutoId":60557,"eetiGuid":"A86BE2C1-139C-492D-8DFC-261C04C0DBBC","eetiTiName":"26","eetiTiIsCorrect":1},{"eetiAutoId":60558,"eetiGuid":"E8B9E2CC-344B-4552-BA9F-5DD0A31B8EB3","eetiTiName":"30","eetiTiIsCorrect":-1},{"eetiAutoId":60559,"eetiGuid":"40B83867-EB0E-4221-B47C-B5A857EDCB6F","eetiTiName":"97","eetiTiIsCorrect":-1},{"eetiAutoId":60560,"eetiGuid":"F55F0C87-B8E9-4BAD-BE45-3FC16A517F70","eetiTiName":"107","eetiTiIsCorrect":1}],"resultItemBeans":[]}]
         * code : 000000
         * content : 成功
         */

        private int allScore;
        private int myScore;
        private int isPass;
        private String isPassMsg;
        private String eeName;
        private int finishCount;
        private String useTime;
        private String speed;
        private int rightCount;
        private int errorCount;
        private String code;
        private String content;
        private List<ExamResultReturnBean> resultBeans;

        public int getAllScore() {
            return allScore;
        }

        public void setAllScore(int allScore) {
            this.allScore = allScore;
        }

        public int getMyScore() {
            return myScore;
        }

        public void setMyScore(int myScore) {
            this.myScore = myScore;
        }

        public int getIsPass() {
            return isPass;
        }

        public void setIsPass(int isPass) {
            this.isPass = isPass;
        }

        public String getIsPassMsg() {
            return isPassMsg;
        }

        public void setIsPassMsg(String isPassMsg) {
            this.isPassMsg = isPassMsg;
        }

        public String getEeName() {
            return eeName;
        }

        public void setEeName(String eeName) {
            this.eeName = eeName;
        }

        public int getFinishCount() {
            return finishCount;
        }

        public void setFinishCount(int finishCount) {
            this.finishCount = finishCount;
        }

        public String getUseTime() {
            return useTime;
        }

        public void setUseTime(String useTime) {
            this.useTime = useTime;
        }

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public int getRightCount() {
            return rightCount;
        }

        public void setRightCount(int rightCount) {
            this.rightCount = rightCount;
        }

        public int getErrorCount() {
            return errorCount;
        }

        public void setErrorCount(int errorCount) {
            this.errorCount = errorCount;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<ExamResultReturnBean> getResultBeans() {
            return resultBeans;
        }

        public void setResultBeans(List<ExamResultReturnBean> resultBeans) {
            this.resultBeans = resultBeans;
        }

        public static class ExamResultReturnBean {
            /**
             * topicBean : {"eetAutoId":18173,"eetGuid":"D196380E-A3BB-410B-92A5-2BC3F4083737","eetTtName":"不定项","eetTtType":"checkbox","eetTName":"267、正确答案是27、82、108、181","eetScore":1,"isCorrect":-1}
             * topicItemBeans : [{"eetiAutoId":60521,"eetiGuid":"2C7F872F-8A14-49C9-9143-1244C9546AB8","eetiTiName":"27","eetiTiIsCorrect":1},{"eetiAutoId":60522,"eetiGuid":"81E451B4-88F8-42C4-8ACF-B6479F29BCF8","eetiTiName":"82","eetiTiIsCorrect":1},{"eetiAutoId":60523,"eetiGuid":"62AD6193-C5D6-4B9D-A6EE-B1C29A90FAB9","eetiTiName":"108","eetiTiIsCorrect":1},{"eetiAutoId":60524,"eetiGuid":"D5E07BD0-DD98-48B0-BCCC-36EC44993D01","eetiTiName":"181","eetiTiIsCorrect":1}]
             * resultItemBeans : [{"eetiGuid":"81E451B4-88F8-42C4-8ACF-B6479F29BCF8","eetiTiGuid":"6CD7E040-0CD3-456C-9F3C-A81200CA1002","resultVal":"82"}]
             */

            private TopicBeanBean topicBean;
            private List<ExamTopicItemBean> topicItemBeans;
            private List<ExamResultItemBean> resultItemBeans;

            public TopicBeanBean getTopicBean() {
                return topicBean;
            }

            public void setTopicBean(TopicBeanBean topicBean) {
                this.topicBean = topicBean;
            }

            public List<ExamTopicItemBean> getTopicItemBeans() {
                return topicItemBeans;
            }

            public void setTopicItemBeans(List<ExamTopicItemBean> topicItemBeans) {
                this.topicItemBeans = topicItemBeans;
            }

            public List<ExamResultItemBean> getResultItemBeans() {
                return resultItemBeans;
            }

            public void setResultItemBeans(List<ExamResultItemBean> resultItemBeans) {
                this.resultItemBeans = resultItemBeans;
            }

            public static class TopicBeanBean {
                /**
                 * eetAutoId : 18173
                 * eetGuid : D196380E-A3BB-410B-92A5-2BC3F4083737
                 * eetTtName : 不定项
                 * eetTtType : checkbox
                 * eetTName : 267、正确答案是27、82、108、181
                 * eetScore : 1
                 * isCorrect : -1
                 */

                private int eetAutoId;
                private String eetGuid;
                private String eetTtName;
                private String eetTtType;
                private String eetTName;
                private int eetScore;
                private int isCorrect;

                public int getEetAutoId() {
                    return eetAutoId;
                }

                public void setEetAutoId(int eetAutoId) {
                    this.eetAutoId = eetAutoId;
                }

                public String getEetGuid() {
                    return eetGuid;
                }

                public void setEetGuid(String eetGuid) {
                    this.eetGuid = eetGuid;
                }

                public String getEetTtName() {
                    return eetTtName;
                }

                public void setEetTtName(String eetTtName) {
                    this.eetTtName = eetTtName;
                }

                public String getEetTtType() {
                    return eetTtType;
                }

                public void setEetTtType(String eetTtType) {
                    this.eetTtType = eetTtType;
                }

                public String getEetTName() {
                    return eetTName;
                }

                public void setEetTName(String eetTName) {
                    this.eetTName = eetTName;
                }

                public int getEetScore() {
                    return eetScore;
                }

                public void setEetScore(int eetScore) {
                    this.eetScore = eetScore;
                }

                public int getIsCorrect() {
                    return isCorrect;
                }

                public void setIsCorrect(int isCorrect) {
                    this.isCorrect = isCorrect;
                }
            }

            public static class ExamTopicItemBean {
                /**
                 * eetiAutoId : 60521
                 * eetiGuid : 2C7F872F-8A14-49C9-9143-1244C9546AB8
                 * eetiTiName : 27
                 * eetiTiIsCorrect : 1
                 */

                private int eetiAutoId;
                private String eetiGuid;
                private String eetiTiName;
                private int eetiTiIsCorrect;

                public int getEetiAutoId() {
                    return eetiAutoId;
                }

                public void setEetiAutoId(int eetiAutoId) {
                    this.eetiAutoId = eetiAutoId;
                }

                public String getEetiGuid() {
                    return eetiGuid;
                }

                public void setEetiGuid(String eetiGuid) {
                    this.eetiGuid = eetiGuid;
                }

                public String getEetiTiName() {
                    return eetiTiName;
                }

                public void setEetiTiName(String eetiTiName) {
                    this.eetiTiName = eetiTiName;
                }

                public int getEetiTiIsCorrect() {
                    return eetiTiIsCorrect;
                }

                public void setEetiTiIsCorrect(int eetiTiIsCorrect) {
                    this.eetiTiIsCorrect = eetiTiIsCorrect;
                }
            }

            public static class ExamResultItemBean {
                /**
                 * eetiGuid : 81E451B4-88F8-42C4-8ACF-B6479F29BCF8
                 * eetiTiGuid : 6CD7E040-0CD3-456C-9F3C-A81200CA1002
                 * resultVal : 82
                 */

                private String eetiGuid;
                private String eetiTiGuid;
                private String resultVal;

                public String getEetiGuid() {
                    return eetiGuid;
                }

                public void setEetiGuid(String eetiGuid) {
                    this.eetiGuid = eetiGuid;
                }

                public String getEetiTiGuid() {
                    return eetiTiGuid;
                }

                public void setEetiTiGuid(String eetiTiGuid) {
                    this.eetiTiGuid = eetiTiGuid;
                }

                public String getResultVal() {
                    return resultVal;
                }

                public void setResultVal(String resultVal) {
                    this.resultVal = resultVal;
                }
            }
        }
    }

}
