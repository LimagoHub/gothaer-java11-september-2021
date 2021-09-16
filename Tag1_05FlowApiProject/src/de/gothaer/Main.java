package de.gothaer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception{
		new Main().run();
	}

	private void run() throws Exception{
		final List<String> liste = List.of("1","2","drei","4");
		
		EndSubscriber<String> subscriber = new EndSubscriber<>();
		
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>(service, 256)) {
			
			publisher.subscribe(subscriber);
			liste.forEach(publisher::submit);
			
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	
		System.out.println("Fetisch");
	}

}
