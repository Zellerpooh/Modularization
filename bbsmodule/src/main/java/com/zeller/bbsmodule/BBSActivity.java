package com.zeller.bbsmodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zeller.mlibrary.Router;
import com.zeller.mlibrary.rule.ActivityRule;



public class BBSActivity extends AppCompatActivity {

    private Button btn_toMall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
        btn_toMall = (Button) findViewById(R.id.btn_startMall);
        btn_toMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= Router.invoke(BBSActivity.this, ActivityRule.ACTIVITY_SCHEME+"mall.main");
                startActivity(i);
            }
        });
    }


}
