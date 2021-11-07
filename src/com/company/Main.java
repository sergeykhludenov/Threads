package com.company;

public class Main {
        // Введите время
        public static final int TIME = 10;

        public static void main(String[] args) {

            Chrono chrono = new Chrono();
            PeriodicSeconds oneSeconds = new PeriodicSeconds(chrono, 1);
            PeriodicSeconds fiveSeconds = new PeriodicSeconds(chrono, 5);
            PeriodicSeconds sevenSeconds = new PeriodicSeconds(chrono, 7);
            Thread t1 = new Thread(oneSeconds);
            t1.setName("Первый поток");
            t1.start();
            Thread t2 = new Thread(fiveSeconds);
            t2.setName("Второй поток");
            t2.start();
            Thread t3 = new Thread(sevenSeconds);
            t3.setName("Третий поток");
            t3.start();
            new Thread(chrono).start();



        }






}
        // Попытка 1
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                while (TIMER != 0) {
//                    try {
//                        sleep(1000);
//                        System.out.println("Первый поток: прошла 1 секунда");
//                        TIMER--;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                while (TIMER != 0) {
//                    try {
//                        sleep(5000);
//                        System.out.println("Второй поток: прошло 5 секунд");
//                        TIMER--;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread1.start();
//        thread2.start();



//  Пример с вебинара
//        Thread thred1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(5000);
//                    System.out.println("5 seconds");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(7000);
//                    System.out.println("7 seconds");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thred1.start();
//        thread2.start();
//        new Thread(new TenSecondsWaiter()).start();
//        System.out.println("Main thread");
