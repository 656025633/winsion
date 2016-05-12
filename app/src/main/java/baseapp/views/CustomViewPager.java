package baseapp.views;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import baseapp.R;


/**
 * Created by Mr.ZCM on 2016/5/6.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:自定义
 */
public class CustomViewPager {
    private ViewPager mViewPager;
    private Context context;
    private List<View> mViews;
    private Timer mTimer = new Timer();
    private int mBannerPosition = 0;
    private final int FAKE_BANNER_SIZE = 100;
    private final int DEFAULT_BANNER_SIZE = 5;
    private boolean mIsUserTouched = false;
    private BannerAdapter mBannerAdapter;

    public CustomViewPager(Context context,ViewPager viewPager){
        this.mViewPager = viewPager;
        this.context = context;
        mViews = new ArrayList<>();
        setViewPager();
    }
    private void setViewPager() {
        //
        for (int i = 0; i < 5; i++) {
            ImageView view1 = new ImageView(context);
            Glide.with(context).load("http://img0.bdstatic.com/img/image/shouye/xiaoxiao/%E5%8A%A8%E6%BC%AB%E9%BB%84.jpg").into(view1);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            view1.setLayoutParams(params);
            mViews.add(view1);
        }
        mBannerAdapter = new BannerAdapter(context);
        mViewPager.setAdapter(new BannerAdapter(context));
        mViewPager.setOnPageChangeListener(mBannerAdapter);
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN
                        || action == MotionEvent.ACTION_MOVE) {
                    mIsUserTouched = true;
                } else if (action == MotionEvent.ACTION_UP) {
                    mIsUserTouched = false;
                }
                return false;
            }
        });


}

    private class BannerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

        private LayoutInflater mInflater;

        public BannerAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return FAKE_BANNER_SIZE;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= DEFAULT_BANNER_SIZE;
            View view = mInflater.inflate(R.layout.item, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            Glide.with(context).load("http://img0.bdstatic.com/img/image/shouye/xiaoxiao/%E5%8A%A8%E6%BC%AB%E9%BB%84.jpg").into(imageView);
            final int pos = position;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(MainActivity.this, "click banner item :" + pos, Toast.LENGTH_SHORT).show();    
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            int position = mViewPager.getCurrentItem();
            if (position == 0) {
                position = DEFAULT_BANNER_SIZE;
                mViewPager.setCurrentItem(position, false);
            } else if (position == FAKE_BANNER_SIZE - 1) {
                position = DEFAULT_BANNER_SIZE - 1;
                mViewPager.setCurrentItem(position, false);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            mBannerPosition = position;
        //    setIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
  /*  private void setIndicator(int position) {
        position %= DEFAULT_BANNER_SIZE;
        for(View indicator : mViews) {
            ImageView indicator1 = (ImageView)indicator;
            indicator1.setImageResource(R.mipmap.indicator_unchecked);
        }
        ((ImageView)mViews.get(position)).setImageResource(R.mipmap.indicator_checked);
    }*/
}
