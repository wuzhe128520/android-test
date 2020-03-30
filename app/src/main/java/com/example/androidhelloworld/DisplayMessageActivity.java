package com.example.androidhelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 渲染res/layout/activity_display_message.xml
        setContentView(R.layout.activity_display_message);
        // 获取启动这个activity的Intent（也就是在MainActivity中定义的Intent）
        Intent intent = getIntent();
        // 根据MainActivity中Intent设置的key，提取字符串
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // 捕获layout中的TextView，并设置它的text为上面的message
        TextView textView = findViewById(R.id.textView);
        // 设置文本
        textView.setText(message);
    }
}
