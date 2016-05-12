package baseapp.task.activity.home;

import baseapp.bean.DouBean;
import baseapp.utils.RetrofitUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mr.ZCM on 2016/5/12.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:
 */
public class HomePresent implements HomeContract.Presenter{
    private HomeContract.View view;


    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    /**
     * 加载网络数据
     */
    @Override
    public void loadData() {
        view.showLoading();
        RetrofitUtil.getApiService().getDouNews(0,10).enqueue(new Callback<DouBean>() {
            @Override
            public void onResponse(Call<DouBean> call, Response<DouBean> response) {
                String title = response.body().getTitle();
                view.loadSuccess(title);
                view.hideLoading();
            }
            @Override
            public void onFailure(Call<DouBean> call, Throwable t) {

            }
        });

    }
}
