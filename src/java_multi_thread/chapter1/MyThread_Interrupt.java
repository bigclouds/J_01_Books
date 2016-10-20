package java_multi_thread.chapter1;

public class MyThread_Interrupt extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			for(int i=0;i<10000;i++){
				System.out.println("i=1"+(i+1));
			}
			System.out.println("run begin~");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("先停止，再遇到了sleep~进入catch");
			e.printStackTrace();
		}
	}

}
