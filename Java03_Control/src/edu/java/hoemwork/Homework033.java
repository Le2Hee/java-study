package edu.java.hoemwork;

import java.util.Random;

public class Homework033 {

	public static void main(String[] args) {
		 /* 문제 1. 아래와 같이 출력하세요.
        *
        **
        ***
        ****
        *****
      */
     
     /* 문제 2. 아래와 같이 출력하세요.
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
      */

     /* 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요.
        두 눈의 합이 5가 되면 출력을 멈추세요.
        힌트 1: Random 타입의 nextInt(start, end) 메서드를 사용.
        힌트 2 무한 루프: for ( ; ; ) {...}, while (true) {...}
        출력 결과 예시:
        (2, 4)
        (6, 1)
        (3, 3)
        (4, 1)
      */
		
		 // 문제 1
	      
	      System.out.println("문제 1번");
	      for (int a = 1; a < 6; a++) {
	         for (int b = 1; b <= a; b++) {
	            System.out.print("*");
	            if (a == b) {
	               System.out.println();
	            }
	         }
	      }
	      
	      System.out.println("\n======\n");
	      
	      System.out.println("문제 2번");
	      for (int a = 1; a < 6; a++) {
	         for (int b = 1; b <= a; b++) {
	            System.out.print("*");
	            if (a == b) {
	               System.out.println();
	            }
	         }
	      }
	      for (int a = 4; a > 0; a--) {
	         for (int b = 1; b <= a; b++) {
	            System.out.print("*");
	            if (a == b) {
	               System.out.println();
	            }
	         }
	      }
	      
	      System.out.println("\n==========\n");
	      
	      System.out.println("문제 3번");
	      
	      Random ran = new Random();
	      
	      for (int n; ; ) {
	    	  int min = 1;
	    	  int max = 6;
	    	  for (int m; ;) {
	    		  m = ran.nextInt(min, max);
	    		  n = ran.nextInt(min, max);
	    		  System.out.printf("(%d) , (%d)\n", n, m);
	    		  if (n + m == 5) {
	    			  break;
	    		  }
	    	  
	    	  }
	    	  break;
	    		  
	    	  
	      }
	}

}
