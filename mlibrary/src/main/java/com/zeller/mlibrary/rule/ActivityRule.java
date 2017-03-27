package com.zeller.mlibrary.rule;

import android.app.Activity;

import com.zeller.mlibrary.exception.ActivityNotRouteException;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ActivityRule extends BaseIntentRule<Activity> {

    /**
     * activity路由scheme
     */
    public static final String ACTIVITY_SCHEME = "activity://";

    @Override
    public void throwException(String pattern) {
        throw new ActivityNotRouteException(pattern);
    }
}
