package com.rfchina.internet.mytestapp.printer;

import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luoyican on 2017/8/3.
 */

public class LDAPUtil {
//    private LDAPConnection c ;
//    private AddRequest addRequest;
//
//    //String address="ldap://server1.mydomain.com" ;
//    String address="192.168.18.95";
//    int port=61093;
//    //String bindDN="CN=name,CN=users,DC=mydomain,DC=com";
//    String bindDN="cn=Manager,dc=maxcrc,dc=com";
//    String password="secret";
//    boolean login_flag=true;
//    public void connet() {
//        try {
//            c = new LDAPConnection(address, port, bindDN, password);
//            c.setConnectionName("Demo Connection");
//            String con_name = c.getConnectionName();
//            long time = c.getConnectTime();
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
//            String dateString = formatter.format(new Date(time));
//            Toast.makeText(getBaseContext(), "Connected to LDAP server....connection_name=" + con_name + " at time" + dateString, Toast.LENGTH_LONG).show();
//
//        } catch (LDAPException e) {
//            login_flag = false;
//            e.printStackTrace();
//            Toast.makeText(getBaseContext(), "No connection was established", Toast.LENGTH_LONG).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (login_flag) {
//                c.close();
//                Toast.makeText(getBaseContext(), "Connection Closed successfully", Toast.LENGTH_LONG).show();
//            }
//        }
//    }
}
