package de.gothaer;

import de.gothaer.publisher.CharacterPublisher;

public class Application {

	public static void main(String[] args) {

		
		try(var publisher = CharacterPublisher.create(Schwein::new)) {
		
			publisher.subscribe(new EndSubscriber<>());
			
			publisher.start();
			
			publisher.awaitTermination();
		}

	}

}

interface Liste<T> {
	void append(T t);
	T get();
	boolean remove();
	default boolean removeAll() {
		if(isEmpty()) return false;
		while(remove());
		return true;
	}
	
	boolean update();
	boolean moveNext();
	boolean movePrev();
	default boolean moveFirst() {
		if(isEmpty()) return false;
		while(movePrev());
		return true;
	}
	boolean moveLaste();
	boolean isEmpty();
	boolean isBOL();
	boolean isEOL();
}
