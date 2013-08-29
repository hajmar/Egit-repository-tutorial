package pl.maro.Mockito.atm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ATMTest {
	ATM atm;
	Screen screenMock;
	CashDispencer cashMock;
	DepositSlot1 slotMock;
	Keypad keypadMock;
	
	@Before
	public void setUp()	{
		screenMock = mock(Screen.class);
		cashMock = mock(CashDispencer.class);
		slotMock = mock(DepositSlot1.class);
		keypadMock = mock(Keypad.class);
		atm = new ATM(screenMock, cashMock, slotMock, keypadMock);
	}
	
	@Test
	public void startAtmtest() {
		when(screenMock.testScreen()).thenReturn(true);
		when(cashMock.testDispencer()).thenReturn(true);
		when(slotMock.testSlot()).thenReturn(true);
		when(keypadMock.testKeyboard()).thenReturn(true);
		
		atm.verifyComponents();
		verify(screenMock,times(1)).testScreen();
		verify(cashMock,times(1)).testDispencer();
		verify(slotMock,times(1)).testSlot();
		verify(keypadMock, times(1)).testKeyboard();
		verifyNoMoreInteractions(screenMock,cashMock,slotMock,keypadMock);
	}

}
