package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.main.SbStarter;
import com.main.StringSorter;

class StringSorterTest {

	Collator collator = Collator.getInstance(new Locale("pl", "PL"));

	@Test
	void testSortStrings() 
	{
		String[] inputArray = {"£ukasz", "Œcibor", "Stefania", "Darek", "Agnieszka", 
	            "Zyta", "Órszula", "Œwiêtope³k"};
		List<String> outputArray = Arrays.asList(StringSorter.sortStrings(collator, inputArray));
		assertEquals(outputArray.get(0), "Agnieszka");
		assertEquals(outputArray.get(1), "Darek");
		assertEquals(outputArray.get(2), "£ukasz");
		assertEquals(outputArray.get(3), "Órszula");
		assertEquals(outputArray.get(4), "Stefania");
		assertEquals(outputArray.get(5), "Œcibor");
		assertEquals(outputArray.get(6), "Œwiêtope³k");
		assertEquals(outputArray.get(7), "Zyta");
		
		System.out.print("List sorted from method sortStrings:\n" + outputArray + "\n");
	}

	@Test
	void testFastSortStrings() 
	{
		String[] inputArray = {"£ukasz", "Œcibor", "Stefania", "Darek", "Agnieszka", 
	            "Zyta", "Órszula", "Œwiêtope³k"};
		List<String> outputArray = Arrays.asList(StringSorter.fastSortStrings(collator, inputArray));
		assertEquals(outputArray.get(0), "Agnieszka");
		assertEquals(outputArray.get(1), "Darek");
		assertEquals(outputArray.get(2), "£ukasz");
		assertEquals(outputArray.get(3), "Órszula");
		assertEquals(outputArray.get(4), "Stefania");
		assertEquals(outputArray.get(5), "Œcibor");
		assertEquals(outputArray.get(6), "Œwiêtope³k");
		assertEquals(outputArray.get(7), "Zyta");
		
		System.out.print("List sorted from method fastSortStrings:\n" + outputArray + "\n");
	}

	@Test
	void testFastSortStrings2() 
	{
		String[] inputArray = {"£ukasz", "Œcibor", "Stefania", "Darek", "Agnieszka", 
	            "Zyta", "Órszula", "Œwiêtope³k"};
		List<String> outputArray = Arrays.asList(StringSorter.fastSortStrings2(collator, inputArray));
		assertEquals(outputArray.get(0), "Agnieszka");
		assertEquals(outputArray.get(1), "Darek");
		assertEquals(outputArray.get(2), "£ukasz");
		assertEquals(outputArray.get(3), "Órszula");
		assertEquals(outputArray.get(4), "Stefania");
		assertEquals(outputArray.get(5), "Œcibor");
		assertEquals(outputArray.get(6), "Œwiêtope³k");
		assertEquals(outputArray.get(7), "Zyta");
		
		System.out.print("List sorted from method fastSortStrings2:\n" + outputArray + "\n");
	}
	
	@Test
	void stressTest()
	{
		String[] inputArray = {"£ukasz", "Œcibor", "Stefania", "Darek", "Agnieszka", 
	            "Zyta", "Órszula", "Œwiêtope³k"};
		
		long startTime = System.nanoTime();
		
		for(int i = 0; i < 100000; i++ )
		{
			StringSorter.sortStrings(collator, inputArray);
		}
		
		long endTime = System.nanoTime();
		long timeElapsedMiliSeconds = (endTime - startTime) / 1000000;
		
		System.out.print("Time needed for sortString() to sort table 100 k times(ms): " + timeElapsedMiliSeconds + "\n");
		
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < 100000; i++ )
		{
			StringSorter.fastSortStrings(collator, inputArray);
		}
		
		endTime = System.nanoTime();
		timeElapsedMiliSeconds = (endTime - startTime) / 1000000;
		
		System.out.print("Time needed for fastSortStrings() to sort table 100 k times(ms): " + timeElapsedMiliSeconds + "\n");
		
		
		startTime = System.nanoTime();
		
		for(int i = 0; i < 100000; i++ )
		{
			StringSorter.fastSortStrings2(collator, inputArray);
		}
		
		endTime = System.nanoTime();
		timeElapsedMiliSeconds = (endTime - startTime) / 1000000;
		
		System.out.print("Time needed for fastSortStrings2() to sort table 100 k times(ms): " + timeElapsedMiliSeconds + "\n");
	}
}
