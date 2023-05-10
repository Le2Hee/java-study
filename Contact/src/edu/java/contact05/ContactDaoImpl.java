package edu.java.contact05;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.java.contact.fileutil.FileUtil;
import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐에서 컨트롤러 구현 클래스.
// singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// singleton step 1
	private static ContactDaoImpl instance = null;
	
	// singleton step 2
	private ContactDaoImpl() {
		dataDir = FileUtil.initDataDir(); // 데이터 폴더 초기화
		dataFile = new File(FileUtil.DATA_DIR, FileUtil.DATA_FILE);
		contacts = FileUtil.initData(); // 데이터 초기화 -> 파일의 내용을 메모리에 로딩.
	}
	
	// singleton step 3
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// fields
	private List<Contact> contacts; // 연락처 데이터
	private File dataDir; // 연락처 데이터 파일을 저장할 폴더.
	private File dataFile; // 연락처 데이터 파일.
	
	
	
	// method
	
	// CRUD(Create, Read, Update, Delete) 기능 메서드들 : 
	@Override
	public int create(Contact c) { 
		contacts.add(c); // (heep) 메모리의 List에 연락처를 추가.
		FileUtil.writeDataToFile(contacts, dataFile);
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
			FileUtil.writeDataToFile(contacts, dataFile);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int delete(int index) {
		if(index < contacts.size()) {
			contacts.remove(index);
			FileUtil.writeDataToFile(contacts, dataFile);
			return 1;
		}
		return 0;
	}
	
}
