package baseapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mr.ZCM on 2016/4/25.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 */
public class LoadMoreFooterView extends TextView implements SwipeTrigger, SwipeLoadMoreTrigger {
    public LoadMoreFooterView(Context context) {
        super(context);
    }

    public LoadMoreFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onLoadMore() {
    //    setText("上拉加载更多");
    }

    @Override
    public void onPrepare() {
        setText("");
    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd HH:mm:ss");
        String date = format.format(new Date());
        if (!isComplete) {
            if (yScrolled <= -getHeight()) {
                setText("松手刷新数据");
            } else {
                setText("上拉加载更多"+date);
            }
        } else {
            setText("正在加载数据");
        }
    }

    @Override
    public void onRelease() {
        setText("松手刷新数据");
    }

    @Override
    public void onComplete() {
        setText("加载完成");
    }

    @Override
    public void onReset() {
        setText("");
    }
}
