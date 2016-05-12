package baseapp.task;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import baseapp.utils.ActivityControlUtil;


/**
 * Created by zcm on 2016/4/1.
 * qq:656025633
 */
public abstract  class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeView();
        setContentView(getLayoutId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.parseColor("#FF4081"));
        obtainIntent();
        initView(savedInstanceState);
        initListener();
        initData();
        //添加集合
        ActivityControlUtil.addActivity(this);
    }
    //setting title and so on
    protected abstract void beforeView();
    //get layout id
    protected abstract  int getLayoutId();
    //get intent
    protected abstract void obtainIntent();
    //get view
    protected abstract void initView(Bundle saveInstanceState);
    //set listener
    protected abstract void initListener();
    //set data
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //退出activity
        ActivityControlUtil.removeActivity(this);
    }
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
