package baseapp.task.activity.home;

import baseapp.task.BasePresenter;
import baseapp.task.BaseView;

/**
 * Created by Mr.ZCM on 2016/5/12.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:定义两个接口
 */
public interface HomeContract {
     interface View extends BaseView{
         void showLoading();
         void hideLoading();
         void loadSuccess(String title);
        //增加自己私有的功能
    }
     interface Presenter extends BasePresenter<View>{
        //加载主页面数据
         void loadData();
    }
}
