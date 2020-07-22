package com.lamp.aop;

public class MathCalculator {
    public int  div(int i,int j){
        System.out.println(" div(int i,int j)");
//        int a = 1/ 0;
        return  i/j;
    }
}
