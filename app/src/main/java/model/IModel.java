package model;

import java.util.Map;

/**
 * Created by TH on 2018/3/8.
 */

public interface IModel {
    void get(String baseurl, Map<String,String> map);
    void getNearby(String baseurl, Map<String,String> map);
}
