package edu.java.hoemwork;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
        // 가위-0, 바위-1, 보-2

        // 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
        Random random = new Random();
        int computer = random.nextInt(3);

        // 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
        System.out.println("가위/바위/보 게임");
        System.out.println("-----------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("-----------------");
        System.out.print("선택>>> ");

        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();

        // print(computer : user)
        System.out.println("computer(" + computer + ") : user(" + user + ")");

        // TODO: 누가 이겼는 지 결과를 출력하세요.
        
        if (computer==0) {
            if (user == 0) {
               System.out.println("무승부");
            }
            if (user == 1) {
               System.out.println("user 승리");
            }
            if (user == 2) {
               System.out.println("computer 승리");
            }
         
            
         }
         if (computer==1) {
            if (user == 0) {
               System.out.println("computer 승리");
            }
            if (user == 1) {
               System.out.println("무승부");
            }
            if (user == 2) {
               System.out.println("user 승리");
            }
         
            
         }
         if (computer==2) {
            if (user == 0) {
               System.out.println("user 승리");
            }
            if (user == 1) {
               System.out.println("computer 승리");
            }
            if (user == 2) {
               System.out.println("무승부");
            }
         
            
         }
         
         // 해석
         
         // 방법 1 : 
         
         /*
         if (user == 0) { // 사용자 = 가위
        	 if (computer == 0 ) { //컴 :가위
        		 System.out.println("비김");
        	 } else if (computer == 1) { //컴 :바위
        		 System.out.println("컴퓨터 승");
        	 } else { //컴 :보
        		 System.out.println("사용자 승");
        	 }
         } else if (user ==1) { // 사용자 = 바위
        	 if (computer == 0 ) { //컴 :가위
        		 System.out.println("사용자 승");
        	 } else if (computer == 1) { //컴 :바위
        		 System.out.println("비김");
        	 } else { //컴 :보
        		 System.out.println("컴퓨터 승");
        	 }
         } else { // 사용자 = 보
        	 if (computer == 0 ) { //컴 :가위
        		 System.out.println("컴퓨터 승");
        	 } else if (computer == 1) { //컴 :바위
        		 System.out.println("사용자 승");
        	 } else { //컴 :보
        		 System.out.println("비김");
        	 }
         }
         */
         
         
         // 방법 2 :  //비김을 빼고 승, 패 만 따로 묶어서 정리하는 경우
         /*
         if (computer == user) {  // 비기는 경우
        	 System.out.println("비김");
         } else if (user == 0) { // 비기지 않았는데 사용자가 가위
        	 if (computer == 1) {
        		 System.out.println("컴퓨터 승");
        	 } else {
        		 System.out.println("사용자 승");
        	 }
         } else if (user == 1) { // 비기지 않았는데 사용자가 바위
        	 if (computer == 0) {
        		 System.out.println("사용자 승"); 
        	 } else {
        		 System.out.println("컴퓨터 승");
        	 }
         } else { // 비기지 않았는데 사용자가 보
        	 if (computer == 0) {
        		 System.out.println("사용자 승");
        	 } else {
        		 System.out.println("컴퓨터 승");
        	 }
         }
         */
         
         // 방법 3: ||(or)를 사용해서 하는 방법
         
         /*
         if (user == computer) { //비긴경우
        	 System.out.println("비김");
         } else if ((user==0 && computer==2)  
        		 || (user==1 && computer==0) 
        		 || (user==2 && computer==1)) { // (a)또는 (b)또는 (c) 사용자가 이긴 경우 3가지
        	 System.out.println("사용자 승");
         } else { // 사용자가 진 경우
        	 System.out.println("컴퓨터 승");
         }
         */
         
         // 방법 4 : int 변수를 설정해 계산하는 경우
         
         /*
         int diff = user - computer;
         if (diff == 0) {
        	 System.out.println("비김");
         } else if ((diff == -2) || (diff == 1) ) {
        	 System.out.println("유저 승");
         } else {
        	 System.out.println("컴퓨터 승");
         }
         */
         
         
         
         
         
	} // end main

}
