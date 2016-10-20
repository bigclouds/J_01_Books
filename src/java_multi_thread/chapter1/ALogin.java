package java_multi_thread.chapter1;

public class ALogin extends Thread{
	
	public  void run(){
		LoginServlet.doPost("a", "aa");
	
	}

}
