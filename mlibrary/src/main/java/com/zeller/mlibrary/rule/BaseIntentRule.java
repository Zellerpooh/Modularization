package com.zeller.mlibrary.rule;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;

public abstract class BaseIntentRule<T> implements Rule<T, Intent> {

    private HashMap<String, Class<T>> mIntentRules;

    public BaseIntentRule() {
        mIntentRules = new HashMap<>();
    }

    @Override
    public void router(String pattern, Class<T> cls) {
        mIntentRules.put(pattern, cls);
    }

    @Override
    public Intent invoke(Context ctx, String pattern) {
        Class<T> cls = mIntentRules.get(pattern);
        if (null == cls) {
            throwException(pattern);
        }
        return new Intent(ctx, cls);
    }

    @Override
    public boolean resolveRule(String pattern) {
        return false;
    }

    /**
     * 找不到路由规则时抛出异常
     *
     * @param pattern
     */
    public abstract void throwException(String pattern);
}
