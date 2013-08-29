package pl.maro.Mockito.atm;

public class ATM {
	private Screen screen;
	private CashDispencer cashDispenser;
	private DepositSlot1 depositSlot;
	private Keypad keypad;
	
	public ATM(Screen screen, CashDispencer cashDispenser,
			DepositSlot1 depositSlot, Keypad keypad) {
		super();
		this.screen = screen;
		this.cashDispenser = cashDispenser;
		this.depositSlot = depositSlot;
		this.keypad = keypad;
	}

	public boolean verifyComponents() {
		if(!screen.testScreen())
			return false;
		if(!cashDispenser.testDispencer())
			return false;
		if(!depositSlot.testSlot())
			return false;
		if(!keypad.testKeyboard())
			return false;
		return true;
	}
	
	
}
