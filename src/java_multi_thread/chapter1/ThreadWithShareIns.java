package java_multi_thread.chapter1;
//test6
public class ThreadWithShareIns extends Thread{
	private int count=5;
	
	synchronized public void run(){
		super.run();
		//!I 此示例不要用for 语句， 因为使用同步后其他线程就得不到运行的机会了，
		//!I 一直由一个线程进行减法运算
			count--;
			System.out.println("由"+this.currentThread().getName()+"计算。count="+count);
		
	}

}
