package equ.java.method03;

import java.util.Random;

public class MethodMain03 {

	public static int[] makeTestData(int n) {
		int[] array = new int[n];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10000);
		}
		return array;
	}
	
	public static void printTestArray(int[] arr) {  
		System.out.print("[ ");
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println("]");
		// void 메서드는 값만 리턴하지않고 생략하는 것이다.
		// return;을 생략해도 됨.
	}
	
	public static void main(String[] args) {
//		Random random = new Random();   // 메서드로 만들어 보기
//		int[] arr = new int[5];  
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = random.nextInt(10000);
//		}
		int[] arr = makeTestData(5);
		
//		for (int x : arr) {   // 메서드로 만들어 보기
//			System.out.print(x + " ");
//		}
//		System.out.println();
		
		printTestArray(arr);
		
		System.out.println("=======================================================");
		
		int arrsum = sum(arr);
		System.out.println("총 합 : " + arrsum);
		
		System.out.println("=======================================================");
		
		double aver = mean(arr);
		
		System.out.println("평 균 : " + aver);
		
		System.out.println("=======================================================");
		
		int max = max(arr);
		System.out.println("최 대 값 : " + max);
		
		System.out.println("=======================================================");
		
		int maxAt = maxAt(arr);
		System.out.println("최 대 값 인 덱 스 : " + maxAt);
		
		System.out.println("=======================================================");
		
		int min = min(arr);
		System.out.println("최 소 값 : " + min);
		
		System.out.println("=======================================================");
		
		int minAt = minAt(arr);
		System.out.println("최 소 값 인 덱 스 : " + minAt);
		
		
		
		
	}
	
	
	 /**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
    public static int sum (int[] arr) {
    	int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    		sum = sum + arr[i];
    	}
//    	for (int x : arr) {
//    		sum += x;
//    	}
//    	return sum;
    	
    	return sum;
    }
    
    /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균(double).
     */
    public static double mean (int[] arr) {
    	int sum = 0;
    	int count = 0;
    	for (int i = 0; i < arr.length; i++) {
    		sum = sum + arr[i];
    		count++;
    	}
    	int av = sum/count;
    	return av;
    	
    	// 평균 = 합계 / 개수 ;
//    	return (double) sum(arr) / arr.length;
    	             // sum 메서드
    }
    
    /**
     * max
     * 정수 배열에서 최댓값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값.
     */
    public static int max (int[] arr) {
    	int max = arr[0];
    	for (int i= 0; i < arr.length; i++) {
    		if (max < arr[i]) {
    			max = arr[i];
    		}
    	}
    	return max;
    	
//    	for (int x : arr) {
//    		max = (x > max) ? x : max;
//    	}
//    	return max;
    }
    
    /**
     * maxAt
     * 정수 배열에서 최댓값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값의 인덱스.
     * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
     */
    public static int maxAt (int[] arr) {
    	int max = arr[0];
    	int maxAt = 0;
    	for (int i= 0; i < arr.length; i++) {
    		if (max < arr[i]) {
    			max = arr[i];
    			maxAt = i;
    		}
    		
    		
    	}
    	return maxAt;
    }

    /**
     * min
     * 정수 배열에서 최솟값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값.
     */
    public static int min (int[] arr) {
    	int min = arr[0];
    	for (int i= 0; i < arr.length; i++) {
    		if (min > arr[i]) {
    			min = arr[i];
    		}
    	}
    	return min;
    }
    
    /**
     * minAt
     * 정수 배열에서 최솟값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값의 인덱스.
     * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
     */
    public static int minAt (int[] arr) {
    	int min = arr[0];
    	int minAt = 0;
    	for (int i= 0; i < arr.length; i++) {
    		if (min > arr[i]) {
    			min = arr[i];
    			minAt = i;
    		}
    	}
    	return minAt;
    	
    	// 최솟값을 찾음.
    	// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
    	// 최솟값을 찾았으면 반복을 종료.
    	// 반복문이 종료됐을 때의 인덱스를 리턴.
//    	int minVal = min(arr);
//    	int index = 0;
//    	for (index = 0; index < arr.length; index++) {
//    		if (arr[index] == minVal) {
//    			break;
//    		}
//    	}
//    	return index;
    	
    }
    
    
    

	
    
    
	
	
	
}
