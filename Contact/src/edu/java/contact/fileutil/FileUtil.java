package edu.java.contact.fileutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;

// 도우미 클래스 - 파일 관련(read, write, 폴더 생성) 기능을 제공하기 위한 클래스.
// 모든 필드, 모든 메서드는 static으로 선언, 객체 생성은 하지 못하도록.
public class FileUtil {
	// 상수 정의
	public static final String DATA_DIR = "data"; // -> 데이터 폴더 이름.
	public static final String DATA_FILE = "contacts.dat"; // -> 데이터 파일 이름.
	// -> .\data\contacts.dat 파일에 연락처 리스트 객체를 저장하기 위해서.
	
	
	// private 생성자 - 다른 클래스에서는 생성자가 보이지 않기 때문에 객체를 생성할 수 없음.
	private FileUtil() {}
	
	/**
	 * 연락처 데이터 파일을 저장하는 폴더가 존재하지 않으면 생성하고, File 객체를 리턴.
	 * 만약에 이미 폴더가 생성되어 있는 경우에는, 그 폴더에 File 객체를 리턴.
	 * 
	 * @return 데이터 파일을 저장할 폴더의 File 객체.
	 */
	public static File initDataDir() {
		File newFolder = new File(DATA_DIR);
		if(newFolder.exists()) {
			
		} else {
			newFolder.mkdir();
		}
		return newFolder;
	}
	// 데이터 파일이 0byte 일때는 오류가 나기때문에 직접 지워준다음 만들어야 오류가 안난다.
	
	/**
	 * readDataFromFile.
	 * argument로 전달된 File객체를 사용해서, 파일에 저장된 연락처 정보를 읽고,
	 * 그 결과를 List<Contact> 타입의 객체로 리턴.
	 * 
	 * @param file 연락처 정보가 저장된 파일 경로를 가지고 있는 File 타입 객체.
	 * @return Contact 타입을 원소로 갖는 리스트(List).
	 */
	public static List<Contact> readDataFromFile (File file){
		FileInputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		List<Contact> files = null;
		try {
			in = new FileInputStream(file);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			files = (List<Contact>) oin.readObject();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return files;
	}
	
	
	
	/**
	 * writeDataToFile.
	 * argument로 전달된 data를(직렬화해서) file에 씀 
	 * 
	 * @param data 파일에 쓸 데이터. Contact 타입을 저장하는 리스트(List<contact>).
	 * @param file 데이터 파일 객체 
	 */
	public static void writeDataToFile (List<Contact> data, File file) {
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream(file);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			oout.writeObject(data);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * initData.
	 * 연락처 데이터 파일이 있으면, 파일의 내용을 읽어서 리스트를 생성하고 리턴.
	 * 연락처 데이터 파일이 없는 경우, 빈 리스트를 리턴.
	 * 
	 * @return Contact 타입을 원소로 갖는 리스트(List<Contact>).
	 */
	public static List<Contact> initData() {
		File file = new File(DATA_DIR, DATA_FILE);
		List<Contact> contactList = new ArrayList<>();
		if(file.exists()) {
			contactList = readDataFromFile(file);
		} else {
			
		}
		return contactList;
	}
	
}
