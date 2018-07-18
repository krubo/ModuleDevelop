package com.krubo.router;

import android.app.Activity;
import android.support.annotation.NonNull;

public class RouterFactory {

    public static Router createActivityRouter(@NonNull String action, @NonNull Class<? extends Activity> cls) {
        ActivityRouter router = new ActivityRouter();
        router.setAction(action);
        router.setCls(cls);
        return router;
    }
}
