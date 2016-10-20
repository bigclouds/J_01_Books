package java_multi_thread.chapter1;

public class BLogin extends Thread{
	public void run(){
		LoginServlet.doPost("b", "bb");
		
	}

}
