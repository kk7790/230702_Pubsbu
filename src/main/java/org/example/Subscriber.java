package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Subscriber implements Runnable {
    private static Queue<Integer> subQueue;
    Thread thread = new Thread();

    public static void Subscriber(int getSubValue) {
        synchronized (subQueue){
            subQueue.offer(getSubValue);
        }
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(10);
                if(subQueue == null){
                    subQueue = new LinkedList<>();
                }
                Topic.getTopic();
                if(subQueue.size() != 0){
                    synchronized (subQueue){
                        System.out.println(subQueue.poll() + "메세지 발행");
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
