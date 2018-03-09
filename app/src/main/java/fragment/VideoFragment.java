package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinmuyan.quarter.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import adapter.MyVideoAdapter;

/**
 * Created by TH on 2018/3/8.
 */

public class VideoFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas=new ArrayList<String>();
    private TextView title_bar_tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video, null);

        tabLayout = view.findViewById(R.id.tas);
        viewPager = view.findViewById(R.id.vp);
        title_bar_tv = view.findViewById(R.id.title_bar_tv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // title_bar_tv.setText("视频");
        //向集合中添加数据
        datas.add("热门");
        datas.add("附近");
        //设置适配器
        viewPager.setAdapter(new MyVideoAdapter(getChildFragmentManager(),datas));
        //进行关联
        tabLayout.setupWithViewPager(viewPager);
    }
}
