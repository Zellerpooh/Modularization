package com.zeller.mlibrary;

import android.content.Context;

import com.zeller.mlibrary.rule.Rule;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class Router {

    /**
     * 添加规则
     *
     * @param scheme
     * @param rule
     * @return
     */
    public static RouterInternal addRule(String scheme, Rule rule) {
        return RouterInternal.getInstance().addRule(scheme, rule);
    }

    /**
     * 添加路由
     *
     * @param pattern
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> RouterInternal router(String pattern, Class<T> cls) {
        return RouterInternal.getInstance().router(pattern, cls);
    }

    /**
     * 路由跳转
     *
     * @param context
     * @param pattern
     * @param <V>
     * @return
     */
    public static <V> V invoke(Context context, String pattern) {
        return RouterInternal.getInstance().invoke(context, pattern);
    }

    /**
     * 是否存在该路由
     * @param pattern
     * @return
     */
    public static boolean resolveRouter(String pattern) {
        return RouterInternal.getInstance().resolveRouter(pattern);
    }
}
