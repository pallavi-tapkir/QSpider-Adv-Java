package fullyAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ItemMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Person person=applicationContext.getBean("person", Person.class);
		person.itemUsed();

	}

}
