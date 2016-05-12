package baseapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import baseapp.R;


/**
 * Created by Mr.ZCM on 2016/5/5.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 * explsin:dialog的创建是通过builder创建的，可以设置标题，内容，图标
 */
public class DialogUtil {
    //一般对话框
    public void createDialog(Context context,String title,String message){
        createDialog(context,title,message,"确定","取消");
    }

    /**
     *
     * @param context
     * @param title
     * @param message
     * @param confirm
     * @param cancle
     */
    public static void createDialog(final Context context,String title,String message,String confirm,String cancle){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message).setPositiveButton(confirm, new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                T.show(context,"确定",1);
            }
        }).setNegativeButton(cancle, new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                T.show(context,"取消",1);

            }
        });
        builder.create().show();
    }
    //列表对话框
    public void createListDialo(Context context,String items[]){
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("我是列表")
                .setItems(items, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
               builder.create().show();
    }
    
    //单选对话框
    public void createSingleDialog(Context context,final String items[]){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        builder.setSingleChoiceItems(items, 0, new OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       })
                .create().show();
    }
    //多选对话框
    public void createMultiDialog(Context context,String items[]){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        mBuilder.setTitle("")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .create()
                .show();

    }
}
