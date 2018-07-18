package com.krubo.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RouterManager {

    private static RouterManager routerManager;
    private Map<String, Class<? extends Activity>> routerMap;

    private RouterManager() {
        routerMap = new HashMap<>();
    }

    public static RouterManager getInstance() {
        if (routerManager == null) {
            synchronized (RouterManager.class) {
                if (routerManager == null) {
                    routerManager = new RouterManager();
                }
            }
        }
        return routerManager;
    }

    public void addActivityRouter(@NonNull String action, @NonNull Class<? extends Activity> cls) {
        if (!routerMap.containsKey(action) && !TextUtils.isEmpty(action)) {
            routerMap.put(action, cls);
        }
    }

    private Intent createIntent(@NonNull Context context, @NonNull String action, Bundle bundle) {
        Intent intent = new Intent(context, routerMap.get(action));
        if (bundle != null) {
            intent.putExtra("bundle", bundle);
        }
        return intent;
    }

    public boolean startActivity(@NonNull Context context, @NonNull String action, Bundle bundle) {
        if (routerMap.containsKey(action)
                && !context.equals(context.getApplicationContext())) {
            context.startActivity(createIntent(context, action, bundle));
            return true;
        }
        return false;
    }

    public boolean startActivityForRequest(@NonNull Activity activity, @NonNull String action, Bundle bundle, int requestCode) {
        if (routerMap.containsKey(action)) {
            activity.startActivityForResult(createIntent(activity.getBaseContext(), action, bundle), requestCode);
            return true;
        }
        return false;
    }

    public boolean startActivityForRequest(@NonNull Fragment fragment, @NonNull String action, Bundle bundle, int requestCode) {
        if (routerMap.containsKey(action)) {
            fragment.startActivityForResult(createIntent(fragment.getContext(), action, bundle), requestCode);
            return true;
        }
        return false;
    }
}
