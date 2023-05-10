package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account hum1 = new Account(110473, 50000);
		hum1.printInfo();
		
		Account hum2 = new Account(979020, 20000);
		hum2.printInfo();
		
		hum1.deposit(80000);
		hum1.printInfo();
		
		hum1.withdraw(32800);
		hum1.printInfo();
		
		hum1.transfer(hum2, 20000); // hum1번 계좌에서 hum2번 계좌로 20000원 이체
		hum1.printInfo();
		hum2.printInfo();
		
		
	}

}
