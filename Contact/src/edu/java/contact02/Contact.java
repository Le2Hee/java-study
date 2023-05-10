package edu.java.contact02;

// 연락처 정보
public class Contact {
	// field
	private int cid; // 연락처 고유 번호 (0.1에서는 아직 생각안해도 됨.)
	private String name;  // 이름
	private String phone;  // 폰번호
	private String email;  // 이메일
	
	// constructor
	public Contact() {}
	
	public Contact(int cid, String name, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	// getters & setters
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		String c = String.format("Contact(cid : %d, name : %s, phone : %s, email : %s", 
				this.cid, this.name, this.phone, this.email);
		return c;
	}
	
	// method
	public void printInfo() {
		System.out.printf("Contact(cid=%d, name=%s, phone=%s, email=%s)\n",
				this.cid, this.name, this.phone, this.email);
	}
	
	
	
	
}
