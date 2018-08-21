package ru.trach.grep.providers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTextProvider implements TextProvider {
	private Boolean correctPath = false;
	private BufferedReader keybordReader = new BufferedReader(new InputStreamReader(System.in));
	private String path = "";
	BufferedReader result = null;

	public BufferedReader getTextReader() {
		System.out.println("Введите путь к тексту");
		while (result == null) {
			
			try {
				path = keybordReader.readLine();
				result = new  BufferedReader(new FileReader(path));
			} catch (IOException e) {
				System.out.println("Фаил не найден");
			}
			
		
			
		}
		
	
		return result;
	}
 private void closeConnections() {
	 try {
		 System.out.println("CLOSE");
		result.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	public Boolean isCorrectPath() {
		return correctPath;
	}

	

}
