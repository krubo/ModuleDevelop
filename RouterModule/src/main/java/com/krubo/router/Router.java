package com.krubo.router;

public abstract class Router {

    public static final int ACTIVITY_ROUTER = 1;

    protected int type;
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getType() {
        return type;
    }

    protected abstract void setType();

}
