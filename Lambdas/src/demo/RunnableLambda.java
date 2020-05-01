package demo;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {

		// Old style
//		Runnable runnable = new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < 3; i++) {
//					System.out.println(
//							"Hello World from thread ["+
//					Thread.currentThread().getName()+ "]");
//				}
//			}
//		};
		
		// Lambda style
		Runnable runnableLambda = () -> {
			
				for (int i = 0; i < 3; i++) {
					System.out.println(
							"Hello World from thread ["+
					Thread.currentThread().getName()+ "]");
				}
			};
		
		Thread t = new Thread(runnableLambda);
		t.start();
		t.join();
	}

}
