/*
package baseapp.utils;

*/
/**
 * Created by zcm on 2016/4/8.
 * qq:656025633
 *//*


import android.content.Context;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ConflictAlgorithm;

import java.util.ArrayList;
import java.util.List;

import wxrt.baseapp.bean.Conversation;

*/
/**
 * Created by zcm on 2016/4/8.
 * qq:656025633
 *//*

public class LiteOrmDBUtil {

    public static String DB_NAME;
    public static LiteOrm liteOrm;

    public static void createDb(Context _activity,Object userId){
        DB_NAME = "pinme_"+ userId.toString() +".db";
        liteOrm = LiteOrm.newCascadeInstance(_activity, DB_NAME);
        liteOrm.setDebugged(true);
    }


    public static LiteOrm getLiteOrm(){
        return liteOrm;
    }

    */
/**
     * 插入一条记录
     * @param t
     *//*

    public static <T> void insert(T t){
        liteOrm.save(t);
    }

    */
/**
     * 插入所有记录
     * @param list
     *//*

    public static <T> void insertAll(List<T> list){
        liteOrm.save(list);
    }

    */
/**
     * 查询所有
     * @param cla
     * @return
     *//*

    public static <T> List<T> getQueryAll(Class<T> cla){
        return liteOrm.query(cla);
    }

    */
/**
     * 查询  某字段 等于 Value的值
     * @param cla
     * @param field
     * @param value
     * @return
     *//*

    public static <T> List<T> getQueryByWhere(Class<T> cla,String field,String [] value){
        return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value));
    }

    */
/**
     * 查询  某字段 等于 Value的值  可以指定从1-20，就是分页
     * @param cla
     * @param field
     * @param value
     * @param start
     * @param length
     * @return
     *//*

    public static <T> List<T> getQueryByWhereLength(Class<T> cla,String field,String [] value,int start,int length){
        return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value).limit(start, length));
    }

    */
/**
     * 删除所有 某字段等于 Vlaue的值
     * @param cla
     * @param field
     * @param value
     *//*

    public static <T> void deleteWhere(Class<T> cla,String field,String [] value){
        liteOrm.delete(cla, WhereBuilder.create(cla).where(field + "=?", value));
    }

    */
/**
     * 删除所有
     * @param cla
     *//*

    public static <T> void deleteAll(Class<T> cla){
        liteOrm.deleteAll(cla);
    }

    */
/**
     * 仅在以存在时更新
     * @param t
     *//*

    public static <T> void update(T t){
        liteOrm.update(t, ConflictAlgorithm.Replace);
    }


    public static <T> void updateALL(List<T> list){
        liteOrm.update(list);
    }


    public static void Text(){

        //我们把这个对象当做以填充数据的后的对象
        Conversation mConversation = new Conversation();

        List<Conversation> list = new ArrayList<Conversation>();
        for (int i = 0; i < 10; i++) {
            list.add(mConversation);
        }
*/
/*

        //1、插入单条数据
        LiteOrmDBUtil.insert(mConversation);

        //2、插入多条数据
        LiteOrmDBUtil.insertAll(list);

        //3、查询Conversation表中所有记录
        List<Conversation> list = LiteOrmDBUtil.getQueryAll(Conversation.class);

        //4、查询Conversation表中 isVisibility 字段 等于 true 的记录
        List<Conversation> list =  LiteOrmDBUtil.getQueryByWhere(Conversation.class, Conversation.ISVISIBILITY, new String[]{"true"});

        //5、查询Conversation表中 isVisibility 字段 等于 true 的记录,并且只取20条
        List<Conversation> list =  LiteOrmDBUtil.getQueryByWhereLength(Conversation.class, Conversation.ISVISIBILITY, new String[]{"true"},0,20);

        //6、删除Conversation表中 isVisibility 字段 等于 true 的记录
        LiteOrmDBUtil.deleteWhere(Conversation.class,Conversation.ISVISIBILITY , new String[]{"true"});

        //7、删除所有
        LiteOrmDBUtil.deleteAll(Conversation.class);*//*



    }

}*/
