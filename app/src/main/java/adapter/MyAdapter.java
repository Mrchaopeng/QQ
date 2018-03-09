package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import fragment.HotFragment;
import fragment.NoticeFragment;

/**
 * Created by TH on 2018/3/8.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private FragmentManager childFragmentManager;
    private List<String> datas;

    public MyAdapter(FragmentManager fm, List<String> datas) {
        super(fm);
        this.childFragmentManager = childFragmentManager;
        this.datas = datas;
    }

    //返回选项卡的文本 ，，，添加选项卡
    @Override
    public CharSequence getPageTitle(int position) {
        return datas.get(position);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                f = new HotFragment();//热门
                break;
            case 1:
                f = new NoticeFragment();//关注
                break;

        }

        return f;
    }

    @Override
    public int getCount() {
        return datas.size();//返回选项卡的数量

    }
}
