package java_multi_thread.chapter1;
public class Tester {
	
	
	public void test1(){
		System.out.println(Thread.currentThread().getName());
		MyThread mythread=new MyThread();
		mythread.start();
		System.out.println("Done!!!");
	}
	
	
	public void test2(){
		try {
			randomThread thread=new randomThread();
			thread.setName("myThread");
			thread.start();
			for(int i=0;i<10;i++){
				int time =(int)(Math.random()*1000);
				Thread.sleep(time);
				System.out.println("main="+Thread.currentThread().getName());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	public void test3(){
		extthread t1=new extthread(1);
		extthread t2=new extthread(2);
		extthread t3=new extthread(3);
		extthread t4=new extthread(4);
		extthread t5=new extthread(5);
		extthread t6=new extthread(6);
		extthread t7=new extthread(7);
		extthread t8=new extthread(8);
		extthread t9=new extthread(9);
		extthread t10=new extthread(10);
		extthread t11=new extthread(11);
		extthread t12=new extthread(12);
		extthread t13=new extthread(13);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		
	}
	
	public void test4_run(){
		Runnable runnable =new MyRunnable();
		Thread thread=new Thread(runnable);
		thread.start();
		System.out.println("运行结束~~~~");
	}
	
		
  public void test5(){
	  ThreadNotShareIns aIns=new ThreadNotShareIns("A");
	  ThreadNotShareIns bIns= new ThreadNotShareIns("B");
	  ThreadNotShareIns cIns=new ThreadNotShareIns("C");
	  
	  aIns.start();
	  bIns.start();
	  cIns.start();
	  
  }
  
  
  public void test6(){
	  ThreadWithShareIns myThreadWithShareIns =new ThreadWithShareIns();
	  Thread aIns=new Thread(myThreadWithShareIns,"A");
	  Thread bIns=new Thread(myThreadWithShareIns,"B");
	  Thread cIns=new Thread(myThreadWithShareIns,"C");
	  Thread dIns=new Thread(myThreadWithShareIns,"D");
	  Thread eIns=new Thread(myThreadWithShareIns,"E");
	  aIns.start();
	  bIns.start();
	  cIns.start();
	  dIns.start();
	  eIns.start();
  }
	
	public static void main(String[] args) {
		Tester pp=new Tester();
		//pp.test1();
		//pp.test2();
//		pp.test3();
//		pp.test4_run();
		//pp.test5();
		pp.test6();
	}

}
