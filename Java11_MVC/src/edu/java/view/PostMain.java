package edu.java.view;

import java.time.LocalDateTime;
import java.util.Scanner;
import edu.java.controller.PostDaoImpl;
import edu.java.menu.Menu;
import edu.java.model.Post;

public class PostMain {
	
	private Scanner sc = new Scanner(System.in);
	private PostDaoImpl dao = PostDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("================== 메 모 장 =================");
		
		PostMain pm = new PostMain();
		
		boolean run = true;
		while (run) {
			int n = pm.showMainMenu();
			Menu menu = Menu.getValue(n);
			switch (menu) {
			case QUIT :
				run = false;
				break;
			case CREATE :
				pm.newPost();
				break;
			case READ_ALL :
				pm.selectAllPost();
				break;
			case READ_BY_INDEX :
				pm.selectAllPostByIndex();
				break;
			case UPDATE :
				pm.updatePost();
				break;
			case DELETE :
				pm.deletePost();
				break;
			default :
				System.out.println("메인 메뉴 번호를 다시 확인해 주세요.");
			}
		}
		
		System.out.println("============== 메모장 종료 ==============");
	}
	
	private int inutNumber() {
		while (true) {
			try {
				int n = 	Integer.parseInt(sc.nextLine());
				return n;
			} catch (NumberFormatException e) {
				System.out.print("정수를 다시 입력해주세요 >>> ");
			}
		}
	}

	private int showMainMenu() {
		System.out.println("\n================================");
		System.out.println("[0] 종료 [1] 새메모장등록 [2] 전체메뉴 [3] 검색 [4] 수정 [5] 삭제");
		System.out.println("=================================");
		System.out.println();
		System.out.print("Main Menu를 선택해 주세요. >>> ");
		int n = inutNumber();
		
		return n;
	}
	
	private void newPost() {
		System.out.println("\n============= 새메모 작성 =============");
		
		if (!dao.isMemoryAvailable()) {
			System.out.println("메모리에 저장 공간이 부족합니다.");
			return;
		}
		
		System.out.print("제목을 입력하세요. >>> ");
		String title = sc.nextLine();
		System.out.print("내용을 입력하세요. >>> ");
		String content = sc.nextLine();
		System.out.print("작성자를 입력하세요. >>> ");
		String author = sc.nextLine();
		
		Post post = new Post(0, title, content, author, LocalDateTime.now(), null);
		
		int result = dao.create(post);
		if (result == 1) {
			System.out.println("새메모를 저장했습니다.");
		} else {
			System.out.println("새메모를 저장하지 못했습니다.");
		}
		
	}
	
	private void selectAllPost() {
		System.out.println("\n====================== 메모장 목록 보기 ======================");
		
		Post[] posts = dao.read();
		int count = 0;
		for (Post x : posts) {
			System.out.println(x);
			count++;
		}
		
		System.out.println("==================== 메모장 총 개수는 " + count + "입니다. ====================");
	}
	
	private void selectAllPostByIndex() {
		System.out.println("\n========= 메모장 검색 =========");
		System.out.print("검색할 메모장 인덱스를 입력해주세요. >>> ");
		int index = inutNumber();
		
		Post[] posts =dao.read();
		System.out.println(posts[index]);
	}
	
	private void updatePost() {
		System.out.println("\n========== 메모장 수정 ==========");
		System.out.print("수정할 메모장 인덱스를 선택하세요. >>> ");
		int index = inutNumber();
		
		if (!dao.isValidIndex(index)) {
			System.out.println("없는 메모장 인덱스 번호입니다.");
			return;
		}
		
		Post posts = dao.read(index);
		System.out.println("수정할 메모장 정보 = " + posts);
		
		System.out.print("제목을 입력하세요. >>> ");
		String title = sc.nextLine();
		System.out.print("내용을 입력하세요. >>> ");
		String content = sc.nextLine();
		System.out.print("작성자를 입력하세요. >>> ");
		String author = sc.nextLine();
		LocalDateTime createdTime = posts.getCreatedTime();
		
		posts = new Post(0, title, content, author, createdTime, LocalDateTime.now());
		int result = dao.update(index, posts);
		if (result == 0) {
			System.out.println("메모장 수정을 실패했습니다.");
		} else {
			System.out.println("메모장 수정을 성공했습니다.");
		}
		
	}
	
	private void deletePost() {
		System.out.println("\n========== 메모장 삭제 ==========");
		System.out.print("삭제할 메모장 인덱스를 선택하세요. >>> ");
		int index = inutNumber();
		
		if (!dao.isValidIndex(index)) {
			System.out.println("없는 메모장 인덱스 번호입니다.");
			return;
		}
		
		int result = dao.delete(index);
		if (result == 1) {
			System.out.println("메모장을 삭제했습니다.");
		} else {
			System.out.println("메모장 삭제를 실패했습니다.");
		}
		
		
		
		
	}
}
