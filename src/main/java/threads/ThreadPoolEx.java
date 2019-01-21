package threads;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author rahul.avasthi
 *In this above program, we are creating fixed size thread pool of 5 worker threads. 
 *Then we are submitting 10 jobs to this pool, since the pool size is 5, it will start working on 5 jobs 
 *and other jobs will be in wait state, as soon as one of the job is finished, 
 *another job from the wait queue will be picked up by worker thread and get's executed.
 */

public class ThreadPoolEx {
	public static void main(String[] args) throws InterruptedException{
		//fixedThreadPoolEx();
		
		scheduledThreadPoolEx();
    }
	
	private static void fixedThreadPoolEx(){
		ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
	}
	
	private static void scheduledThreadPoolEx() throws InterruptedException{
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		
		//schedule to run after sometime
		System.out.println("Current Time = "+new Date());
		for(int i=0; i<7; i++){
			Thread.sleep(1000);
			WorkerThread worker = new WorkerThread("do heavy processing");
			scheduledThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
		}
		
		//add some delay to let some threads spawn by scheduler
		Thread.sleep(30000);
		
		scheduledThreadPool.shutdown();
		while(!scheduledThreadPool.isTerminated()){
			//wait for all tasks to finish
		}
		System.out.println("Finished all threads");
	}
}

class WorkerThread implements Runnable {
	  
    private String command;
    
    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
