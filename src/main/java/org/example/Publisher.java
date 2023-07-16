package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Publisher {
    private static Queue<Integer> pubQueue;
    public void Publisher(int message) {
        int getValue = message;
        if(pubQueue == null){
            pubQueue = new LinkedList<>();
        }
        for(int i = 1; i <= getValue; i++){
            synchronized (pubQueue){
                pubQueue.add(i);
                System.out.println(i+"저장!");
            }
        }
        getPub();
    }

    public static void getPub(){
        for(int j=pubQueue.size(); j>0; j--){
            synchronized (pubQueue){
                Topic.Topic(pubQueue.poll());
            }
        }
    }
}

