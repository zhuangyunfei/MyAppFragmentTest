package com.example.myappfragmenttest;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =findViewById(R.id.button_Add);
        Button button1 = findViewById(R.id.button_change);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Add:
                addFragment();
                break;
            case R.id.button_change:
                replaceFragment1to3();
                break;
                default:
                    break;
        }
    }

    private void addFragment(){
        //第一步 获取FragmentManager实例
        FragmentManager fragmentManager = getSupportFragmentManager();
        //第二步 获取事务实例
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //第三步实例化Fragment
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        //向指定的Fragment Id中进行添加FragmentUI
        fragmentTransaction.add(R.id.fragment_future,fragmentOne);
        fragmentTransaction.add(R.id.fragment2,fragmentTwo);
        fragmentTransaction.commit();
    }
    private void replaceFragment1to3(){
        //第一步获取FragmentManager实例
        FragmentManager fragmentManager1 =getSupportFragmentManager();
        //获取开启事务的实例
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        FragmentThree fragmentThree = new FragmentThree();
        //添加具体的事务内容：执行替换Fragment
        fragmentTransaction1.replace(R.id.fragment_future,fragmentThree);
        fragmentTransaction1.commit();
    }
    //销毁活动

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
