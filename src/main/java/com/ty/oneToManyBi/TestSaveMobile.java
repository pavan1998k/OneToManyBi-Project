package com.ty.oneToManyBi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobile {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Mobile mobile=new Mobile();
		mobile.setName("Apple iPhone");
		mobile.setCost(49999);
		
		Sim sim1=new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("3G");
		
		Sim sim2=new Sim();
		sim2.setProvider("Jio");
		sim2.setType("4G");
		
		Sim sim3=new Sim();
		sim3.setProvider("BSNL");
		sim3.setType("4G");
		
		List<Sim> sims =new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		sims.add(sim3);
		
		sim1.setMobile(mobile);
		sim2.setMobile(mobile);
		sim3.setMobile(mobile);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityTransaction.commit();
	}
	
}
