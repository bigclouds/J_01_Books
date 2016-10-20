package java_multi_thread.chapter1;

public class Run2 {
	public static void main(String[] args) {
		ALogin a  =new ALogin();
		a.start();
		BLogin b =new BLogin();
		b.start();
		
	}

}
