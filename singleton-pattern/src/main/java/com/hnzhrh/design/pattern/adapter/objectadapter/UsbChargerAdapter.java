package com.hnzhrh.design.pattern.adapter.objectadapter;

import com.hnzhrh.design.pattern.adapter.classadapter.Charge;
import com.hnzhrh.design.pattern.adapter.classadapter.UsbCharger;

public class UsbChargerAdapter implements Charge {
    private UsbCharger usbCharger;

    public UsbChargerAdapter(UsbCharger usbCharger) {
        this.usbCharger = usbCharger;
    }

    @Override
    public void charge() {
        usbCharger.usbCharge();
    }
}
