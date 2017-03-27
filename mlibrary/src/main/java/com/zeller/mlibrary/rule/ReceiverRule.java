package com.zeller.mlibrary.rule;

import android.content.BroadcastReceiver;

import com.zeller.mlibrary.exception.ReceiverNotRouteException;

/**
 * Class description goes here.
 *
 * @author Zeller
 * @version 1.0.0  17/3/27
 * @date 17/3/27
 */

public class ReceiverRule extends BaseIntentRule<BroadcastReceiver> {

    public static final String RECEIVER_SCHEME="receiver://";
    @Override
    public void throwException(String pattern) {
        throw new ReceiverNotRouteException(pattern);
    }
}
