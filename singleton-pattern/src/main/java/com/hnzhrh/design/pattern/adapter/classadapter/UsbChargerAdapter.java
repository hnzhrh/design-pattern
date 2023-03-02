package com.hnzhrh.design.pattern.adapter.classadapter;

public class UsbChargerAdapter extends com.hnzhrh.design.pattern.adapter.classadapter.UsbCharger implements com.hnzhrh.design.pattern.adapter.classadapter.Charge {
    @Override
    public void charge() {
        super.usbCharge();
    }
}
