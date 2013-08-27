package pl.maro.Mockito.first;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;
import org.mockito.MockitoAnnotations.Mock;


public class FirstTest {

	@Test
	public void iteratorWillReturnHelloWorld() {
		Iterator i = mock(Iterator.class);

		when( i.next()).thenReturn("Hello").thenReturn("World");
		
		String result = i.next() + " " + i.next();
		
		assertEquals("Hello World", result);
	}
	
	@Test
	public void comparableWithAnyIntValue()	{
		Comparable c = mock(Comparable.class);
		
		when(c.compareTo(anyInt())).thenReturn(-1);
		
		assertEquals(-1,c.compareTo(0x33));
	}
	
	@Test(expected=IOException.class)
	public void outputStreamWriter_rethrow_exception() throws IOException	{
		@Mock ArrayList arrayList;
		
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		
		//doThrow(new IOException()).when(mock).close();
		when(mock.close()).doThrow(new IOException());
		
		osw.close();
		verify(mock).close();
	}
	
	@Test
	public void OutputStreamWriterBuffersAndSendToOutputStream() throws IOException	{
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		
		osw.write("a");
		osw.flush();
		
		BaseMatcher arrayStartingWithA = new BaseMatcher() {
			@Override
			public void describeTo(Description description) {
				//NOTHING	
			}
			@Override
			public boolean matches(Object item) {
				byte [] actual = (byte[]) item;
				return actual[0] == 'a';
			}
		};
		
		verify(mock).write(argThat(arrayStartingWithA), eq(0), eq(1));
	}
	
	
	
	

}
