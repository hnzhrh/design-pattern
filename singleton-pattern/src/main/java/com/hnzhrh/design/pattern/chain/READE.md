# 什么是责任链模式？

责任链模式允许多个对象共同处理一个请求，每一个对象都有机会处理请求，但只有满足对象特定条件的请求才会被处理，否则会将请求传递给下一个对象，直到找到能够处理请求的对象。

责任链用于需要处理大量相似请求的场景，例如异常处理、过滤器等等。

# 如何实现责任链模式？

实现责任链模式主要考虑两个点：

* 链式执行，所以对象肯定包含一个指向下一个执行节点的对象指针
* 处理逻辑
* 判断需不需要处理逻辑

定义一个`Handler`接口：

```java
package com.hnzhrh.design.pattern.chain;

public interface Handler {
    void setNextHandler(Handler next);
    void handleRequest(Request request);
}
```

抽象实现：

```java
package com.hnzhrh.design.pattern.chain;

public abstract class AbstractHandler implements Handler{
    protected Handler next;
    @Override
    public void setNextHandler(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        if (null != next) {
            next.handleRequest(request);
        }
    }

    public static Handler buildChain(Handler... handlers) {
        if (null == handlers || handlers.length < 1) {
            return null;
        }
        Handler chain = handlers[0];
        Handler pre = handlers[0];
        for (int i = 1; i < handlers.length; i++) {
            pre.setNextHandler(handlers[i]);
            pre = handlers[i];
        }
        return chain;
    }
}
```

提供两个实现类模拟两个处理：

```java
package com.hnzhrh.design.pattern.chain;

public class FirstHandler extends AbstractHandler{
    @Override
    public void handleRequest(Request request) {
        if (canHandle(request)) {
            // 处理逻辑
            System.out.println("FirstHandler 处理");
        }
        super.handleRequest(request);
    }

    public boolean canHandle(Request request) {
        // 判断是否属于当前节点处理
        return true;
    }
}
```

```java
package com.hnzhrh.design.pattern.chain;

public class SecondHandler extends AbstractHandler{
    @Override
    public void handleRequest(Request request) {
        if (canHandle(request)) {
            // 处理逻辑
            System.out.println("SecondHandler 处理");
        } else {
            super.handleRequest(request);
        }
    }

    public boolean canHandle(Request request) {
        // 判断是否属于当前节点处理
        return true;
    }
}
```

测试类：

```java
package com.hnzhrh.design.pattern.chain;

public class ChainTest {
    public static void main(String[] args) {
        Handler chain = AbstractHandler.buildChain(new FirstHandler(), new SecondHandler());
        chain.handleRequest(new Request());
    }
}
```

输出：

```shell
FirstHandler 处理
SecondHandler 处理
```

# 应用

`Servlet`的`Filter`是典型的责任链模式。