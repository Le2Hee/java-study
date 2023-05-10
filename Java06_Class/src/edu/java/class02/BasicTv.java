package edu.java.class02;

// 클래스(class) : 프로그램에서 필요한 데이터와 기능을 묶어서 하나의 "데이터 타입"으로
//                 정의한 것.
// - 데이터 -> 필드(field), 멤버 변수, 속성(property).
  // 데이터는 필드로 선언.
// - 기능 -> 메서드(method)로 선언.
// 테이터 타입 -> 변수 선언, 파라미터 선언, 메서드 리턴 타입 선언.
// 클래스 선언 : [수식어] class 클래스이름 {...}
  // [] : 생략가능
// 클래스 이름 작성
 // - 영문자, 숫자, _, $를 사용할 수 있음.
 // - 다른 특수기호들은 사용할 수 없다.
 // - 숫자로 시작할 수 없다.
 // - 첫 글자 부터 대문자로 시작하는 camel 표기법을 권장.


public class BasicTv {
	// field
	 // class의 맴버다 라고 해서 맴버 변수라고 하고 최근에는 필드(field)라고 많이한다.
	 // TV의 속성들 (해상도, 볼륨, 전원, ... 등등)
	// field와 지역변수 다른점
	// field - 클래스의 모든 메서드에서 사용 가능.
	private static final int MAX = 5;
	private static final int MIN = 0;
	boolean powerOn; // TV의 전원 상태를 저장할려는 변수(true : 전원on, false : 전원off)를 저장하는 필드
	int channel; // TV의 현재 채널을 저장하는 필드.
	int volume; // TV의 현재 음량을 저장하는 필드.
	// 이 기능들을 매서드로 만들면 된다.
	
	// 메서드 안에서의 변수(지역변수)는 사용전 값을 초기화 시켜야되지만,
	  // 필드 변수(멤버 변수)는 초기화 하지않아도 사용할수 있다.
	
	// method
	public void poweOnOff () {
		if (powerOn) { // TV가 켜져 있으면
			powerOn =false;  // TV를 끔.
			System.out.println("TV OFF");
		} else { // TV가 꺼져 있으면
			powerOn = true;  // TV를 켠다.
			System.out.println("TV ON");
		}
	}
	
	public void channelUp() {
		if (powerOn) { // TV 전원이 ON인 경우 (true)
			if(channel < MAX) {  // TV 채널 번호가 최댓값보다 작은 경우
				channel++; // 현재 채널 번호를 1 증가.
			} else {  // TV 채널 번호가 최댓값보다 크거나 같으면
				channel = MIN; // TV채널의 최솟값으로 바꿈(채널을 순환시킴).
			}
			
		}
		
		System.out.println("채널 : " + channel);
		
		
	}
	
	public void channelDoun() {
		if (powerOn) { // TV 전원이 ON인 경우 (true)
			if(channel > MIN) {  // TV 채널 번호가 최솟값보다 클 경우
				channel--; // 현재 채널 번호를 1 감소.
			} else {  // TV 채널 번호가 최댓값보다 크거나 같으면
				channel = MAX; // TV채널의 최댓값으로 바꿈(채널을 순환시킴).
			}
			
		}
		
		System.out.println("채널 : " + channel);
	}

	public void volumUp() {
		if (powerOn == true) {
			if(volume < 5) {
				volume++; // 현재 음량을 1 증가.
				System.out.println("음량 : " + volume);
			} else {
				System.out.println("현재 음량이 최대입니다.");
			}
			
		} else {
			System.out.println("TV가 OFF되어 있습니다.");
		}
		
	}
	
	public void volumDown() {
		if (powerOn)  {
			if(volume > 0) {
				volume--; // 현재 음량을 1 감소.
				System.out.println("음량 : " + volume);
			} else {
				System.out.println("현재 음량이 0입니다.");
			}
			
		} else {
			System.out.println("TV가 OFF되어 있습니다.");
		}
		
	}
	
}
