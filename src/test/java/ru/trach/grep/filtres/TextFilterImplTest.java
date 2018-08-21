package ru.trach.grep.filtres;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.junit.Before;
import org.junit.Test;

import ru.trach.grep.providers.TextProvider;

public class TextFilterImplTest {
	private TextFilterImpl filter;
	private String text;
	@Before
	public void setUp() {
		text = "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123";
		filter = new TextFilterImpl(new TextProvider() {
			BufferedReader result = null;
	
			public BufferedReader getTextReader() {
				try {
					result = new BufferedReader(new FileReader("C:\\test.txt"));

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return result;
			}
		});
	}

	@Test
	public void contains_lover_engl() {
	

		assertTrue(filter.contains(text, "lover"));
	}

	@Test
	public void contains_UPPER_engl() {
	

		assertTrue(filter.contains(text, "UPPER"));
	}



	@Test
	public void contains_lover_rus() {
	 

		assertTrue(filter.contains(text, "строчные"));
	}

	@Test
	public void contains_UPPER_rus() {


		assertTrue(filter.contains(text, "ПРОПИСНЫЕ"));
	}

	@Test
	public void filter_a_engl() {
		assertEquals(filter.filter(new String[] {"a"}).get(0), "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123");
	}

	@Test
	public void filter_A_engl() {
		assertEquals(filter.filter(new String[] {"UPPER"}).get(0), "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123");
	}

	@Test
	public void filter_rus() {
		assertEquals(filter.filter(new String[] {"стр"}).get(0), "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123");
	}

	@Test
	public void filter_A_rus() {
		assertEquals(filter.filter(new String[] {"ПРОПИСНЫЕ"}).get(0), "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123");
	}

	@Test
	public void filter_123() {
		assertEquals(filter.filter(new String[] {"123"}).get(0), "EnGl4ishUpperAndLover3257TextРуССкийСтроЧнЫЕИпроПисныЕ123");

	}


}
