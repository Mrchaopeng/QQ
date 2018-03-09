package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinmuyan.quarter.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;

/**
 * Created by TH on 2018/3/8.
 */

public class RecommendFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas=new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend, null);

        tabLayout = view.findViewById(R.id.tas);
        viewPager = view.findViewById(R.id.vp);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //向集合中添加数据
        datas.add("热门");
        datas.add("关注");
        //设置适配器
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager(),datas));
        //进行关联
        tabLayout.setupWithViewPager(viewPager);
    }
}
