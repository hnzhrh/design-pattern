package com.hnzhrh.design.pattern.adapter.objectadapter;

import com.hnzhrh.design.pattern.adapter.classadapter.Charge;
import com.hnzhrh.design.pattern.adapter.classadapter.UsbCharger;

public class AdapterTest {
    public static void main(String[] args) {
        Charge usbAdapter = new UsbChargerAdapter(new UsbCharger());
        usbAdapter.charge();
    }
}
