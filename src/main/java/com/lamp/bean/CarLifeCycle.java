package com.lamp.bean;

public class CarLifeCycle {
    public CarLifeCycle() {

        System.out.println("CarLifeCycle对象的构造");
    }

    void init() {
        System.out.println("CarLifeCycle对象的初始化");
    }

    void destory() {
        System.out.println("CarLifeCycle对象的销毁");

    }
}
