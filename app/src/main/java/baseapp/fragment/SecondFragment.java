package baseapp.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import baseapp.R;
import baseapp.task.BaseFragment;
import baseapp.views.CustomViewPager;
import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends BaseFragment {
    @Bind(R.id.mViewPager)
    ViewPager mMViewPager;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public void initView(View view) {
         ButterKnife.bind(this,view);
        CustomViewPager customViewPager = new CustomViewPager(getActivity(),mMViewPager);
    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
