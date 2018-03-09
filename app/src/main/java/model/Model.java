package model;

import android.util.Log;

import com.example.jinmuyan.quarter.ApiService;

import java.util.Map;

import bean.CarouselBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import presenter.Presenter;
import utils.RetrofitUtils;
import view.IView;

/**
 * Created by TH on 2018/3/8.
 */

public class Model implements IModel {
    private static final String TAG = "model";
    private Presenter presenter;


    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {
        Log.e(TAG, "model层 " + map.toString());
        Flowable<CarouselBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).get(map);
        Log.e(TAG, "rxjava+retrofit请求数据 ");
        presenter.getData(flowable);
    }

    @Override
    public void getNearby(String baseurl, Map<String, String> map) {

    }


}
