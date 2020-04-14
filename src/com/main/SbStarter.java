package com.main;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class SbStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collator collator = Collator.getInstance(new Locale("pl", "PL"));

		
		String[] inputArray = {"�ukasz", "�cibor", "Stefania", "Darek", "Agnieszka", 
                "Zyta", "�rszula", "�wi�tope�k"};

				
		System.out.print(Arrays.toString(StringSorter.sortStrings(collator, inputArray)) + "\n");
		System.out.print(Arrays.toString(StringSorter.fastSortStrings(collator, inputArray)) + "\n");
		System.out.print(Arrays.toString(StringSorter.fastSortStrings2(collator, inputArray)) + "\n");

	}

}
