package org.example;

public class Publisher {
    private static int pubQueue;
    public synchronized void Publisher(int message) {
        pubQueue = message;
        Topic topic = new Topic();
        Runnable run = topic;
        Thread topicWorker= new Thread(run);
        topicWorker.start();
    }

    public static int getPub(){
        return pubQueue;
    }
}

