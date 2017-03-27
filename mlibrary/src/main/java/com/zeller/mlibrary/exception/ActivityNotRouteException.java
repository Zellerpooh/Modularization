package com.zeller.mlibrary.exception;

import java.util.regex.Pattern;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ActivityNotRouteException extends NotRouteException {

    public ActivityNotRouteException(String Pattern) {
        super("activity", Pattern);
    }
}
