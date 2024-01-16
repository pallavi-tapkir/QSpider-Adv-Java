package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import main.dto.Building;
import main.dto.Floor;

public class Buildingdao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public Building save(Building building) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Floor> floors = building.getFloors();
		for(Floor floor : floors) {
			entityManager.persist(floor);
		}
		entityManager.persist(building);
		entityTransaction.commit();
		return building;
	}
	
	public Building update(Building building) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(building);
		entityTransaction.commit();
		return building;
	}
	
	public boolean delete(int id) {
		EntityManager entityManager = getEntityManager();
		Building building=entityManager.find(Building.class, id);
		if(building != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(building);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public Building getById(int id) {
		EntityManager entityManager = getEntityManager();
		Building building=entityManager.find(Building.class, id);
		System.out.println(building.toString());
		return building;
	}
	
	public List<Building> getAll(){
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select b from Building b");
		System.out.println(query.getResultList());
		return query.getResultList();
	}
}
