package de.gothaer.publisher;

import java.util.ServiceLoader;
import java.util.concurrent.Flow.Publisher;

public interface CharacterPublisher extends Publisher<Character>, AutoCloseable{
	
	void start();
	
	void close();
	
	void awaitTermination();
	
	static CharacterPublisher create() {
		return ServiceLoader.load(CharacterPublisher.class).findFirst().get();
	}

}
