package com.hibernatews.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernatews.entities.Friends;
import com.hibernatews.util.HibernateUtil;

public class DAO {
	
	// get all Friends 
	@SuppressWarnings("unchecked")
	public List<Friends> getAllFriends() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Friends> allFriends = new ArrayList<>();
		try {
			session.getTransaction().begin();
			allFriends = session.createQuery("from Friends").list();
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return allFriends;
	}
	
	// add friend
	public void addFriend(Friends friend) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(friend);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	//update a friend
	public void updateFriend(Friends friend) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.update(friend);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	//get a single friend
	public Friends getSingleFriend(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Friends singleFriend = null;
		try {
			session.getTransaction().begin();
			singleFriend = (Friends) session.get(Friends.class, id);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return singleFriend;
	}
	
	//delete a friend
	public void deleteFriend(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			Friends fr = new Friends();
			fr.setId(id);
			session.delete(fr);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
}
