package view;

/**
 * Created by TH on 2018/3/8.
 */

public interface IView {
    void onSuccess(Object o);
    void onFailed(Exception e);
}
