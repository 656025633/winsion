package baseapp.task.activity.tutorial;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import baseapp.R;
import baseapp.adapter.CommonPagerAdapter;
import baseapp.task.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TutorialActivity extends BaseActivity {
    @Bind(R.id.mViewPager)
    ViewPager mViewPager;
    private List<View> views;

    @Override
    protected void beforeView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tutorial;
    }

    @Override
    protected void obtainIntent() {

    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        ButterKnife.bind(this);


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        views = new ArrayList<>();
        //
        for (int i = 0; i < 4; i++) {
            ImageView view1 = new ImageView(this);
            view1.setBackgroundResource(R.mipmap.tutorial);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            view1.setLayoutParams(params);
            if (i == 3) {
                //最后一页
                FrameLayout frame = new FrameLayout(this);
                FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
                frame.setLayoutParams(frameLayout);
                Button button = new Button(this);
                button.setText("进入主页面");
                FrameLayout.LayoutParams buttonparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                button.setLayoutParams(buttonparams);
                buttonparams.setMargins(10, 10, 10, 120);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //直接关闭即可
                        finish();
                    }
                });
                frame.addView(view1);
                frame.addView(button);
                views.add(frame);
            } else {
                views.add(view1);
            }

        }
        mViewPager.setAdapter(new CommonPagerAdapter(views));
    }
}
