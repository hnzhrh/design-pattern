# 什么是单例模式？

单例模式保证一个类**只有一个实例**，并且提供全局访问该实例的方法。

单例模式应该满足几个特点：

* 私有化的构造器
* 需要保证线程安全
* 延迟加载
* 安全得序列化和反序列化
* 防止反射攻击

单例模式一般用于控制系统级别的资源，在系统中保持唯一性，比如：

* 线程池
* 数据库连接
* 文件管理器

# 如何实现单例模式？

根据作用域的不同，单例模式的实现主要有以下几种方案：

* 饿汉式静态变量实现
* 饿汉式静态内部类实现
* 懒汉式线程不安全实现
* 懒汉式双重检查机制线程安全实现
* 枚举实现单例模式
* 容器单例模式
* 线程单例模式

## 饿汉式静态变量实现

```java
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
```

## 饿汉式静态内部类实现

```java
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
```

## 懒汉式线程不安全实现

```java
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
```

## 懒汉式双重检查机制线程安全实现

```java
public class DoubleCheckThreadSafeSingleton {

    private static volatile DoubleCheckThreadSafeSingleton instance = null;

    private DoubleCheckThreadSafeSingleton() {
    }

    public static DoubleCheckThreadSafeSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckThreadSafeSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

## 枚举实现单例模式

```java
public enum EnumSingleton {
    INSTANCE;
    private Object data = new Object();

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
```

# 如何破坏单例模式？

出现破坏单例模式的情况主要有两种：

* 序列化和反序列化破坏单例模式
* 反射破坏单例模式

