package com.company;

class Chrono implements Runnable {

    int seconds = 0;
    public void run() {
        for (int i = 0; i < Main.TIME; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                seconds++;
                notifyAll();
            }
        }
    }
}
