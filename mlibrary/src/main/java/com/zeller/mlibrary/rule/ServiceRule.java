package com.zeller.mlibrary.rule;

import android.app.Service;

import com.zeller.mlibrary.exception.ServiceNotRouteException;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ServiceRule extends BaseIntentRule<Service> {

    public static final String SERVICE_SCHEME = "service://";

    @Override
    public void throwException(String pattern) {
        throw new ServiceNotRouteException(pattern);
    }

}
