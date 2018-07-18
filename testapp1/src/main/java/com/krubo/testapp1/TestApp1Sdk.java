package com.krubo.testapp1;

import com.krubo.router.RouterManager;

public class TestApp1Sdk {

    public static String ACTION = "testapp1/Test1Activity";

    public static void init(){
        RouterManager.getInstance().addActivityRouter(ACTION, Test1Activity.class);
    }
}
