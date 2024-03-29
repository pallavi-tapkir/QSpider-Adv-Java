package hibernate_task1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeCRUD {

	public void saveEmployee(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}
	
	public void update(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee2 = entityManager.find(Employee.class, employee.getId());
		
		employee2.setName(employee.getName());
		employee2.setSalary(employee.getSalary());
		
		entityTransaction.begin();
		entityManager.merge(employee2);
		entityTransaction.commit();
	}
	
	public void delete(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Employee employee = entityManager.find(Employee.class, id);
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		
	}
	
	public void getEmployeeById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		System.out.println(employee);
	}
	
	public void getAllEmployees() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pallavi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select e from Employee e");
		System.out.println(query.getResultList());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
