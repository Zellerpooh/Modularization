package com.zeller.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.zeller.mallmodule.MallActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_start)
    public void onClick() {
        Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MallActivity.class);
        startActivity(intent);
    }
}
