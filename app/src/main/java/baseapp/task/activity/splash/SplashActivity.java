package baseapp.task.activity.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import baseapp.R;
import baseapp.task.BaseActivity;
import baseapp.task.activity.tutorial.TutorialActivity;
import baseapp.utils.SPUtils;


public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 100) {
                //判断引导页
                boolean showTutorial = (boolean) SPUtils.get(SplashActivity.this, "FirstEnter", true);
                if (showTutorial) {
                    SPUtils.put(SplashActivity.this, "FirstEnter", false);
                    Intent intent = new Intent(SplashActivity.this, TutorialActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }
    };

    @Override
    protected void beforeView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void obtainIntent() {
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        //
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            handler.sendEmptyMessage(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
