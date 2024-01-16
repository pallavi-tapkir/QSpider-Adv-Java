package springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("student.xml");
		Student student1 = (Student) beanFactory.getBean("stud1");
		System.out.println(student1.toString());
	}
}
