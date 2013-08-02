package Core_System;

public class MbankException extends Exception {

	private static final long serialVersionUID = 1L;

	public MbankException() {
	}

	public MbankException(String msg) {
		super(msg);
	}

	public static void f() throws MbankException {
		System.out.println("Throwing MbankException from f()");
		throw new MbankException();
	}

	public static void g() throws MbankException {
		System.out.println("Throwing MbankException from g()");
		throw new MbankException("Originated in g()");
	}
}