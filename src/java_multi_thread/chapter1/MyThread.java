package java_multi_thread.chapter1;

import java.util.concurrent.BlockingDeque;

public class MyThread extends Thread{
	@Override
	public void run(){
		super.run();
		System.out.println("MyThread");
	}

}
