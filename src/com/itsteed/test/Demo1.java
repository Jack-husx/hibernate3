package com.itsteed.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itsteed.domain.Customer;
import com.itsteed.domain.Linkman;
import com.itsteed.utils.HibernateUtils;

public class Demo1 {
	
	@Test
	public void run1(){
		
		Session session = HibernateUtils.getCurrentSession();
		
		Transaction  tr = session.beginTransaction();
		
		Customer c1 = new Customer();
		c1.setCust_name("美美");
		
		Linkman l1 = new Linkman();
		l1.setLkm_name("熊大");
		Linkman l2 = new Linkman();
		l2.setLkm_name("熊二");
		
		c1.getLinkmans().add(l1);
		c1.getLinkmans().add(l2);
		
		l1.setCustomer(c1);
		l2.setCustomer(c1);
		
		
		session.save(c1);
		session.save(l1);
		session.save(l2);
		
		tr.commit();
		
	}

}
