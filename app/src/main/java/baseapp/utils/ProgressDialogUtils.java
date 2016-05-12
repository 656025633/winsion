package baseapp.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Mr.ZCM on 2016/5/9.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explain:   不显示选装
 */
public class ProgressDialogUtils {
    //private static  Progress pd;
    static ProgressDialog pd = null;
    public static  void showProgress(Context context){
        pd = new ProgressDialog(context);

        // 设置进度条风格，风格为圆形，旋转的
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // 设置ProgressDialog 标题
        pd.setTitle("提示");

        // 设置ProgressDialog 提示信息
        pd.setMessage("这是一个圆形进度条对话框");

        // 设置ProgressDialog 标题图标
     //   pd.setIcon(R.drawable.img1);

        // 设置ProgressDialog 的进度条是否不明确
        pd.setIndeterminate(false);

        // 设置ProgressDialog 是否可以按退回按键取消
        pd.setCancelable(true);

        // 设置ProgressDialog 的一个Button
        pd.setButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i)
            {
                //点击“确定按钮”取消对话框
                dialog.cancel();
            }
        });

        // 让ProgressDialog显示
        pd.show();
    }
}
