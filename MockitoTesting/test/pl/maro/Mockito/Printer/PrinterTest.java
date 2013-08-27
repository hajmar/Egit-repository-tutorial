package pl.maro.Mockito.Printer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.swing.tree.MutableTreeNode;

import org.junit.Test;

import pl.maro.Mockito.Printer.DocumentProxy;
import pl.maro.Mockito.Printer.Printer;
import pl.maro.Mockito.Printer.common.MutableInteger;

public class PrinterTest {

	@Test
	public void emptyDocumentPrintTest() {
		DocumentProxy mock = mock(DocumentProxy.class);
		
		Printer printer = new Printer(mock);
		int lineNumber = 0;
		MutableInteger sizeOfString = new MutableInteger(0);
		
		when(mock.getLine(lineNumber, sizeOfString)).thenReturn("");
		
		printer.printAll();
		
		verify(mock,times(1)).getLine(eq(0),(MutableInteger)any());
	}

}
