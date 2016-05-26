package baseapp.task.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import baseapp.R;
import baseapp.task.BaseActivity;
import baseapp.task.activity.preference.MyPeferenceActivity;
import baseapp.utils.T;
import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.View {


    @Bind(R.id.content)
    TextView mContent;
    @Bind(R.id.button)
    Button mButton;
    private HomePresent mPresent;

    @Override
    protected void beforeView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home2;
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
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MyPeferenceActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        //实现双方的对象获取
        mPresent = new HomePresent();
        mPresent.attachView(this);
        //调用persenter层获取数据
        mPresent.loadData();

    }

    @Override
    public void showLoading() {
        T.show(this,"正在请求数据",1);

    }

    @Override
    public void hideLoading() {
        T.show(this,"请求数据完毕",1);
    }

    @Override
    public void loadSuccess(String title) {
        mContent.setText(title);
    }
}
