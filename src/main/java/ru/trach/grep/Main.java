package ru.trach.grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.trach.grep.filtres.TextFilter;
import ru.trach.grep.providers.TextProvider;
import ru.trach.grep.view.TextViewer;

public class Main {
	private static BufferedReader keybordReader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		 TextFilter filter = (TextFilter) ctx.getBean("textFilter");
		 TextViewer viewer = (TextViewer) ctx.getBean("textViewer"); 
	
		 viewer.resultFilteredText(filter.filter(readStringsForFind())); 
	}
	
	private static String[] readStringsForFind() {
		String[] result = null;
		System.out.println("Что искать");
		System.out.println("=================================================");
		try {
			result = keybordReader.readLine().split(" ");
	
			} catch (IOException e1) {
					e1.printStackTrace();
			}
		
		return result;
	}
	
}
