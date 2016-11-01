package com.example.administrator.myconvenientbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bigkoo.convenientbanner.CBViewHolderCreator;
import com.bigkoo.convenientbanner.ConvenientBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConvenientBanner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setimg();
        banner = (ConvenientBanner) findViewById(R.id.convenientbanner);
        banner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                },localImages

        )
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                // .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
                // .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置翻页的效果，不需要翻页效果可用不设
                .setPageTransformer(ConvenientBanner.Transformer.BackgroundToForegroundTransformer);
//        convenientBanner.setManualPageable(false);//设置不能手动影响
//图片轮播
        banner.startTurning(3000);
    }
    //图片集合
    List<Integer> localImages = new ArrayList<Integer>();
    //集合添加数据
    public void setimg() {
        localImages.add(0, R.mipmap.start1);
        localImages.add(1, R.mipmap.start2);
        localImages.add(2, R.mipmap.start3);
        localImages.add(3, R.mipmap.start4);
    }
}
