package com.ustglobal.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustglobal.lms.dao.LibraryDAO;
import com.ustglobal.lms.dto.AdminBean;
import com.ustglobal.lms.dto.BookBean;
import com.ustglobal.lms.dto.StudentBean;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	
	@Autowired
	private LibraryDAO dao;

	@Override
	public boolean registreLibrarian(AdminBean bean) {
		if(bean.getName()==null||bean.getPassword()==null) {
		return false;
		}else if(bean.getPassword().length()<8) {
			return false;
		}
		return dao.registreLibrarian(bean);
	}

	@Override
	public AdminBean loginLibrarian(AdminBean bean) {
		return dao.loginLibrarian(bean);
	}

	@Override
	public boolean updateLibrarian(AdminBean bean) {
		
			return dao.updateLibrarian(bean);
		
	}

	@Override
	public boolean deleteLibrarian(int id) {
		// TODO Auto-generated method stub
		return dao.deleteLibrarian(id);
	}

	@Override
	public boolean registerStudent(StudentBean bean) {
		
		return dao.registerStudent(bean);
		
	}

	@Override
	public StudentBean loginStudent(StudentBean bean) {
		
		return dao.loginStudent(bean);
	}

	@Override
	public boolean addBook(BookBean bean) {
		// TODO Auto-generated method stub
		return dao.addBook(bean);
	}

	@Override
	public BookBean searchBook(int bid) {
		
		return dao.searchBook(bid);
	}

}
