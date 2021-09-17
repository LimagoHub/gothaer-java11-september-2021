package de.gothaer.provider.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import de.gothaer.provider.StringSupplier;

public class FileStringSupplier implements StringSupplier {

	@Override
	public String get() {
		try {
			var path = Path.of("MyText.txt");
			return Files.readString(path);
		} catch (IOException e) {
			throw new RuntimeException("Upps");
		}
	}

}
