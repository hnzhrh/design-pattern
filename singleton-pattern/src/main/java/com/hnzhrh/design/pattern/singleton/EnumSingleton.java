package com.hnzhrh.design.pattern.singleton;

public enum EnumSingleton {
    INSTANCE;
    private Object data = new Object();

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
