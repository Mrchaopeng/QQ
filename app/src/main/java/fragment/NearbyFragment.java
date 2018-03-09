package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.jinmuyan.quarter.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyAdapter;
import adapter.NearVideoAdapter;
import bean.NearbyBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.NearbyPresenter;
import view.IView;

/**
 * Created by TH on 2018/3/8.
 */

public class NearbyFragment extends Fragment implements IView {
    @BindView(R.id.NearbyRv)
    RecyclerView NearbyRv;
    Unbinder unbinder;

    private static String Token = "9324560022837E20C8D3A08C51F11EB7";
    private List<NearbyBean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nearby, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        NearbyPresenter nearbyPresenter = new NearbyPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("token",Token);
        map.put("source","android");
        map.put("appVersion","101");
        nearbyPresenter.getNearby("https://www.zhaoapi.cn/",map);
    }

    @Override
    public void onSuccess(Object o) {

        NearbyBean nearbyBean = (NearbyBean) o;
        data = nearbyBean.getData();

        //瀑布流布局管理器
        NearbyRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //设置适配器
        NearVideoAdapter nearVideoAdapter = new NearVideoAdapter(getActivity(),data);
        NearbyRv.setAdapter(nearVideoAdapter);




    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



}
