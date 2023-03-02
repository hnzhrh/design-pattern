# 什么是适配器模式？

适配器模式是将现有的接口转换为另一个接口，可以解决接口不兼容的问题，适配器主要有三个角色：

* 目标接口（Target）：定义客户端使用的特定接口，该接口是客户端期望的接口。

* 源接口（Adaptee）：定义需要被适配的接口。

* 适配器（Adapter）：实现目标接口，并使用源接口来实现目标接口的方法。

适配器模式不应该在系统设计的时候就考虑，更多用于维护和升级。

# 如何实现适配器模式？

实现适配器模式有两种方式：

* 基于对象的继承
* 基于对象的组合

假设有如下场景：

我们正在维护某个产品，实现了一个充电接口进行充电，现有的接口如下：

```java
public interface Charge {
    void charge();
}
```

公司在用自己的充电器实现进行充电：

```java
Charge oneCharger = new XXXCharger();
oneCharger.charge();
```

有一天自己家的充电器倒闭了，需要三方厂家，但USB厂家提供的充电器是这样的：

```java
package com.hnzhrh.design.pattern.classadapter;

public class UsbCharger {
    public void usbCharge() {
        System.out.println("Usb 充电器");
    }
}
```

Type-c厂家提供的充电器是这样的：

```java
package com.hnzhrh.design.pattern.classadapter;

public class TypecCharger {
    public void typecCharge() {
        System.out.println("Type-c充电器");
    }
}
```

这个时候可以使用适配器模式进行适配：

```java
package com.hnzhrh.design.pattern.classadapter;

public class UsbChargerAdapter extends UsbCharger implements Charge{
    @Override
    public void charge() {
        super.usbCharge();
    }
}
```

同理可以适配Type-c：

```java
package com.hnzhrh.design.pattern.classadapter;

public class TypecChargerAdapter extends TypecCharger implements Charge{
    @Override
    public void charge() {
        super.typecCharge();
    }
}
```

使用：

```java
package com.hnzhrh.design.pattern.classadapter;

public class AdapterTest {
    public static void main(String[] args) {
        Charge chargerAdapter = new UsbChargerAdapter();
        chargerAdapter.charge();
    }
}
// Usb 充电器
```

## 基于对象的继承实现适配器模式

适配器改为如下：

```java
package com.hnzhrh.design.pattern.objectadapter;

import com.hnzhrh.design.pattern.classadapter.Charge;
import com.hnzhrh.design.pattern.classadapter.UsbCharger;

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
```

没有通过继承，而是通过构造函数构造成员变量实现。