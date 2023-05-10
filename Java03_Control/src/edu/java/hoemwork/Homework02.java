package edu.java.hoemwork;

public class Homework02 {

	public static void main(String[] args) {
		// 369 게임 출력
        /* 실행 결과
            1   2   *   4   5   *   7   8   *   10  
            11  12  *   14  15  *   17  18  *   20  
            21  22  *   24  25  *   27  28  *   *   
            *   *   *   *   *   *   *   *   *   40  
            41  42  *   44  45  *   47  48  *   50  
            51  52  *   54  55  *   57  58  *   *   
            *   *   *   *   *   *   *   *   *   70  
            71  72  *   74  75  *   77  78  *   80  
            81  82  *   84  85  *   87  88  *   *   
            *   *   *   *   *   *   *   *   *   100
         */
		
		 System.out.println("369 게임");
	     System.out.println("--------");
	     
		for (int n = 1; n<=10; n++) {
			if (n%3==0) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 11; n<=20; n++) {
			if (n%3==1) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 21; n<=30; n++) {
			if (n%3==2) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 31; n<=40; n++) {
			if (n<40) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 41; n<=50; n++) {
			if (n%3==1) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 51; n<=60; n++) {
			if (n%3==2) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 61; n<=70; n++) {
			if (n<70) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 71; n<=80; n++) {
			if (n%3==1) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 81; n<=90; n++) {
			if (n%3==2) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
		
		System.out.println();
		
		for (int n = 91; n<=100; n++) {
			if (n<100) {
				System.out.print("*\t");
			} else {
				System.out.print(n+"\t");
			}
		}
	}

}
