package springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobileMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("mobile.xml");
		Mobile mobile = (Mobile) beanFactory.getBean("mobile");
		mobile.used();
	}

}
