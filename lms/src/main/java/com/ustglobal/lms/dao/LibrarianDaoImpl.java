package com.ustglobal.lms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.hibernate.query.spi.QueryParameterBindingTypeResolver;
import org.springframework.stereotype.Repository;

import com.ustglobal.lms.dto.AdminBean;
import com.ustglobal.lms.dto.BookBean;
import com.ustglobal.lms.dto.StudentBean;

@Repository
public class LibrarianDaoImpl implements LibraryDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean registreLibrarian(AdminBean bean) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(bean);
		transaction.commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
		
	}

	@Override
	public AdminBean loginLibrarian(AdminBean bean) {
		EntityManager manager = factory.createEntityManager();
		Query query = (Query) manager.createQuery("from AdminBean where id=:id and password=:password");
		query.setParameter("id", bean.getId());
		query.setParameter("password", bean.getPassword());
		AdminBean adminBean = (AdminBean) query.getSingleResult();
		return adminBean;
	}

	@Override
	public boolean updateLibrarian(AdminBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			AdminBean adminBean = manager.find(AdminBean.class,bean.getId());
			adminBean.setName(bean.getName());
			adminBean.setPassword(bean.getPassword());
			adminBean.setGender(bean.getGender());
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
			
		
	}
	@Override
	public boolean deleteLibrarian(int id) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
		transaction.begin();
		AdminBean adminBean = manager.find(AdminBean.class, id);
		if(adminBean!=null)
		manager.remove(adminBean);
		transaction.commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}

	@Override
	public boolean registerStudent(StudentBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public StudentBean loginStudent(StudentBean bean) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from StudentBean where rollno=:rollno and password=:password";
		TypedQuery<StudentBean> query = manager.createQuery(jpql,StudentBean.class);
		query.setParameter("rollno", bean.getRollno());
		query.setParameter("password", bean.getPassword());
		StudentBean studentBean = query.getSingleResult();
		return studentBean;
	}

	@Override
	public boolean addBook(BookBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		}catch (Exception e) {
		 e.printStackTrace();
		 transaction.rollback();
		 return false;
			
		}
	}//End of adding book

	@Override
	public BookBean searchBook(int bid) {
		EntityManager manager = factory.createEntityManager();
		BookBean allDetail = manager.find(BookBean.class, bid);
		return allDetail;
	}//END OF BOOK SEARCH

}
