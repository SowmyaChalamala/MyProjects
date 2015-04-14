package com.sowmi.project.library.service;

import java.sql.SQLException;
import java.util.List;

import com.gcit.training.library.dao.AuthorDAO;
import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Publisher;
import com.mysql.jdbc.Connection;


public class AdministratorService extends BaseService {
	
	public void createInventory(Object obj) throws Exception {
		if(obj instanceof Author) {
			createAuthor((Author) obj);
		} else if(obj instanceof Publisher) {
			createPublisher((Publisher) obj);
		}
		
	}

	private void createPublisher(Publisher obj) {
		// TODO Auto-generated method stub
		
	}

	private void createAuthor(Author obj) throws Exception {
		if(obj != null) {
			if(obj.getAuthorName() == null || obj.getAuthorName().length() > 45) {
				throw new Exception("Author Name cannot be blank and more than 45 characters!");
			}
			
			Connection conn = getConnection();
			AuthorDAO authorDAO = new AuthorDAO(conn); 
			try {
				authorDAO.create(obj);
				conn.commit();
			} catch(SQLException e) {
				conn.rollback();
			} finally {
				conn.close();
				conn = null;
			}
			
		} else {
			throw new Exception("Author cannot be null or empty!");
		}
		
	}

	public List<Author> getAllAuthors() throws Exception {
		Connection conn = getConnection();
		try {
			AuthorDAO aDAO = new AuthorDAO(conn);
			return aDAO.getAll();
		} finally {
			conn.close();
			conn = null;
		}
	}


	public void createInventory(Object obj){
		
			}
}