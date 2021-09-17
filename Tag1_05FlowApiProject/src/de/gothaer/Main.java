package de.gothaer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception{
		new Main().run();
	}

	private void run() throws Exception{
		final List<String> liste = List.of("1","2","drei","4");
		
		EndSubscriber<Integer> subscriber = new EndSubscriber<>();
		
		Transformer<String, Integer> transformer = new Transformer<String, Integer>(Integer::valueOf);
		transformer.subscribe(subscriber);
		
		
		List<Future<Integer>> futures =new ArrayList<>();
		
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
//		try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>(service, 256)) {
//			
//			publisher.subscribe(transformer);
//			liste.forEach(publisher::submit);
//			
//		}
		
		for (int i = 0; i < 10; i++) {
			futures.add(service.submit(new MyCallable()));
			
		}
		
		
		service.shutdown();
		//service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		
//		int e1 = f1.get();
//		int e2 = f2.get();
		
	
		System.out.println("Fetisch");
	}
	
	public void foo() {
		
	}
	
	class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("xyz");
			
		}
		
	}
	
	class MyCallable implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			// sleep
			return 42;
		}
		
	}

}
