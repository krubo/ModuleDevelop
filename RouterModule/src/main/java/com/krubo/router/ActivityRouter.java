package com.krubo.router;

import android.app.Activity;

public class ActivityRouter extends Router {

    private Class<? extends Activity> cls;

    public ActivityRouter() {
        setType();
    }

    public Class<? extends Activity> getCls() {
        return cls;
    }

    public void setCls(Class<? extends Activity> cls) {
        this.cls = cls;
    }

    @Override
    protected void setType() {
        this.type = ACTIVITY_ROUTER;
    }
}
