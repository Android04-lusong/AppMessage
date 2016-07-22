package com.ex.administrator.appmessage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ImageView mapp_image;
    TextView mapp_name,mapp_version;
    ArrayList mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_show);
        mapp_image = (ImageView) findViewById(R.id.app_image);
        mapp_name = (TextView) findViewById(R.id.app_name);
        mapp_version= (TextView) findViewById(R.id.app_version);
        init();


//        PackageManager manager=this.getPackageManager();

//        List<PackageInfo> packageInfoList =manager.getInstalledPackages(0);
//        mlist=new ArrayList();
//        for (int i = 0; i <packageInfoList.size() ; i++) {
//            PackageInfo packagei=packageInfoList.get(i);
//            ApplicationInfo info= packagei.applicationInfo;
//            if((info.flags&ApplicationInfo.FLAG_SYSTEM)<=0){
//                mlist.add(packagei);
//                for (int j = 0; j < mlist.size(); j++) {
//
//
//
//                }
//
//            }
//        }
    }

    private void init() {
        mapp_name = (TextView) findViewById(R.id.app_name);
        String applicationName = getAppName(this);
        mapp_name.setText("该应用名字:"+applicationName+"版本号"+getVerName());
    }
//    获取应用名
//    public String getVerName(){
//        PackageManager pm = null;
//        ApplicationInfo applicationInfo = null;
//
//        try {
//            pm = getPackageManager();
//            applicationInfo = pm.getApplicationInfo(getPackageName(), 0);
//        } catch (PackageManager.NameNotFoundException e) {
//            applicationInfo = null;
//        }
//        String applicationName = (String) pm.getApplicationLabel(applicationInfo);
//        return applicationName;
//    }
public String getVerName(){
    PackageManager pm = null;
    ApplicationInfo applicationInfo = null;

    try {
        pm = getPackageManager();
        applicationInfo = pm.getApplicationInfo(getPackageName(), 0);
    } catch (PackageManager.NameNotFoundException e) {
        applicationInfo = null;
    }
    String applicationName = (String) pm.getApplicationLabel(applicationInfo);
    return applicationName;
}
    /**
     * 获取App的名称
     * @param context 上下文
     * @return 名称
     */
    public static String getAppName(Context context){
        PackageManager pm=null;
        //获取包信息
        try {
            pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(),0);
            //获取应用 信息
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            //获取albelRes
            int labelRes = applicationInfo.labelRes;
            //返回App的名称
            return  context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
