package com.hnzhrh.design.pattern.singleton;

public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        if (instance != null) {
            throw new RuntimeException("Not allowed here by inflection.");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
