/*
*
*Copyright (c) 2020, pcschool 
*/

package tw.com.pcschool.utils;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tw.com.pcschool.beans.Customer;
import tw.com.pcschool.beans.Order;

/**
*
*@author Lee
* 課程大綱:
*join
*單向多對一
*單向一對多
*雙向多對一
*雙向一對一
*雙向多對多

*/
public class JUnitMain {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	@Before
	public void before() {
		// 1.創建一個管理工廠類
		String persistenceUnitName = "JPADay01";
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		// 2.創建一個管理類
		entityManager = entityManagerFactory.createEntityManager();
		// 3.開啟事務
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}
	
	@Test
	public void getCustomer() {
		// 4.建議beans結構
		Customer customer = new Customer();
		customer.setAge(13);
		customer.setEmail("kasper@gmail.com");
		customer.setLastName("Lee");
		customer.setCreateDate(new Date());
		customer.setBirth(new Date());
		

		entityManager.persist(customer);	
	}
	
	/*
	 * 移除
	 */
	
	public void testManyToOneRemove() {
		//Order order = entityManager.find(Order.class, 2);
		//entityManager.remove(order);
		
		Customer customer = entityManager.find(Customer.class, 1);
		entityManager.remove(customer);
	}
	
	/*
	 *搜尋 
	 */
	
	@Test
	public void testManyToOneFind() {
		Order order = entityManager.find(Order.class, 2);
		System.out.println(order.getCustomer().getEmail());
		System.out.println(order.getOrderName());
	}
	
	
	
	//先保存一的一端再保存多的一端
	//新增
	@Test
	public void getManyToOne() {
		// 4.建議beans結構
		Customer customer = new Customer();
		customer.setAge(13);
		customer.setEmail("kasper@gmail.com");
		customer.setLastName("Lee");
		customer.setCreateDate(new Date());
		customer.setBirth(new Date());
		
		Order o1= new Order();
		o1.setOrderName("orderName1");
		Order o2=new Order();
		o2.setOrderName("orderName2");
		
		//關聯
		o1.setCustomer(customer);
		o2.setCustomer(customer);

		entityManager.persist(customer);	
		entityManager.persist(o1);
		entityManager.persist(o2);
			
	}
	
	@After
	public void after() {
		// 5.提交事務
		entityTransaction.commit();
		// 6.關閉管理類
		entityManager.close();
		// 7.關閉管理工廠類
		entityManagerFactory.close();
		
	}
}
