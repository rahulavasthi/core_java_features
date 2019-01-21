package threads;

import java.util.concurrent.Semaphore;

public class SemaphoresEx {
	private static final int MAX_AVAILABLE = 100;
	   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

	   public Object getItem() throws InterruptedException {
	     available.acquire();
	     return getNextAvailableItem();
	   }

	   public void putItem(Object x) {
	     if (markAsUnused(x))
	       available.release();
	   }

	   // Not a particularly efficient data structure; just for demo

	   protected Object[] items = {};
	   protected boolean[] used = new boolean[MAX_AVAILABLE];

	   protected synchronized Object getNextAvailableItem() {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (!used[i]) {
	          used[i] = true;
	          return items[i];
	       }
	     }
	     return null; // not reached
	   }

	   protected synchronized boolean markAsUnused(Object item) {
	     for (int i = 0; i < MAX_AVAILABLE; ++i) {
	       if (item == items[i]) {
	          if (used[i]) {
	            used[i] = false;
	            return true;
	          } else
	            return false;
	       }
	     }
	     return false;
	   }

	public static void main(String[] args) {
		simpleSemaphoreEx();
		
	}

	static void simpleSemaphoreEx() {
		SimpleSemaphore semaphore = new SimpleSemaphore();

		SendingThread sender = new SendingThread(semaphore);

		ReceivingThread receiver = new ReceivingThread(semaphore);

		receiver.start();
		sender.start();
	}
}

class SimpleSemaphore {
	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (!this.signal)
			wait();
		this.signal = false;
	}
}

class CountingSemaphore {
	private int signals = 0;

	public synchronized void take() {
		this.signals++;
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signals == 0)
			wait();
		this.signals--;
	}

}

class SendingThread extends Thread {
	SimpleSemaphore semaphore = null;

	public SendingThread(SimpleSemaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		while (true) {
			// do something, then signal
			this.semaphore.take();
		}
	}
}

class BoundedSemaphore {
	private int signals = 0;
	private int bound = 0;

	public BoundedSemaphore(int upperBound) {
		this.bound = upperBound;
	}

	public synchronized void take() throws InterruptedException {
		while (this.signals == bound)
			wait();
		this.signals++;
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signals == 0)
			wait();
		this.signals--;
		this.notify();
	}
}

class ReceivingThread extends Thread {
	SimpleSemaphore semaphore = null;

	public ReceivingThread(SimpleSemaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		while (true) {
			try {
				this.semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// receive signal, then do something...
		}
	}
}
