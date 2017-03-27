package com.zeller.mlibrary.rule;

import android.content.Context;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public interface Rule<T, V> {

    /**
     * 添加路由
     *
     * @param pattern
     * @param cls
     */
    void router(String pattern, Class<T> cls);

    /**
     * 路由调用
     *
     * @param ctx
     * @param pattern
     * @return
     */
    V invoke(Context ctx, String pattern);

    /**
     * 是否存在路由
     *
     * @param pattern
     * @return
     */
    boolean resolveRule(String pattern);
}
