package student_management_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student_management_system.dto.Student;

public class StudentDAO {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		return entityManagerFactory.createEntityManager();
	}
	
	public Student save(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	
	public Student loginStudent(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student student=(Student) query.getSingleResult();
		return student;
	}
	
	public Student update(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	
	public boolean delete(int id) {
		EntityManager entityManager = getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student !=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public Student getStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Student.class, id);
	}
	
	public List<Student> getAllStudents(){
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Student p");
		return query.getResultList();
	}
}
