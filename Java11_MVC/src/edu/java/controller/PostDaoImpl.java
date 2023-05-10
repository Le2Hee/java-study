package edu.java.controller;

import edu.java.model.Post;

public class PostDaoImpl implements PostDao {
	
	private static PostDaoImpl instance = null;
	
	private PostDaoImpl() {}
	
	public static PostDaoImpl getInstance() {
		if (instance == null) {
			instance = new PostDaoImpl();
		}
		return instance;
	}
	
	private static final int MAX_LENGTH = 3;
	private Post[] posts = new Post[MAX_LENGTH];
	private int count = 0;
	
	public boolean isMemoryAvailable() {
        return count < MAX_LENGTH;
    }
	
	 public boolean isValidIndex(int index) {
	        return (index >= 0) && (index < count);
	 }
	
	@Override
	public int create(Post c) {
		if 	(!isMemoryAvailable()) {
			return 0;
		}
		posts[count] = c;
		count++;
		
		
		return 1;
	}

	@Override
	public Post[] read() {
		Post[] posts = new Post[count];
		for (int i = 0; i < count; i++) {
			posts[i] = this.posts[i];
		}
		
		return posts;
	}

	@Override
	public Post read(int index) {
		if(!isValidIndex(index)) {
			return null;
		}
		
		return posts[index];
	}

	@Override
	public int update(int index, Post post) {
		if (!isValidIndex(index)) {
			return 0;
		}
		
		posts[index] = post;
		return 1;
	}

	@Override
	public int delete(int index) {
		if(!isValidIndex(index)) {
			return 0;
		}
		for(int i = index; i < count-1; i++) {
			posts[i] = posts[i+1];
		}
		posts[count-1] = null;
		count--;
		return 1;
	}
}
