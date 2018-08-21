package ru.trach.grep.view;

import java.util.List;

public class PrinterTextViewer implements TextViewer {
	
	
	public void resultFilteredText(List<String> text) {

		for(int i = 0; i < text.size(); i++) {
			System.out.println(text.get(i));
			System.out.println("=================================================");
		}
		
	}



}
