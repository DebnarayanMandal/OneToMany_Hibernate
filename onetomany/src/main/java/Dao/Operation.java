package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.Mobile;
import Dto.Sims;

public class Operation {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Debnarayan");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void insert(List<Sims>sims) {
		entityTransaction.begin();
		for(Sims s2:sims) {
			entityManager.persist(s2);
		}
		entityTransaction.commit();
		
	}
	public void update(List<Sims>sims) {
		entityTransaction.begin();
		for(Sims s3:sims) {
			entityManager.merge(s3);
		}
		entityTransaction.commit();
	}
	public void getAll() {
		Query query = entityManager.createQuery("select s from Mobile s");
		List<Mobile> mobile = query.getResultList();
		for(Mobile mobile2 : mobile ) {
			System.out.println("id "+mobile2.getId());
			System.out.println("model name "+mobile2.getModelname());
		
			
			List<Sims> sim = mobile2.getSims();
			
			for(Sims sims:sim) {
				System.out.println("id "+sims.getId());
				System.out.println("provider "+sims.getProvider());
			}
		}
	}
	public void getById() {
Mobile m1 = entityManager.find(Mobile.class, 2);
		
		if(m1!=null) {
			System.out.println("------------------------------------------");
			System.out.println("id "+m1.getId());
			System.out.println("name "+m1.getModelname());
			System.out.println("--------------------------------------------");
			List<Sims>sims = m1.getSims();
			
			for(Sims sims2:sims) {
				System.out.println("------------------------------");
				System.out.println("id "+sims2.getId());
				System.out.println("peovider"+sims2.getProvider());
				System.out.println("-------------------------------------------");
			}
			
		}
		else {
			System.out.println("there don't have any data");
			
		}
		
	}
	public void deleteById() {
      Mobile m1 = entityManager.find(Mobile.class, 2);
		
		if(m1!=null) {
			entityTransaction.begin();
			entityManager.remove(m1);
			entityTransaction.commit();
			
		}
		else {
			System.out.println("data not found");
		}
	}
	public void deleteAll() {
       Query query = entityManager.createQuery("delete from Mobile");
		 
		 entityTransaction.begin();
		  query.executeUpdate();
		 entityTransaction.commit();
	}
	

}
