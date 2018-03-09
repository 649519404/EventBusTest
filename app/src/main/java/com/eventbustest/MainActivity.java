package com.eventbustest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.GenericsEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public  class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            EventBus.getDefault().register(this);
        }

        public void reg(View view) {
            //通过构造函数注入RegisterInfo的类型
            GenericsEvent<String> genericsEvent = new GenericsEvent<>(String.class);
            genericsEvent.setData("注册成功");
            EventBus.getDefault().post(genericsEvent);
        }

        public void login(View view) {
            GenericsEvent<Integer> genericsEvent = new GenericsEvent<>(Integer.class);
            genericsEvent.setData(100);
            EventBus.getDefault().post(genericsEvent);
        }

        @SuppressWarnings({"unused","登陆成功之后回调"})
        @Subscribe(threadMode = ThreadMode.MAIN,genericsType = Integer.class)
        public void onLoginSuccess(GenericsEvent<Integer> event) {
            Log.d("event","login success"+event.getData());

        }

        @SuppressWarnings({"unused","注册成功之后回调"})
        @Subscribe(threadMode = ThreadMode.MAIN,genericsType = String.class)
        public void onRegisterSuccess(GenericsEvent<String> event) {
            Log.d("event","register success"+event.getData());
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            EventBus.getDefault().unregister(this);
        }
    }

