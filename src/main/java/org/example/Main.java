package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pub;
        Subscriber subscriber = new Subscriber();
        for(int i=0; i<10; i++){
            Thread sub= new Thread(subscriber);
            sub.start();
        }

        while(true){
            Scanner scanner = new Scanner(System.in);
            pub = scanner.nextInt();
            if (pub != 0) {
                Publisher Publisher = new Publisher();
                Publisher.Publisher(pub);
            } else {
                System.out.println("0 is end");
                for(int i=0; i<10; i++) {
                    Thread sub= new Thread(subscriber);
                    sub.stop();
                }
                break;
            }
        }
    }
}

