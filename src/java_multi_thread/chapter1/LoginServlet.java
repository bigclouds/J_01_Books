package java_multi_thread.chapter1;

public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;
	//synchronized是同步关键字
	synchronized public static void doPost(String username, String password){
		try {
			usernameRef =username;
			if(usernameRef.equals("a")){
				Thread.sleep(5000);
				
			}
			
			passwordRef=password;
			System.out.println("username="+ usernameRef + "; password="+passwordRef);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
