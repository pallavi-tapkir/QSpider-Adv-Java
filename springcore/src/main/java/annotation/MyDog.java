package annotation;

import org.springframework.stereotype.Component;

@Component
public class MyDog implements Animal {
	@Override
	public void sound() {
		System.out.println("Bhoo Bhoo");
		
	}
}
