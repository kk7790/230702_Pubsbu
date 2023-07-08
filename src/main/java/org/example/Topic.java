package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Topic implements Runnable{
    private static int messageSize;
    private static Queue<Integer> message;

    public synchronized void Topic(int getValue) { // pub에서 받은거 저장
        if(message == null){
            message = new LinkedList<>();
        }
        for (int i = 0; i < getValue; i++) {
            message.offer(i + 1);
            messageSize += 1;
        }
    }

    public static synchronized void getTopic() {
        if(getMessage() != 0){
            int returnValue = message.poll();
            Subscriber.Subscriber(returnValue);
            messageSize --;
        }
    }

    public static int getMessage(){
        return messageSize;
    }

    @Override
    public void run(){
        int getValue = Publisher.getPub();
        Topic(getValue);
    }
}
