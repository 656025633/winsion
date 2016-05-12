package baseapp.api;

import baseapp.bean.DouBean;
import baseapp.bean.WeatherBean;
import baseapp.bean.ZhihuBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zcm on 2016/3/31.
 * qq:656025633
 * 存放接口
 * 1.http://www.weather.com.cn/data/sk/101010100.html
 */
public interface ApiService {
    /* @GET("/data/sk/101010100.html")
     Observable<WeatherBean> getWeathe();*/
    //https://api.douban.com/v2/movie/top250
    @GET("/data/sk/101010100.html")
    Call<WeatherBean> getWeathe();

    @GET("api/4/news/latest")
    Observable<ZhihuBean> getLatestNews();

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("v2/movie/top250")
    Call<DouBean> getDouNews(@Query("start") int start, @Query("count") int count);
}
