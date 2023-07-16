package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Topic {
    private static Queue<Integer> message;

    public static synchronized void Topic(int getValue) { // pub에서 받은거 저장
        message.offer(getValue);
    }

    public static synchronized void getTopic() {
        if(message == null){
            message = new LinkedList<>();
        }
        if(message.size() != 0){
            for(int i = message.size(); i > 0; i--){
                Subscriber.Subscriber(message.poll());
            }
        }
    }
}
