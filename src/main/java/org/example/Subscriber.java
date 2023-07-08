package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Subscriber implements Runnable {
    private static Queue<Integer> subQueue;
    Thread thread = new Thread();
    private static int topicSizeCheck = 0;

    public static void Subscriber(int getSubValue) {
        if(subQueue == null){
            subQueue = new LinkedList<>();
        }
        subQueue.offer(getSubValue);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) 0.1);
                topicSizeCheck = Topic.getMessage();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (topicSizeCheck != 0) {
                    Topic.getTopic();
                    System.out.println(subQueue.poll() + "메세지 발행");
            }
        }
    }
}
