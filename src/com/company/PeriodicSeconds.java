package com.company;

class PeriodicSeconds implements Runnable {
    private final Chrono chrono;
    private final int period;

    PeriodicSeconds(Chrono chrono, int period) {
        this.chrono = chrono;
        this.period = period;
    }

    public void run() {
        while (!Thread.interrupted()) {
            synchronized (chrono) {
                try {
                    chrono.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (chrono.seconds % period == 0) {
                    System.out.println(Thread.currentThread().getName() + ": Прошло " + period + " секунд");
                }
                if (chrono.seconds >= Main.TIME) {
                    return;
                }
            }

        }

    }
}