package com.bawei.jiaoshang0119.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiaoshang0119.R;
import com.bawei.jiaoshang0119.bean.LoginBean;
import com.bawei.jiaoshang0119.retrofit.MyApp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.simple)
    ImageView simple;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.wang)
    TextView wang;
    @BindView(R.id.zhu)
    TextView zhu;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.zhu, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhu:
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                String p = phone.getText().toString().trim();
                String pa = pass.getText().toString().trim();
                MyApp.inters.getLogin(p,pa).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(LoginBean loginBean) {
                                String code = loginBean.getCode();
                                if (code.equals("0")){
                                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, XingActivity.class);
                                    int uid = loginBean.getData().getUid();
                                    SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor edit = sp.edit();
                                    edit.putInt("uid", uid);
                                    edit.commit();
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
        }
    }
}

