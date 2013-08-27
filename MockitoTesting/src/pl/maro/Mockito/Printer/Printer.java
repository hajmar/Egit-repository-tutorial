package pl.maro.Mockito.Printer;

import pl.maro.Mockito.Printer.common.MutableInteger;

public class Printer {
	private DocumentProxy proxy;
	
	public Printer(DocumentProxy proxy) {
		this.proxy = proxy;
	}

	public void printAll(){
		int lineNumber = 0;
		MutableInteger sizeOfString = new MutableInteger(0);
		String result;
		
		result = proxy.getLine(lineNumber, sizeOfString);
	}
}
