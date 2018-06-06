package com.utils;
import java.util.List;
public class ThreadPoolUtils {
    private Integer maxSize = 10;
    private Integer size;
    private Runnable task;
    private List<Runnable> runnableList;

    public ThreadPoolUtils(){

    }
    public ThreadPoolUtils(Integer size) {
        this.size = size;
    }


    public void excute(Runnable task){
        if(runnableList.size() > maxSize){
            throw new RuntimeException("线程池已满");
        }
        runnableList.add(task);
        Thread thread = new Thread(task);
        thread.start();
    }


}
