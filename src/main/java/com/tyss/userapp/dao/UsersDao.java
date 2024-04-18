package com.tyss.userapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;

import com.tyss.instagram.entity.Users;

public class UsersDao {
	EntityManager manager = Persistence.createEntityManagerFactory("hemanth").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public Users saveUsers(Users Users) {
		if (Users == null)
			return null;
		transaction.begin();
		manager.persist(Users);
		transaction.commit();
		return Users;
	}

	public void deleteAllUsers() {
		List<Users> users = manager.createQuery("from Users").getResultList();
		transaction.begin();
		for (Users u : users)
			manager.remove(u);
		transaction.commit();
	}

	public Users findUserById(int id) {
		return manager.find(Users.class, id);
	}

	public Users updateUser(Users u) {
		transaction.begin();
		manager.merge(u);
		transaction.commit();
		return u;
	}

	public List<Users> findAllUsers() {
		return manager.createQuery("from Users").getResultList();
	}
   
}
