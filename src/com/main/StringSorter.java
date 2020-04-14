package com.main;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class StringSorter {

	
	
	public static String[] sortStrings(Collator collator, String[] words)
	{
		
		int i,j;
		String v;
		 
		for (i=1; i < words.length ;i++) {
		j = i;
		v = words[i];
		while ((j>0) && (collator.compare(words[j-1], v) > 0)) {
			words[j] = words[j-1];
		j--;
		}
		words[j] = v;
		}
		
		return words;
	}
	
	public static String[] fastSortStrings(Collator collator, String[] words)
	{
		Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                
                return collator.compare(s1, s2);
            }

        });
		return words;
	}
	
	public static String[] fastSortStrings2(Collator collator, String[] words)
	{
		Arrays.sort(words, (String a,String b) -> collator.compare(a, b));
		return words;
	}
}
