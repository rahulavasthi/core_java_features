package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
	public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount()); //count will be 8 with atomic and 5/6/7/8 (any) with count int
    }
}

class ProcessingThread implements Runnable {
    //private AtomicInteger count = new AtomicInteger();
	private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            //count.incrementAndGet();
            count++;
        }
    }

    public int getCount() {
        //return this.count.get();
    	return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
