package de.gothaer.provider;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public interface StringSupplier extends Supplier<String>{
	
	static StringSupplier create() {
		return ServiceLoader.load(StringSupplier.class).findFirst().get();
	}

}
