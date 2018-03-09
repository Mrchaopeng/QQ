package utils;

import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TH on 2018/3/8.
 */

public class RetrofitUtils {

    private final Retrofit build;
    private static volatile RetrofitUtils instance;
    public static  String URL = "https://www.zhaoapi.cn/";

    private RetrofitUtils(String baseurl){
        build = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    public static RetrofitUtils getInstance(String baseurl){
        if (instance == null){
            synchronized (RetrofitUtils.class){
                if (instance == null){
                    instance = new RetrofitUtils(baseurl);
                }
            }
        }
        return instance;
    }

    public Retrofit getretrofit(){
        return build;
    }
}
