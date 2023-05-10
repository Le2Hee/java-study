package edu.java.class08;

public class Account {
	// field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // argument 2개를 갖는 생성자
    public Account (int accountNo, double balance) {
    	this.accountNo = accountNo;
    	this.balance = balance;
    }
    
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액(double).
     * @return 입금 후 잔액.
     */
    public double deposit(double amount) {
    	balance += amount;
    	return balance;
    }
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액(double).
     * @return 입금 후 잔액.
     */
    public double withdraw(double amount) {
    	balance -= amount;
    	return balance;
    }
    
    /**
     * 이체(transfer).
     *  
     * @param to 이체할 은행 계좌 객체(Account 타입 객체).
     * @param amount 이체할 금액(double).
     * @return true.
     */
    public boolean transfer(Account to, double amount) {
    	balance -= amount;
    	to.balance += amount;
    	
    	// 메서드 활용
//    	this.withdraw(amount); // 출금
//    	to.deposit(amount); // 입금
    	
    	return true;
    }
    
    /**
     * 정보 출력(printInfo).
     * 계좌 번호와 잔고를 출력.
     */
    public void printInfo() {
    	System.out.printf("계좌번호 : %d\n잔 고 : %f\n", accountNo, balance);
    	System.out.println();
    }
}
