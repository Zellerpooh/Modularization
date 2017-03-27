package com.zeller.mallmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeller.mlibrary.Router;
import com.zeller.mlibrary.rule.ActivityRule;

public class MallActivity extends AppCompatActivity {

    private Button btn_startBBS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        btn_startBBS = (Button) findViewById(R.id.btn_startBBS);
        btn_startBBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Router.invoke(MallActivity.this, ActivityRule.ACTIVITY_SCHEME + "bbs.main");
                startActivity(intent);
            }
        });
    }
}
