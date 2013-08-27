package pl.maro.Mockito.Printer.common;

public class MutableInteger {
	private int data;
	
	public MutableInteger(int initializationData)	{
		this.data = initializationData;
	}
	
	public int getData()	{
		return this.data;
	}
	
	public void setData(int newInteger)	{
		this.data = newInteger;
	}
}
