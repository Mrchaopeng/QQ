package presenter;

import java.util.Map;

/**
 * Created by TH on 2018/3/8.
 */

public interface IPresenter {
    void get(String baseurl, Map<String,String> map);
    void getNearby(String baseurl, Map<String,String> map);
}
