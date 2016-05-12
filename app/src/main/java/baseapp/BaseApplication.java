package baseapp;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by zcm on 2016/4/1.
 * qq:656025633
 */
public class BaseApplication extends Application{
    private String TAG = "zcm";
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
        //返回RefWatcher对象，并检测所有activity的内存
        LeakCanary.install(this);
        Logger.init(TAG);

    }
}
