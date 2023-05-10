package edu.java.inner03;

public class Button {
	// public static 내부 인터페이스
	// 내부 인터페이스는 반드시 static이여야하고 선언할때 static은 생략가능하다. 
	public interface OnClickListener {
		void onClick(); // 인터페이스 특징 때문에 public abstract 생략되어 있는 것.
	}
	
	// field
	private String btnName;
	private OnClickListener listener;
	
	
	// constructor
	public Button (String btnName) {
		this.btnName = btnName;
	}
	
	// method
	public void setOnClickListener(OnClickListener l) {
		this.listener = l;
	}
	
	public void click() {
		System.out.println(btnName + " 버튼");
		listener.onClick();
	}
	
	
	
	
}
