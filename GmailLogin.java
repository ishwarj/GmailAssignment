package com.te.mock.java;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.mock.bean.Account;
import com.te.mock.bean.Inbox;

public class GmailLogin {

	Scanner scanner= new Scanner(System.in);
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction  = null;
    int id;
	public void login() {
		System.out.println("Enter User_id ");
	    id = scanner.nextInt();
		System.out.println("Enter Password ");
		String password = scanner.next();
		scanner.nextLine();
		try {
			factory = Persistence.createEntityManagerFactory("gmailData");
			manager = factory.createEntityManager();

			String queryread ="from Account where uid = :uid";
			Query query = manager.createQuery(queryread);
			query.setParameter("uid",id);
			Account mo =   (Account) query.getSingleResult();
			if ((mo.getUser_id() == id) || (mo.getPassword() == password)) {
				
					System.out.println("Press Inbox : 1 : press Compose : 2 ");
					int no = scanner.nextInt();
					if (no == 1) {
						inbox();
					}
					else if (no == 2) {
						compose();
					}
				
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void inbox() {
		System.out.println("Welcome to Inbox :");
		try {
			factory = Persistence.createEntityManagerFactory("gmailData");
			manager = factory.createEntityManager();

			String queryread ="select mess from Inbox where uid = :uid";
			Query query = manager.createQuery(queryread);
			query.setParameter("uid",id);
			List mo =   query.getResultList();
			System.out.println("Messages are :");
			
			for (int i = 0; i < mo.size(); i++) {
				System.out.println((i+1) + ". "+mo.get(i));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void compose() {

		System.out.println("Welcome to Compose");
		System.out.println("Enter Message id  ");
		int mid = scanner.nextInt();
		System.out.println("Enter Email  ");
		String email = scanner.next();
		scanner.nextLine();
		System.out.println("Enter message  ");
		String mess = scanner.nextLine();
		factory = Persistence.createEntityManagerFactory("gmailData");
		manager = factory.createEntityManager();

		String queryread ="from Account where mail = :mail";
		Query query = manager.createQuery(queryread);
		query.setParameter("mail",email);
		Account mo =  (Account) query.getSingleResult();
		
		Inbox inbox = new Inbox();
		inbox.setUser_id(id);
		inbox.setMessage(mess);
		inbox.setUser_id(mid);
		
		try {
			factory = Persistence.createEntityManagerFactory("gmailData");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(inbox);
			System.out.println("Message Sent Sucessfully..");
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
