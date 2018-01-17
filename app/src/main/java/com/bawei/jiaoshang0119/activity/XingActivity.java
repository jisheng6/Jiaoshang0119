package com.bawei.jiaoshang0119.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.jiaoshang0119.R;
import com.bawei.jiaoshang0119.adapter.MyAdapter;
import com.bawei.jiaoshang0119.bean.Bean;
import com.bawei.jiaoshang0119.present.MainPresenter;
import com.bawei.jiaoshang0119.retrofit.OnItemClickListener;
import com.bawei.jiaoshang0119.view.MaView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2017/12/21.
 */

public class XingActivity extends Activity implements MaView {
    @BindView(R.id.recyclerview)
    RecyclerView recycler;
    private MainPresenter presenter;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xing);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.get();
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(manager);
        adapter = new MyAdapter(XingActivity.this);
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//               Intent intent = new Intent(MainActivity.this, PinActivity.class);
//               startActivity(intent);
            }
        });
    }

    @Override
    public void success(Bean bean) {
      adapter.addData(bean);
    }

    @Override
    public void failure() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
