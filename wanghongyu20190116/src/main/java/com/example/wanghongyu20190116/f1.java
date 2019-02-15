package com.example.wanghongyu20190116;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

public class f1 extends Fragment {
    private ArrayList<Fragment> fragmentss = new ArrayList<Fragment>();
    private List<String> lists = new ArrayList<String>();
    private ViewPager View1;
    private MPadapter padapter;
    private TabLayout tableLayout;
    private Banner banner;
    //第一个数组是所有的图片链接
    private List list_path = new ArrayList();
    //这个是说有的标题
    private List list_title = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_f1, container, false);
        //轮播图
        banner = view.findViewById(R.id.banner);
        setTabLaout(view);

        return view;
    }

    private void setTabLaout(View view) {
        tableLayout = view.findViewById(R.id.TmabLayout);
        ViewPager viewPager = view.findViewById(R.id.View1);
        iniData();
        inidate();
        MPadapter padapter = new MPadapter(getChildFragmentManager(), fragmentss, lists);
        viewPager.setAdapter(padapter);
        //滚动
        tableLayout.setTabMode(TabLayout.FOCUSABLES_TOUCH_MODE);
        //关联
        tableLayout.setupWithViewPager(viewPager);


    }


    private void iniData() {
        for (int i = 0; i < 3; i++) {
            fragmentss.add(new fr1());
            fragmentss.add(new fr2());
            fragmentss.add(new fr3());

            lists.add("视频");
            lists.add("动漫");
            lists.add("新闻");
        }
    }

    private void inidate() {
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201410%2F05%2F20141005082835_2RTzn.thumb.700_0.jpeg&thumburl=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3846895839%2C2711067435%26fm%3D26%26gp%3D0.jpg");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");

        //样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //
        banner.setImageLoader(new GlideImageLoader());
        //加载图片
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.RotateDown);
        //加载标题
        banner.setBannerTitles(list_title);
        banner.setDelayTime(1500);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

    }

    private class GlideImageLoader implements ImageLoaderInterface {

        @Override
        public void displayImage(Context context, Object path, View imageView) {
            Glide.with(context).load((String) path).into((ImageView) imageView);
        }

        @Override
        public View createImageView(Context context) {
            return null;
        }


    }
}