package com.hnzhrh.design.pattern.singleton;

public class DoubleCheckThreadSafeSingleton {

    private static volatile DoubleCheckThreadSafeSingleton instance = null;

    private DoubleCheckThreadSafeSingleton() {
    }

    public static DoubleCheckThreadSafeSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckThreadSafeSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
