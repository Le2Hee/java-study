package edu.java.loop03;

public class LoopMain03 {

	public static void main(String[] args) {
		/* 문제1. 아래와 같은 형식으로 구구단 2단을 출력하세요.
        2 x 1 = 2
        2 x 2 = 4
        2 x 3 = 6
        ...
        2 x 8 = 16
        2 x 9 = 18
     */
    
    /* 문제2. 아래와 같이 출력하세요.
        1     2     3     4     5     6     7     8     9     10
        11    12    13    14    15    16    17    18    19    20
        21    22    23    24    25    26    27    28    29    30
        31    32    33    34    35    36    37    38    39    40
        41    42    43    44    45    46    47    48    49    50
        51    52    53    54    55    56    57    58    59    60
        61    62    63    64    65    66    67    68    69    70
        71    72    73    74    75    76    77    78    79    80
        81    82    83    84    85    86    87    88    89    90
        91    92    93    94    95    96    97    98    99    100
     */
		System.out.println("========내답지========");
		
		System.out.println("문제 1번");
		
		for (int n = 1; n<10; n++) {
			int m = n*2;
			System.out.println("2 X "+n+" = "+m);
		}
		
		System.out.println("문제 2번");
		
		for (int n=1;n<11;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=11;n<21;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=21;n<31;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=31;n<41;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=41;n<51;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=51;n<61;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=61;n<71;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=81;n<91;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		for (int n=91;n<101;n++) {
			System.out.print(n+" \t");
		}
		System.out.println();
		
		System.out.println("======= 답안 =======");
		
		System.out.println("문제 1번");
		for (int n = 1; n < 10; n++) {
//			System.out.println("2 X "+n+" = "+(n*2));
			System.out.printf("2 x %d = %d\n", n, 2 * n); 
			// printf 는 처음에는 무조건 문자열 이고 지금 들어가있는건 포멧,템플릿이라고 한다.
			// %d : 정수
			// \t : tab만큼 뛰어진다.
			// \n " new line 이라는 뜻 -> 줄바꿈
			// %d, %d 가 비어있는 자리라고 생각하면된다 첫번째 %d에 n이 들어가고, 두번째 %d에 2*n이 들어간다.
			// 숫서대로 들어간다.
		}
		// system.out.printf(문자열 템플릿/포맷, 템플릿을 채울 값들);
		// %d : 정수, %f : 실수 %s : 문자열
		// \n : 줄바꿈(new line), \t : 탭(tab)
		
		System.out.println("문제 2번");
		
		for (int n=1; n <= 100; n++) {
			System.out.print(n+"\t");
			if (n % 10 == 0) {
				System.out.println(); // 줄바꿈
			}
		}
		
		
	}

}
