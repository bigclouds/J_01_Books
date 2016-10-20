package java_multi_thread.chapter1;

public class run {
	public static void main(String[] args) {
		Runnable runnable =new MyRunnable();
		Thread thread=new Thread(runnable);
		thread.start();
		System.out.println("运行结束~~~~");
	}

}
