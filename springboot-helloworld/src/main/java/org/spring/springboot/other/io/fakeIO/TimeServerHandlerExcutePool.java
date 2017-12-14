package org.spring.springboot.other.io.fakeIO;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExcutePool {
	
	private ExecutorService executor;
	
	public TimeServerHandlerExcutePool(int maxPoolSize,int queenSize) {
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
				maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queenSize));
	}
	
	public void execute(Runnable task) {
		executor.execute(task);
	}
}
