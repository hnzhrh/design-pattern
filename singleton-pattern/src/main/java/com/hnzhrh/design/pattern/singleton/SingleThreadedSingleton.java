package com.hnzhrh.design.pattern.singleton;

public class SingleThreadedSingleton {

    private static SingleThreadedSingleton instance = null;

    private SingleThreadedSingleton() {
    }

    public static SingleThreadedSingleton getInstance() {
        if (instance == null) {
            instance =  new SingleThreadedSingleton();
        }
        return instance;
    }
}
