/*
*
*Copyright (c) 2020, pcschool 
*/

package tw.com.pcschool.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

/**
*
*@author Lee
* 課程大綱:
*/
public abstract class FuMainab implements GetInfo{
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	@Before
	public void init() {
		// 1.創建一個管理工廠類
		String persistenceUnitName = "JPADay01";
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		// 2.創建一個管理類
		entityManager = entityManagerFactory.createEntityManager();
		// 3.開啟事務
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	@After
	public void destroy() {
		// 5.提交事務
		entityTransaction.commit();
		// 6.關閉管理類
		entityManager.close();
		// 7.關閉管理工廠類
		entityManagerFactory.close();
	}
	public void find() {
		getfind();
	}
	public abstract void getfind();
	public void create() {}
	public void remove() {}	
}
