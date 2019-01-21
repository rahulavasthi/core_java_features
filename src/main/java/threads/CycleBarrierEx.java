package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Synchronizer which allows multiple threads to wait for each other (barrier) before proceeding. 
 * Threads or parties wait for each other by calling CyclicBarrier.await() method 
 * We can not reuse CountDownLatch once the count reaches zero while we can reuse CyclicBarrier by calling reset() method which resets Barrier to its initial State.
 * CyclicBarrier.reset() put Barrier on its initial state, other thread which is waiting or not yet reached barrier will terminate with java.util.concurrent.BrokenBarrierException.
 * CountDownLatch is a good for one-time events like application start-up time and CyclicBarrier can be used to in case of the recurrent event e.g. concurrently calculating a solution of the big problem etc
 * Use- To implement multi player game which can not begin until all player has joined. OR Perform lengthy calculation by breaking it into smaller individual tasks, In general, to implement Map reduce technique.
 */
public class CycleBarrierEx {
	public static void main(String args[]) {
		// creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call
		// await()
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
			}
		});

		// starting each of thread
		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}

	private static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
				barrier.await();
				System.out.println(Thread.currentThread().getName()	+ " has crossed the barrier");
			} catch (InterruptedException ex) {
				Logger.getLogger(CycleBarrierEx.class.getName()).log(
						Level.SEVERE, null, ex);
			} catch (BrokenBarrierException ex) {
				Logger.getLogger(CycleBarrierEx.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}
}
