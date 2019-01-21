package threads;

public class ThreadSignalingEx {
	MonitorObject myMonitorObject = new MonitorObject();
	  boolean wasSignalled = false;			//Use to avoid Missed signal

	  public void doWait(){
	    synchronized(myMonitorObject){
	      while(!wasSignalled){
	        try{
	          myMonitorObject.wait();
	         } catch(InterruptedException e){}
	      }
	      //clear signal and continue running.
	      wasSignalled = false;
	    }
	  }

	  public void doNotify(){
	    synchronized(myMonitorObject){
	      wasSignalled = true;
	      myMonitorObject.notify();
	    }
	  }
}

class MySignal{

	  protected boolean hasDataToProcess = false;

	  public synchronized boolean hasDataToProcess(){
	    return this.hasDataToProcess;
	  }

	  public synchronized void setHasDataToProcess(boolean hasData){
	    this.hasDataToProcess = hasData;  
	  }

	}

class MonitorObject{
}
