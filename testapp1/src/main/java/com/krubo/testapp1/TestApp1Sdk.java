package com.krubo.testapp1;

import com.krubo.router.RouterFactory;
import com.krubo.router.RouterSdk;

public class TestApp1Sdk {

    public static String ACTION = "testapp1/Test1Activity";

    public static void init() {
        RouterSdk.getInstance().addRouter(RouterFactory.createActivityRouter(ACTION, Test1Activity.class));
    }
}
