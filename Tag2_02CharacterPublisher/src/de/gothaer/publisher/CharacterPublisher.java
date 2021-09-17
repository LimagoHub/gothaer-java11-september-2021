package de.gothaer.publisher;

import java.util.ServiceLoader;
import java.util.concurrent.Flow.Publisher;
import java.util.function.Supplier;

import de.gothaer.publisher.impl.CharacterPublisherImpl;

public interface CharacterPublisher extends Publisher<Character>, AutoCloseable{
	
	void start();
	
	void close();
	
	void awaitTermination();
	
	static <T> CharacterPublisher create(Supplier<T> supplier) {
		return new CharacterPublisherImpl(supplier);
	}

}
