package presenter;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import model.Model;
import view.IView;

/**
 * Created by TH on 2018/3/8.
 */

public class Presenter implements IPresenter {

    private IView iView;
    private final Model model;
    private DisposableSubscriber subscriber;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model(this);
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {
        model.get(baseurl,map);
    }

    @Override
    public void getNearby(String baseurl, Map<String, String> map) {

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
