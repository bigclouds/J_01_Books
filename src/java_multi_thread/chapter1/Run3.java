package java_multi_thread.chapter1;


public class Run3 {
	
	public static void main(String[] args) {
		MyThread_Interrupt thread=new MyThread_Interrupt();
		thread.start();
		thread.interrupt();
		System.out.println(thread.isAlive());
		System.out.println("end");
	}

}
