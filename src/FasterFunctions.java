
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		Thread slowSortLargeArray = new Thread(()->{
			SlowFunctions.slowSortLargeArray();
		});
		Thread ackermann = new Thread(()->{
			SlowFunctions.ackermann(3, 14);
		});
		Thread millionsOfSqrts = new Thread(()->{
			SlowFunctions.millionsOfSqrts();
		});
		slowSortLargeArray.start();
		ackermann.start();
		millionsOfSqrts.start();
		try {
			slowSortLargeArray.join();
			ackermann.join();
			millionsOfSqrts.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
