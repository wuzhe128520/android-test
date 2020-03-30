package com.example.androidhelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.androidhelloworld.MESSAGE";
    String msg = "Android";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 从res/layout/activity_main.xml文件加载UI组件
        setContentView(R.layout.activity_main);
    }

    // 当用户点击发送按钮时调用
    public void sendMessage(View view) {
       /*
          Intent是在相互独立的组件之间提供运行时绑定功能的对象。
          Intent表示应用执行某项操作的意图。
          Intent构造器需要两个参数，一个Context和一个Class;
          Context参数会被优先使用，因为Activity类是Context的子类；
          第二个参数Class是系统将Intent传递过去的目标（这里表示的是启动的activity）
       */
       Intent intent = new Intent(this, DisplayMessageActivity.class);
       EditText editText = (EditText) findViewById(R.id.editText);
       // 获取输入框中的文本
       String message = editText.getText().toString();
       // 将EditText的值添加到intent。一个Intent能够携带称作extras的键值对数据；这里的键就是公共不可变的静态
       // 变量EXTRA_MESSAGE;因为下一个activity使用这个key来取回这个文本值；最好使用包名作为键值的前缀，且唯一。
       // 以便此app与其他app交互。
       intent.putExtra(EXTRA_MESSAGE, message);
       // 启动一个Intent指定的DisplayMessageActivity的实例；
       startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
