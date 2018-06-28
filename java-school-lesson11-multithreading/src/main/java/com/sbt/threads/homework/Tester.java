package com.sbt.threads.homework;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;


public class Tester extends Thread {




    public void run() {
        System.out.println("Run");
    }

    public void begin() {
        System.out.println("berg");
    }

    public void execute() {
        System.out.println("execute");
    }



    public static void main(String[] args) {
        System.out.println((-(byte)128)>>>1 == 128 >> 1);
    }

}
