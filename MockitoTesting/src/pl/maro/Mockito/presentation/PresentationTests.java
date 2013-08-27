package pl.maro.Mockito.presentation;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PresentationTests {

	@Test
	public void emptyDocumentTest() {

		List mockedList = mock(List.class);

		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test
	public void stubbingTest()	{
		 //You can mock concrete classes, not only interfaces
		 LinkedList mockedList = mock(LinkedList.class);
		 
		 //stubbing
		 stub(mockedList.get(0)).toReturn("first");
		 stub(mockedList.get(1)).toThrow(new RuntimeException());
		 
		 //following prints "first"
		 System.out.println(mockedList.get(0));
		 
		 //following throws runtime exception
		 System.out.println(mockedList.get(1));
		 
		 //following prints "null" because get(999) was not stubbed
		 System.out.println(mockedList.get(999));
		 
		 //Stubbed invocations are verified implicitly. The execution flow of your own code does it completely for free. 
		 //Although it is possible to verify a stubbed invocation, in majority of cases it's not necessary:
		 verify(mockedList).get(0);
	}
}
