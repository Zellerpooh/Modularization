package com.zeller.modularization.app;

import android.app.Application;

import com.zeller.bbsmodule.BBSActivity;
import com.zeller.mallmodule.MallActivity;
import com.zeller.mlibrary.Router;
import com.zeller.mlibrary.rule.ActivityRule;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRouter();
    }

    private void setUpRouter() {
        Router.router(ActivityRule.ACTIVITY_SCHEME + "bbs.main", BBSActivity.class);
        Router.router(ActivityRule.ACTIVITY_SCHEME + "mall.main", MallActivity.class);
    }
}
