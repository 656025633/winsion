package baseapp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zcm on 2016/4/7.
 * qq:656025633
 */
public class CommonPagerAdapter extends PagerAdapter {
    private List<View> views;

    @Override
    public int getCount() {
        int ret = 0;
        if (views != null) {
            ret = views.size();
        }
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    public CommonPagerAdapter(List<View> views) {
        super();
        this.views = views;
    }
}
