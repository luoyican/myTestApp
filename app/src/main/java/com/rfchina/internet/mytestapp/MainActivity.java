package com.rfchina.internet.mytestapp;

/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '&lt; `.___\_&lt;|&gt;_/___.' &gt;'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */


/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 *  O\ = /O
 * ___/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '&lt; `.___\_&lt;|&gt;_/___.' &gt;'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 *          .............................................
 *           佛曰：bug泛滥，我已瘫痪！
 */


/**
 *                                         ,s555SB@@&amp;
 *                                      :9H####@@@@@Xi
 *                                     1@@@@@@@@@@@@@@8
 *                                   ,8@@@@@@@@@B@@@@@@8
 *                                  :B@@@@X3hi8Bs;B@@@@@Ah,
 *             ,8i                  r@@@B:     1S ,M@@@@@@#8;
 *            1AB35.i:               X@@8 .   SGhr ,A@@@@@@@@S
 *            1@h31MX8                18Hhh3i .i3r ,A@@@@@@@@@5
 *            ;@&amp;i,58r5                 rGSS:     :B@@@@@@@@@@A
 *             1#i  . 9i                 hX.  .: .5@@@@@@@@@@@1
 *              sG1,  ,G53s.              9#Xi;hS5 3B@@@@@@@B1
 *               .h8h.,A@@@MXSs,           #@H1:    3ssSSX@1
 *               s ,@@@@@@@@@@@@Xhi,       r#@@X1s9M8    .GA981
 *               ,. rS8H#@@@@@@@@@@#HG51;.  .h31i;9@r    .8@@@@BS;i;
 *                .19AXXXAB@@@@@@@@@@@@@@#MHXG893hrX#XGGXM@@@@@@@@@@MS
 *                s@@MM@@@hsX#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&amp;,
 *              :GB@#3G@@Brs ,1GM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@B,
 *            .hM@@@#@@#MX 51  r;iSGAM@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@8
 *          :3B@@@@@@@@@@@&amp;9@h :Gs   .;sSXH@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:
 *      s&amp;HA#@@@@@@@@@@@@@@M89A;.8S.       ,r3@@@@@@@@@@@@@@@@@@@@@@@@@@@r
 *   ,13B@@@@@@@@@@@@@@@@@@@5 5B3 ;.         ;@@@@@@@@@@@@@@@@@@@@@@@@@@@i
 *  5#@@#&amp;@@@@@@@@@@@@@@@@@@9  .39:          ;@@@@@@@@@@@@@@@@@@@@@@@@@@@;
 *  9@@@X:MM@@@@@@@@@@@@@@@#;    ;31.         H@@@@@@@@@@@@@@@@@@@@@@@@@@:
 *   SH#@B9.rM@@@@@@@@@@@@@B       :.         3@@@@@@@@@@@@@@@@@@@@@@@@@@5
 *     ,:.   9@@@@@@@@@@@#HB5                 .M@@@@@@@@@@@@@@@@@@@@@@@@@B
 *           ,ssirhSM@&amp;1;i19911i,.             s@@@@@@@@@@@@@@@@@@@@@@@@@@S
 *              ,,,rHAri1h1rh&amp;@#353Sh:          8@@@@@@@@@@@@@@@@@@@@@@@@@#:
 *            .A3hH@#5S553&amp;@@#h   i:i9S          #@@@@@@@@@@@@@@@@@@@@@@@@@A.
 *
 *
 *    又看源码，看你妹啊！
 *
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.rfchina.internet.mytestapp.activitystartmodel.FirstActivity;
import com.rfchina.internet.mytestapp.activitystartmodel.IPCHelper;
import com.rfchina.internet.mytestapp.aliRecognition.AliRecognitionActivity;
import com.rfchina.internet.mytestapp.cornerlayout.CornerActivity;
import com.rfchina.internet.mytestapp.listview.ListviewActivity;
import com.rfchina.internet.mytestapp.loadLargeImage.LargeImagerLoadActivity;
import com.rfchina.internet.mytestapp.media.MediaActivity;
import com.rfchina.internet.mytestapp.mqtt.MQTTActivity;
import com.rfchina.internet.mytestapp.nestedscrolling.NestedScrollingActivity;
import com.rfchina.internet.mytestapp.okhttpmodel.OkHttpTestActivity;
import com.rfchina.internet.mytestapp.permission.PermissionActivity;
import com.rfchina.internet.mytestapp.printer.PrinterActivity;
import com.rfchina.internet.mytestapp.richtext.RichTextActivity;
import com.rfchina.internet.mytestapp.service.ServiceActivity;
import com.rfchina.internet.mytestapp.socket.TCPCLientActivity;
import com.rfchina.internet.mytestapp.subandgrouppackage.SubAndGroupPackageActivity;
import com.rfchina.internet.mytestapp.test.TestActivity;
import com.rfchina.internet.mytestapp.wheelView.ShowWheelActivity;
import com.rfchina.internet.mytestapp.wifiautoverification.WifiAutoVerificationActivity;
import com.rfchina.internet.mytestapp.wifiautoverification.WifiBroadcastReceiver;
import com.rfchina.internet.mytestapp.xfermode.XfermodeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;

    private List<Class> activities;
    private Class[] tmpAct = {TestActivity.class, CornerActivity.class, FirstActivity.class, ShowWheelActivity.class, XfermodeActivity.class,
            LargeImagerLoadActivity.class, OkHttpTestActivity.class, PrinterActivity.class, RichTextActivity.class, PermissionActivity.class,
            MediaActivity.class, ServiceActivity.class, AliRecognitionActivity.class, MQTTActivity.class, SubAndGroupPackageActivity.class,
            WifiAutoVerificationActivity.class, TCPCLientActivity.class, ListviewActivity.class,NestedScrollingActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listActivity);
        listView.setAdapter(new MainActivityAdapter(init()));
        connectWifi();
        IPCHelper.testNum = 33;
        Log.d("IPCHelper.testNum", "" + IPCHelper.testNum);
    }

    private List<Class> init() {
        activities = new ArrayList<>();
        for (Class a : tmpAct) {
            activities.add(a);
        }
        return activities;
    }

    private void connectWifi(){
        //目的就是为了保证(应用)Activity启动的时候马上广播进行连接,当进程不死，接收器不死
        Intent intent = new Intent(this, WifiBroadcastReceiver.class);
        intent.setAction("com.rfchina.internet.mytestapp");//无用，没做处理
        sendBroadcast(intent);
    }

}
