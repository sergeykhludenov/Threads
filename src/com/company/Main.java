package com.company;

import javax.swing.plaf.TableHeaderUI;

    public class Main {
        // Введите время
        public static final int TIME = 20;

        public static void main(String[] args) {

            Seconds seconds = new Seconds();
            Chrono chrono = new Chrono(seconds);
            FiveSeconds fiveSeconds = new FiveSeconds(seconds);
            new Thread(fiveSeconds).start();
            new Thread(chrono).start();

        }

    static class Seconds {
        private int timer = 0;
        public synchronized void get() {
            while ((timer != 5)){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            timer = timer - 5;
            System.out.println("Второй поток: прошло 5 секунд");
            notify();
        }
        public synchronized void put() {
            while (timer == 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Первый поток: прошла 1 секунда");
            timer++;
            notify();
        }
    }

    static class Chrono implements Runnable {

        Seconds seconds;
        Chrono(Seconds seconds) {
            this.seconds = seconds;
        }
        public void run() {
            for (int i = 0; i < Main.TIME; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                seconds.put();
            }
        }
    }

    static class FiveSeconds implements Runnable {
        Seconds seconds;
        FiveSeconds(Seconds seconds) {
            this.seconds = seconds;
        }
        public void run() {
            for (int i = 0; i < Main.TIME / 5; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                seconds.get();
            }
        }
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
