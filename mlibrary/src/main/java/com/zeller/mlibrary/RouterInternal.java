package com.zeller.mlibrary;

import android.content.Context;

import com.zeller.mlibrary.rule.ActivityRule;
import com.zeller.mlibrary.rule.ReceiverRule;
import com.zeller.mlibrary.rule.Rule;
import com.zeller.mlibrary.exception.NotRouteException;
import com.zeller.mlibrary.rule.ServiceRule;

import java.util.HashMap;
import java.util.Set;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class RouterInternal {

    private static RouterInternal sInstance;
    private HashMap<String, Rule> mRules;

    private RouterInternal() {
        mRules = new HashMap<>();
        initDefaultRouter();
    }

    private void initDefaultRouter() {
        addRule(ActivityRule.ACTIVITY_SCHEME, new ActivityRule());
        addRule(ServiceRule.SERVICE_SCHEME, new ServiceRule());
        addRule(ReceiverRule.RECEIVER_SCHEME, new ReceiverRule());
    }

    public static synchronized RouterInternal getInstance() {
        if (null == sInstance) {
            synchronized (RouterInternal.class) {
                if (null == sInstance) {
                    sInstance = new RouterInternal();
                }
            }
        }
        return sInstance;
    }

    /**
     * 添加自定义路由
     *
     * @param scheme
     * @param rule
     * @return
     */
    public final RouterInternal addRule(String scheme, Rule rule) {
        mRules.put(scheme, rule);
        return this;
    }

    /**
     * 获取自定义路由
     *
     * @param pattern
     * @param <T>
     * @param <V>
     * @return
     */
    private <T, V> Rule<T, V> getRule(String pattern) {
        HashMap<String, Rule> rules = mRules;
        Set<String> keySet = rules.keySet();
        Rule<T, V> rule = null;
        for (String scheme : keySet) {
            if (pattern.startsWith(scheme)) {
                rule = rules.get(scheme);
                break;
            }
        }
        return rule;
    }

    /**
     * 添加路由
     *
     * @param pattern
     * @param cls
     * @param <T>
     * @return
     */
    public final <T> RouterInternal router(String pattern, Class<T> cls) {
        Rule<T, ?> rule = getRule(pattern);
        if (null == rule) {
            throw new NotRouteException("unkown", pattern);
        }
        rule.router(pattern, cls);
        return this;
    }

    /**
     * 调用路由
     *
     * @param context
     * @param pattern
     * @param <V>
     * @return
     */
    public <V> V invoke(Context context, String pattern) {
        Rule<?, V> rule = getRule(pattern);
        if (null == rule) {
            throw new NotRouteException("unkown", pattern);
        }
        return rule.invoke(context, pattern);
    }

    /**
     * 是否存在路由
     *
     * @param pattern
     * @return
     */
    public boolean resolveRouter(String pattern) {
        Rule<?, ?> rule = getRule(pattern);
        return rule != null && rule.resolveRule(pattern);
    }
}
