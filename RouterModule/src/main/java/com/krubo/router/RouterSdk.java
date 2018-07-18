package com.krubo.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class RouterSdk {

    private static RouterSdk routerSdk;
    private Map<String, Router> routerMap;

    private RouterSdk() {
        routerMap = new HashMap<>();
    }

    public static RouterSdk getInstance() {
        if (routerSdk == null) {
            synchronized (RouterSdk.class) {
                if (routerSdk == null) {
                    routerSdk = new RouterSdk();
                }
            }
        }
        return routerSdk;
    }

    public RouterSdk addRouter(@NonNull Router router) {
        if (router != null && !TextUtils.isEmpty(router.getAction())
                && !routerMap.containsKey(router.getAction())) {
            routerMap.put(router.getAction(), router);
        }
        return routerSdk;
    }

    public boolean startActivity(@NonNull Activity activity, @NonNull String action) {
        if (!TextUtils.isEmpty(action) && routerMap.containsKey(action)) {
            Router router = routerMap.get(action);
            if (router != null && router.getType() == Router.ACTIVITY_ROUTER) {
                activity.startActivity(new Intent(activity, ((ActivityRouter) router).getCls()));
                return true;
            }
        }
        return false;
    }
}
