package baseapp.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import baseapp.api.ApiService;
import baseapp.constant.Constant;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zcm on 2016/4/6.
 * qq:656025633
 * Func：provider a Retrofit Object
 */
public class RetrofitUtil{
    private Context mContext;
    //定义共有的url
    private static ApiService apiService = new Retrofit
            .Builder()
            .baseUrl(Constant.DOU_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);


    private RetrofitUtil(){}
    public static ApiService getApiService(){
        return apiService;
    }


    //进行缓存的设置
    public static ApiService getApiService(final Context context){

      Interceptor interceptor = new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
              Request request = chain.request();
              if(!NetUtil.isNetworkAvailable(context)){
                  request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                  Log.d("random","no net");
              }
              Response response = chain.proceed(request);
              if (NetUtil.isNetworkAvailable(context)) {
                  int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
                  response.newBuilder()
                          .header("Cache-Control", "public, max-age=" + maxAge)
                          .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                          .build();
              } else {
                  int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周

                  response.newBuilder()
                          .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                          .removeHeader("Pragma")
                          .build();
              }
              return response;
          }
      };

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        //设置缓存 10M
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(5,TimeUnit.SECONDS )
                .cache(cache).build();
        ApiService apiService = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(Constant.DOU_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        return  apiService;
    }

}
