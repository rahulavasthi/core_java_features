package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPIEx implements Runnable{
	private Resource resource;
	private Lock lock;
	
	public LockAPIEx(Resource r){
		this.resource = r;
		this.lock = new ReentrantLock();
	}
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)){
			resource.doSomething();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//release lock
			lock.unlock();
		}
		resource.doLogging();
	}
}

class Resource {

	public void doSomething(){
		//do some operation, DB read, write etc
	}
	
	public void doLogging(){
		//logging, no need for thread safety
	}
}
