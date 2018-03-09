package presenter;

import java.util.Map;

import bean.NearbyBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import model.NearbyModel;
import view.IView;

/**
 * Created by TH on 2018/3/9.
 */

public class NearbyPresenter implements IPresenter {

    private IView iView;
    private DisposableSubscriber subscriber;
    private final NearbyModel nearbyModel;

    public NearbyPresenter(IView iView) {
        this.iView = iView;
        nearbyModel = new NearbyModel(this);
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {

    }

    @Override
    public void getNearby(String baseurl, Map<String, String> map) {

        nearbyModel.getNearby(baseurl,map);

    }

    public void getData(Flowable flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        iView.onSuccess(o);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iView.onFailed((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




        //防止内存泄漏
        public void detatch(){
            if (iView != null) {
                iView = null;
            }
            if(subscriber!=null){
                if(!subscriber.isDisposed()){
                    subscriber.dispose();
                }
            }
        }


}

