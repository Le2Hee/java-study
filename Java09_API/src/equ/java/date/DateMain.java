package equ.java.date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

// java.lang.String, java.lang.System, ... -> import문 없이 사용 가능하다.
public class DateMain {

	public static void main(String[] args) {
		// Java 8 버전에서 새로 추가된 날짜와 시간관련 클래스와 메서드 사용법.
		LocalDate now = LocalDate.now(); // LocalDate 클래스의 static 메서드 호출.
		System.out.println(now); // LocalDate 클래스는 toString() 메서드를 override.
		System.out.println(now.getYear());
		System.out.println(now.getMonth()); // java.time.Month.enum 상수를 리턴.
		System.out.println(now.getMonthValue()); // 월을 숫자(int)로 리턴.
		System.out.println(now.getDayOfYear());
		System.out.println(now.getDayOfWeek()); // java.time.DayOfWeek enum 상수를 리턴.
		System.out.println(now.plusDays(1091));
		System.out.println(now.plusMonths(0));
		System.out.println(now.plusWeeks(77));
		System.out.println(now.plusYears(1));
		
		LocalDate date = LocalDate.of(2089, 8, 29);
		System.out.println(date);
		
		System.out.println("===============================================================");
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		System.out.println("hour : " + now2.getHour());
		System.out.println("minute : " + now2.getMinute());
		
		// Timestamp : 
		  // 1970-01-01 00:00:00를 기준으로 1/1000초(1 mili-second)마다
		  // 1씩 증가하는 정수를 기반으로 날짜와 시간 정보를 저장하는 클래스.
		  // LocalDateTime 객체를 Timestamp 타입 객체로 변환
		  // -> Timestamp ts = Timestamp.valueOf(now2);
		
		Timestamp ts = Timestamp.valueOf(now2);
		System.out.println(ts);
		System.out.println(ts.getTime());
		
		// Timestamp 객체를 LocalDateTime 타입 객체로 변환 : 
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);
		
	}

}
