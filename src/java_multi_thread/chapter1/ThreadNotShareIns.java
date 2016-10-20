package java_multi_thread.chapter1;

public class ThreadNotShareIns  extends Thread{
	private int count=5;
	public ThreadNotShareIns(String name){
		super();
		this.setName(name);
	}
	
	public void run(){
		super.run();
		while(count>0){
			count--;
			System.out.println("由"+this.currentThread().getName()+"计算。count="+count);
		}
	}

}
