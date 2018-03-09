package com.example.jinmuyan.quarter;

import java.util.Map;

import bean.CarouselBean;
import bean.NearbyBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by TH on 2018/3/8.
 */

public interface ApiService {
    @GET("quarter/getAd")
    Flowable<CarouselBean> get(@QueryMap Map<String,String> map);
    @GET("quarter/getHotVideos")
    Flowable<CarouselBean> getHv(@QueryMap Map<String,String> map);
    @GET("quarter/getNearVideos")
    Flowable<NearbyBean> getNearby(@QueryMap Map<String,String> map);
}
