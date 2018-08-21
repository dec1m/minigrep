package ru.trach.grep.filtres;

import java.util.List;




public interface TextFilter {
	List<String> filter(String[] findString);
}
