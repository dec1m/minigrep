package ru.trach.grep.providers;


import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;

import org.junit.Before;
import org.junit.Test;

public class FileTextProvidersTest {
	private FileTextProvider provider;
	@Before
	public void setUp() {
		provider = new FileTextProvider();
		
	}
	@Test
	public void getTextReader_test() {
		Boolean result = false;
		Object reader =  provider.getTextReader();	 
	  if(reader instanceof  BufferedReader) {
		  result = true;
	  }
	  assertTrue(result);
	}

}
