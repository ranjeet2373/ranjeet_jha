package com.ustglobal.lms.service;

import com.ustglobal.lms.dto.AdminBean;
import com.ustglobal.lms.dto.BookBean;
import com.ustglobal.lms.dto.StudentBean;

public interface LibraryService {
	
	public boolean registreLibrarian(AdminBean bean);
	public AdminBean loginLibrarian(AdminBean bean);
	public boolean updateLibrarian(AdminBean bean);
	public boolean deleteLibrarian(int id);
	public boolean registerStudent(StudentBean bean);
	public StudentBean loginStudent(StudentBean bean);
	public boolean addBook(BookBean bean);
	public BookBean searchBook(int bid);

}
