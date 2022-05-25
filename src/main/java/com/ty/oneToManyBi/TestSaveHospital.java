package com.ty.oneToManyBi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospital {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("Baptist Hospital");
		hospital.setWebsite("www.baptisthospital.com");
		hospital.setGstNo("1134131pajhs12");
		
		Branch branch=new Branch();
		branch.setName("Hebbal");
		branch.setState("Karnataka");
		branch.setCountry("India");
		branch.setPhone(7411920739l);
		
		Branch branch1=new Branch();
		branch1.setName("Basvangudi");
		branch1.setState("Karnataka");
		branch1.setCountry("India");
		branch1.setPhone(7411920739l);
		
		branch1.setHospital(hospital);
		branch.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch);
		entityManager.persist(branch1);
		entityTransaction.commit();
	}
}
