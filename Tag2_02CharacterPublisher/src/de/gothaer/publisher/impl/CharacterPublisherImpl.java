package de.gothaer.publisher.impl;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import de.gothaer.provider.StringSupplier;
import de.gothaer.publisher.CharacterPublisher;

public class CharacterPublisherImpl extends SubmissionPublisher<Character> implements CharacterPublisher {

	private String toSend;
	
	
	
	public CharacterPublisherImpl() {
		this.toSend = StringSupplier.create().get();
		
	}



	@Override
	public void start() {
		
		toSend.chars().mapToObj(i->Character.valueOf((char) i)).forEach(this::submit);
		
	}



	@Override
	public void awaitTermination() {
		try {
			((ForkJoinPool) getExecutor()).awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
