package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class discover extends AppCompatActivity {
    TextView textview2;
    Button button1;
    String selected_item ;  // 为了演示目的，这里假设 selected_item 是一个文本字符串

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover_detail);  // 假设这是 discover.java 中的布局文件
        button1=findViewById(R.id.button10);
        Intent intent = getIntent();
        // 获取要填充内容的布局文件 item.xml
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item, null);

        // 将 item.xml 的内容添加到 Discover 的布局中
        LinearLayout containerLayout = findViewById(R.id.discover_detail);  // 修改为你在 activity_discover.xml 中的容器的实际 id
        containerLayout.addView(itemView);

        int position = intent.getIntExtra("position", 0);
        textview2 = findViewById(R.id.textView10);

        textview2.setText("这里是"+intent.getStringExtra("selected_item"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(discover.this,MainActivity.class);
                intent.putExtra("FRAGMENT_TO_SHOW", 3); // 假设fragment3对应的标识是2
                discover.this.startActivity(intent);
            }
        });

        Log.d("Discover", "Discover Activity created");  // 添加日志输出
    }
}

