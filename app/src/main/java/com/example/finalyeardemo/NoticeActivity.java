package com.example.finalyeardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
    }


    public void goNewNotice(View view) {
        startActivity(new Intent(NoticeActivity.this, NewNoticeActivity.class));
    }
}
