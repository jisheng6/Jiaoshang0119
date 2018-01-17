package com.bawei.jiaoshang0119.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiaoshang0119.R;
import com.bawei.jiaoshang0119.bean.AddCartBean;
import com.bawei.jiaoshang0119.bean.EventBean;
import com.bawei.jiaoshang0119.model.AddCartModelCallBack;
import com.bawei.jiaoshang0119.present.AddCartPresenter;
import com.bawei.jiaoshang0119.retrofit.GlideImageLoader;
import com.bawei.jiaoshang0119.view.AddCartViewCallBack;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Adminjs on 2018/1/17.
 */

public class XiangQingActivity extends Activity implements AddCartModelCallBack, AddCartViewCallBack {
    @BindView(R.id.image)
    Banner uimage;
    @BindView(R.id.name)
    TextView uname;
    @BindView(R.id.uprice)
    TextView uprice;
    @BindView(R.id.jia)
    Button jia;
    @BindView(R.id.gou)
    Button gou;
    //  private String image1;
    private AddCartPresenter addCartPresenter;
    //  private String pid1;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String url="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
    private String image1;
    private String pid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);

        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        jcVideoPlayerStandard.setUp(url,jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"淘宝");

//        Bundle buddle = getIntent().getExtras();
//        pid1 = buddle.getString("pid");
//        image1 = buddle.getString("image");
//        String name1 = buddle.getString("name");
//        String price1 = buddle.getString("price");
//
//        final String[] split = this.image1.split("\\|");
//
//        uimage.setImageLoader(new GlideImageLoader());
//        List<String> bannerList = new ArrayList<>();
//        for (int i = 0; i < split.length; i++) {
//            bannerList.add(split[i]);
//        }
//        uimage.setImages(bannerList);
//        uimage.start();
//        uname.setText(name1);
//        uprice.setText("￥"+ price1);
        EventBus.getDefault().register(this);

        addCartPresenter = new AddCartPresenter(this);

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                final int uid = sp.getInt("uid", 0);
                addCartPresenter.getData(pid1,uid+"");


            }
        });
    }
    @Subscribe(sticky = true)
    public void event(EventBean eventBean){
        pid1 = eventBean.getPid();
        image1 = eventBean.getImage();
        final String[] split = this.image1.split("\\|");
        uimage.setImageLoader(new GlideImageLoader());
        List<String> bannerList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            bannerList.add(split[i]);
        }
        uimage.setImages(bannerList);
        uimage.start();
        uname.setText(eventBean.getName());
        uprice.setText("￥"+eventBean.getPrice());
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //       JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void success(AddCartBean addCartBean) {
        Toast.makeText(this,""+addCartBean.getMsg(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(XiangQingActivity.this, GouActivity.class);
        startActivity(intent);
    }

    @Override
    public void failure() {
        Toast.makeText(this,""+"加入失败",Toast.LENGTH_LONG).show();

    }
}

