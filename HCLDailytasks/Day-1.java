package com.hcldailytask;

public class PlatformInfo {
    public static void main(String[] args) {
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Max Heap: " + runtime.maxMemory() / (1024 * 1024) + " MB");
        System.out.println("Free Heap: " + runtime.freeMemory() / (1024 * 1024) + " MB");
    }
}