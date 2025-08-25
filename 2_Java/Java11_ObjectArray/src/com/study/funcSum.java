package com.study;

public class funcSum {
	// 매개변수 2개
    static int add(int a, int b) {
        return a + b;
    }

    // 매개변수 3개
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // 매개변수 다른 타입
    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));       // 3
        System.out.println(add(1, 2, 3));    // 6
        System.out.println(add(1.5, 2.5));   // 4.0
    }

}
