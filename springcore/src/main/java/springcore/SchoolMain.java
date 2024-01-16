package springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchoolMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("school.xml");
		Gurukul school1 = (Gurukul) beanFactory.getBean("Gurukul");
		DPA school2 = (DPA) beanFactory.getBean("DPA");
		school1.name();
		System.out.println(school1.getFees());
		school2.name();
		System.out.println(school2.getFees());
	}

}
