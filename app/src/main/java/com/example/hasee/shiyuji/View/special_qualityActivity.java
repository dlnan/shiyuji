package com.example.hasee.shiyuji.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hasee.shiyuji.R;

/**
 * 该界面是平和质体质问卷调查的界面，
 * 主要实现给用户显示问卷题目，统计分数的功能
 */
public class special_qualityActivity extends AppCompatActivity implements View.OnClickListener {
    Button special_quality_confirm;
    Button special_quality_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_quality);
        special_quality_confirm = findViewById(R.id.special_quality_confirm);
        special_quality_back = findViewById(R.id.special_quality_back);
        special_quality_confirm.setOnClickListener(this);
        special_quality_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.special_quality_confirm:
                break;
            case R.id.special_quality_back:
                finish();
                break;
        }
    }
}
