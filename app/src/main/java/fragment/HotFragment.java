package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jinmuyan.quarter.MainActivity;
import com.example.jinmuyan.quarter.R;
import com.stx.xhb.xbanner.XBanner;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.CarouselBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import presenter.Presenter;
import retrofit2.http.Url;
import view.IView;

/**
 * Created by TH on 2018/3/8.
 */

public class HotFragment extends Fragment implements IView{
    @BindView(R.id.banner)
    XBanner banner;
    Unbinder unbinder;
    private View view;
    private Presenter presenter;
    private List<String> image = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new Presenter(this);
        Map<String, String> map = new HashMap<>();
        presenter.get("https://www.zhaoapi.cn/",map);



    }

    @Override
    public void onSuccess(Object o) {
        CarouselBean carouselBean = (CarouselBean) o;
        List<CarouselBean.DataBean> data = carouselBean.getData();
        for (int i = 0; i< data.size(); i++){
            String icon = data.get(i).getIcon();
            image.add(icon);
        }


        // 为XBanner绑定数据
        banner.setData(image,null);
        // XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(image.get(position)).into((ImageView) view);
            }
        });
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
