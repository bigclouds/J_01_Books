package java_multi_thread.chapter1;

public class CountOperate extends Thread{
	public CountOperate(){
		System.out.println("CountOperate--begin");
		System.out.println(Thread.currentThread().getName());
		System.out.println("this.getName()=" +this.getName());
		
		
	}

}
