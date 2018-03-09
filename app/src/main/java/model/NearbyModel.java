package model;

import android.util.Log;

import com.example.jinmuyan.quarter.ApiService;

import java.util.Map;

import bean.CarouselBean;
import bean.NearbyBean;
import io.reactivex.Flowable;
import presenter.NearbyPresenter;
import presenter.Presenter;
import utils.RetrofitUtils;

/**
 * Created by TH on 2018/3/9.
 */

public class NearbyModel implements IModel{
    private static final String TAG = "model";
    private NearbyPresenter nearbyPresenter;

    public NearbyModel(NearbyPresenter nearbyPresenter) {
        this.nearbyPresenter = nearbyPresenter;
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {

    }

    @Override
    public void getNearby(String baseurl, Map<String, String> map) {
        Log.e(TAG, "model层 " + map.toString());
        Flowable<NearbyBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).getNearby(map);
        Log.e(TAG, "rxjava+retrofit请求数据 ");
        nearbyPresenter.getData(flowable);
    }
}
