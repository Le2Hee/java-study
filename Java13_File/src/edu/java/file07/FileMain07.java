package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain07 {

	public static void main(String[] args) {
		// 1. ArratList<Student> 객체 생성.
		// 2. 1,000,000개의 Student 객체를 리스트에 저장. - 시험 전수 -> Random으로
		// 3. 리스트를 students.dat 파일에 쓰기. -> 직렬화 사용해서.
		// 4. 파일에서 데이터를 읽어서 역직열화. -> 읽은 데이터 확인.
		Random ran = new Random();
		
		int max = 100;
		int min = 1;
		
		int java = ran.nextInt(min, max);
		int web = ran.nextInt(min, max);
		int python = ran.nextInt(min, max);
		
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			Score score = new Score(java, web, python);
			students.add(new Student(i, "NAME_" + i, score));
		}
		
		String file = "data/students.dat";
		
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream(file);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			long start = System.currentTimeMillis();
			
			oout.writeObject(students);
			
			long end = System.currentTimeMillis();
			
			System.out.println(students.get(9999));
			
			System.out.println("write 경과 시간 : " + (end - start) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		FileInputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream(file);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			long start = System.currentTimeMillis();
			
			ArrayList<Student> result = (ArrayList<Student>) oin.readObject();
			
			long end = System.currentTimeMillis();
			
			System.out.println(result.get(9999));
			
			System.out.println("read 경과 시간 : " + (end - start) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
