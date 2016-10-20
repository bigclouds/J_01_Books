package java_multi_thread.chapter1;

public class extthread extends Thread{
	
	private int i;
	
	public extthread(int i){
		super();
		this.i=i;
	}
	public extthread(){
	}
	
	public void run(){
		System.out.println(i);
	}

}
