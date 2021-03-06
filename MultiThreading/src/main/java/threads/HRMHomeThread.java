package threads;

import pages.HRMHome;

public class HRMHomeThread extends Thread {
	HRMHome home;
	public HRMHomeThread(String threadname,String browser){
		super(threadname);
		home=new HRMHome(browser);
	}
	
	@Override
	public void run(){
		System.out.println("Thread started "+Thread.currentThread().getName());
		try{
		//	home.setUp();
			home.login();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			home.tearDown();
			System.out.println("Thread ended "+Thread.currentThread().getName());
			
		}
	}
}
