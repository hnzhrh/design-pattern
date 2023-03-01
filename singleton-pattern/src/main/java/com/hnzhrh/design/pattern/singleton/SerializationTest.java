package com.hnzhrh.design.pattern.singleton;

import com.alibaba.fastjson.JSONObject;

public class SerializationTest {
    public static void main(String[] args) {
        DoubleCheckThreadSafeSingleton instance = DoubleCheckThreadSafeSingleton.getInstance();
        String json = JSONObject.toJSONString(instance);
        DoubleCheckThreadSafeSingleton newInstance = JSONObject.parseObject(json, DoubleCheckThreadSafeSingleton.class);
        System.out.println(instance == newInstance);
    }
}
