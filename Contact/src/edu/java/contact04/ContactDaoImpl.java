package edu.java.contact04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 컨트롤러 구현 클래스.
// singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// singleton step 1
	private static ContactDaoImpl instance = null;
	
	// singleton step 2
	private ContactDaoImpl() {};
	
	// singleton step 3
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// fields
	private List<Contact> contacts = new ArrayList<>();
	
	// method
	
	// CRUD(Create, Read, Update, Delete) 기능 메서드들 : 
	@Override
	public int create(Contact c) {
		contacts.add(c);
		return 1;
	}
	
	@Override
	public List<Contact> read() {
		return contacts;
	}
	
	@Override
	public Contact read(int index) {
		if(index < contacts.size()) {
			return contacts.get(index);
		}
		return null;
	}
	
	@Override
	public int update(int index, Contact contact) {
		if(index < contacts.size()) {
			this.contacts.set(index, contact);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int delete(int index) {
		if(index < contacts.size()) {
			contacts.remove(index);
			return 1;
		}
		return 0;
	}
	
}
