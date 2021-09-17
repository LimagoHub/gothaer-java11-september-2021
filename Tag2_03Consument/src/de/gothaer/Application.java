package de.gothaer;

import de.gothaer.publisher.CharacterPublisher;

public class Application {

	public static void main(String[] args) {

		EndSubscriber<Character> subscriber = new EndSubscriber<Character>();
		try(CharacterPublisher publisher = CharacterPublisher.create()) {
		
			publisher.subscribe(subscriber);
			
			publisher.start();
			
			publisher.awaitTermination();
		}

	}

}
