package ru.trach.grep.filtres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ru.trach.grep.providers.TextProvider;

public class TextFilterImpl implements TextFilter {
	private TextProvider provider;
	
	
	public TextFilterImpl(TextProvider provider) {
		this.provider = provider;
		
	}

	public List<String> filter(String[] findString) {

		List<String> result = new ArrayList<String>();
		BufferedReader reader = provider.getTextReader();
		
		String source = "";
		
		while (source != null) {
			try {
				source = reader.readLine();
			for(int i = 0; i < findString.length; i++) {
				if (contains(source, findString[i] )) {
					result.add(source);
				}
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

	protected Boolean contains(String sourceText,String find) {
		if(sourceText == null || find == null) {
			return false;
		}
		for (int i = 0; i < sourceText.length() - find.length() + 1; i++) {
				String textLineUpper = sourceText.substring(i, i + find.length()).toUpperCase();
				String findUpper = find.toUpperCase();
	
			if (textLineUpper.equals(findUpper)) {
			
				return true;
			}
		}
		return false;

	}

}
