package com.hnzhrh.design.pattern.singleton;

public class HungryStaticInnterClassSingleton {
    private static class InnerClass {
        private static HungryStaticInnterClassSingleton instance = new HungryStaticInnterClassSingleton();
    }

    public HungryStaticInnterClassSingleton() {
        if (InnerClass.instance != null) {
            throw new RuntimeException("Not allowed here by inflection.");
        }
    }

    public static HungryStaticInnterClassSingleton getInstance() {
        return InnerClass.instance;
    }
}
