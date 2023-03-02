package com.hnzhrh.design.pattern.adapter.classadapter;

import com.hnzhrh.design.pattern.adapter.Charge;
import com.hnzhrh.design.pattern.adapter.UsbChargerAdapter;

public class AdapterTest {
    public static void main(String[] args) {
        Charge chargerAdapter = new UsbChargerAdapter();
        chargerAdapter.charge();
    }
}
