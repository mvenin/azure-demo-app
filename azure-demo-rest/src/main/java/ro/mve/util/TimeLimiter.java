package ro.mve.util;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

public class TimeLimiter {

	private static AtomicLong lastTimeCall = new AtomicLong(System.currentTimeMillis());

	public static <T> T withMillisLimit(Callable<T> c, long millis) throws Exception  {
		T rs;
		long start = System.currentTimeMillis();
		try {
			if( (start - lastTimeCall.get()) < millis ) {
				System.out.println("wait "+millis+" millis; because "+ (start - lastTimeCall.get()));
				try {
					Thread.sleep(millis);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			lastTimeCall.set(System.currentTimeMillis());
			rs = c.call();
			return rs;
		} catch (Exception e) {
			lastTimeCall.set(System.currentTimeMillis());
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Long rs = withMillisLimit(new Callable<Long>() {

				@Override
				public Long call() throws Exception {
					try {
						Thread.sleep(1000*1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return 1L;
				}
			}, 1000 * 2);
			System.out.println(LocalTime.now());
		}
	}
	
}
