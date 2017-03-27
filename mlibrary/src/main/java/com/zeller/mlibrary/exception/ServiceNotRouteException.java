package com.zeller.mlibrary.exception;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ServiceNotRouteException extends NotRouteException {
    public ServiceNotRouteException(String pattern) {
        super("Service", pattern);
    }
}
