package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread_Test {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		new Reader(calculator).start();
		new Reader(calculator).start();
		new Reader(calculator).start();
		calculator.start();
		
		
			new DudesChat().go();
	}

	// Deadlock
	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read() {
		synchronized (resourceA) { // May deadlock here
			synchronized (resourceB) {
				return resourceB.value + resourceA.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resourceB) { // May deadlock here
			synchronized (resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}
}

class Reader extends Thread {
	Calculator c;

	public Reader(Calculator calc) {
		c = calc;
	}

	public void run() {
		synchronized (c) {
			try {
				System.out.println("Waiting for calculation...");
				c.wait();
			} catch (InterruptedException e) {
			}
			System.out.println("Total is: " + c.total);
		}
	}
}

class Calculator extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			notifyAll();
		}
	}
}

class Dudes {
	static long flag = 0;

	void chat(long id) {
		if (flag == 0)
			flag = id;
		for (int x = 1; x < 3; x++) {
			if (flag == id)
				System.out.print("yo ");
			else
				System.out.print("dude ");
		}
	}
}

class DudesChat implements Runnable {
	static Dudes d;

	void go() {
		d = new Dudes();
		new Thread(new DudesChat()).start();
		new Thread(new DudesChat()).start();
	}

	public void run() {
		d.chat(Thread.currentThread().getId());
	}
}

class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

}
