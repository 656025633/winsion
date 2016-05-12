package baseapp.task;

/**
 * Created by Mr.ZCM on 2016/5/12.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:定义共有的方法
 */
public interface BasePresenter <T extends BaseView>{
    public void attachView(T view);
    public void detachView();
}
