package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc_employee.dto.Employee;

@Repository
public class Employeedao {
	@Autowired
	private EntityManager entityManager;
	
	public Employee save(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public Employee update(Employee employee) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public boolean delete(int id) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee employee=(Employee) entityManager.find(Employee.class, id);
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public Employee getEmployeeById(int id) {
		return (Employee) entityManager.find(Employee.class, id);
	}
	
	public List<Employee> getAllEmployees(){
		Query query = entityManager.createQuery("select e1 from Employee e1");
		return query.getResultList();
	}
}
