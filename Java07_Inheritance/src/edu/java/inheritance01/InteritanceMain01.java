package edu.java.inheritance01;

// 상속(inheritance)
  // 상위 클래스를 확장해서 하위 클래스를 설계하는 것.
  // 상속을 하게 되면?
    // 상위 클래스의 멤버(필드, 생성자, 메서드)들을 하위 클래스에서 사용할 수 있기 때문에.
  // 한번에 2개의 클래스를 물려받을 수 없다.

// 상위 클래스 : 상위(super), 부모(parent), 기본(base) 클래스 라고 부르기도 한다.
// 하위 클래스 : 하위(sub), 자식(child), 유도(derived) 클래스 라고 부르기도 한다.
  // 유행에 따라서 부르는 말이 달라지는 듯 하다.

public class InteritanceMain01 {
	
	

	public static void main(String[] args) {
		BasicTv tv1 = new BasicTv();
		tv1.printInfo();
		tv1.powerOnOff();
		tv1.printInfo();
		
		SmartTv tv2 = new SmartTv();
		tv2.powerOnOff(); // 상위 클래스의 메서드를 상속받아서 사용 가능.
		tv2.printInfo(); 
		
		tv2.setIp("110.532.32.2");
		System.out.println("IP : " + tv2.getIp());
		
	}

}
