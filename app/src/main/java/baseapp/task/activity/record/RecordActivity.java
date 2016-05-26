package baseapp.task.activity.record;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;

import baseapp.R;
import baseapp.task.BaseActivity;
import butterknife.Bind;

/**
 * 现场记录功能
 * 1。录音
 * 2.录像
 * 3.拍照
 */

public class RecordActivity extends BaseActivity {


    @Bind(R.id.record)
    Button mRecord;
    @Bind(R.id.movie)
    Button mMovie;
    @Bind(R.id.photo)
    Button mPhoto;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

    @Override
    protected void beforeView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    protected void obtainIntent() {

    }

    @Override
    protected void initView(Bundle saveInstanceState) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
