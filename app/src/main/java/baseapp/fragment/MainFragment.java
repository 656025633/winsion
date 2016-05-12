package baseapp.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import baseapp.R;
import baseapp.adapter.RecyclerViewAdapter;import baseapp.bean.DouBean;
import baseapp.task.BaseFragment;
import baseapp.utils.NetUtil;
import baseapp.utils.RetrofitUtil;
import baseapp.utils.T;
import baseapp.views.LoadMoreFooterView;
import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener, RecyclerViewAdapter.MyClickListener {
    /*   @Bind(R.id.swipe_refresh_header)
       RefreshHeaderView mSwipeRefreshHeader;*/
    @Bind(R.id.swipe_target)
    RecyclerView mSwipeTarget;
    @Bind(R.id.swipe_load_more_footer)
    LoadMoreFooterView mSwipeLoadMoreFooter;
    @Bind(R.id.swipeToLoadLayout)
    SwipeToLoadLayout mSwipeToLoadLayout;
    RecyclerViewAdapter mAdapter;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshlayout;
    private List<DouBean.SubjectsBean>  datas = new ArrayList<>();
    private int page = 0;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view) {
        ButterKnife.bind(this, view);
        mSwipeRefreshlayout.setColorSchemeResources(R.color.colorAccent);
    }

    @Override
    public void initListener(View view) {
        mSwipeRefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RetrofitUtil.getApiService(getActivity()).getDouNews(0,10).enqueue(new Callback<DouBean>() {
                    @Override
                    public void onResponse(Call<DouBean> call, Response<DouBean> response) {
                        List<DouBean.SubjectsBean> beans = response.body().getSubjects();
                        datas = beans;
                        mAdapter.clearData();
                        mAdapter.addData(beans);
                        mAdapter.notifyDataSetChanged();
                        mSwipeRefreshlayout.setRefreshing(false);

                    }

                    @Override
                    public void onFailure(Call<DouBean> call, Throwable t) {

                    }
                });

            }
        });
        //
        mSwipeRefreshlayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshlayout.setRefreshing(true);
            }
        });
        onRefresh();

    }

    CommonAdapter adapter;
    @Override
    public void initData() {
        mAdapter = new RecyclerViewAdapter(getActivity(), datas);
        mAdapter.setOnClickListener(this);
        // mSwipeTarget.setAdapter(mAdapter);
   /*     adapter = new CommonAdapter<DouBean.SubjectsBean>(getActivity(),R.layout.movieitem,datas) {
            @Override
            public void convert(ViewHolder holder, DouBean.SubjectsBean o) {
                holder.setText(R.id.tv_movieName,o.getTitle());
            }
          *//*  @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            }*//*
        }*/
        mSwipeTarget.setAdapter(mAdapter);
        mSwipeTarget.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeTarget.setItemAnimator(new SlideInDownAnimator());
        //   mSwipeTarget.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        //  mSwipeTarget.addItemDecoration();
        // mSwipeToLoadLayout.setOnRefreshListener(this);
        mSwipeToLoadLayout.setOnLoadMoreListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mSwipeRefreshlayout.isRefreshing()){
            mSwipeRefreshlayout.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {

        page = 0;
        RetrofitUtil.getApiService(getActivity()).getDouNews(page*10,10).enqueue(new Callback<DouBean>() {
            @Override
            public void onResponse(Call<DouBean> call, Response<DouBean> response) {
                List<DouBean.SubjectsBean> beans = response.body().getSubjects();
                mAdapter.addData(beans);
                mAdapter.notifyDataSetChanged();
                mSwipeRefreshlayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<DouBean> call, Throwable t) {
                page--;
                T.show(getActivity(),"加载数据失败",1);
            }
        });
    }

    @Override
    public void onLoadMore() {
        if(!NetUtil.isNetworkAvailable(getActivity())){
            T.show(getActivity(),"没有可用的网络",1);
            return ;
        }
        page ++;
        RetrofitUtil.getApiService(getActivity()).getDouNews(page*10,10).enqueue(new Callback<DouBean>() {
            @Override
            public void onResponse(Call<DouBean> call, Response<DouBean> response) {
                List<DouBean.SubjectsBean> beans = response.body().getSubjects();
                mAdapter.addData(beans);
                mAdapter.notifyDataSetChanged();
                mSwipeToLoadLayout.setLoadingMore(false);
            }

            @Override
            public void onFailure(Call<DouBean> call, Throwable t) {
                page--;
                T.show(getActivity(),"加载数据失败",1);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void setOnClickListener(View view, int position) {
        T.show(getActivity(),""+position,1);
        // DialogUtil.createDialog(getActivity());
    }

    @Override
    public void setOnLongClick(View view, int position) {

    }
}