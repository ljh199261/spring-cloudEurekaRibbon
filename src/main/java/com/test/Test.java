package com.test;

import com.utils.SnowFlake;


public class Test {
    public static void main(String [] args){
        SnowFlake snowFlake = new SnowFlake(2,3);
        for(int i = 0;i < 100;i++){
           Thread thread = new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println(snowFlake.nextId());
               }
           });
           thread.start();
        }

    }



}
