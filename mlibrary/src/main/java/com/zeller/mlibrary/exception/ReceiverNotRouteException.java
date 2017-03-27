package com.zeller.mlibrary.exception;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ReceiverNotRouteException extends NotRouteException {
    public ReceiverNotRouteException(String pattern) {
        super("Receiver", pattern);
    }
}
