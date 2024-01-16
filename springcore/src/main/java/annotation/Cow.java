package annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  //to tell container to create object for this call
@Primary
public class Cow implements Animal {

	@Override
	public void sound() {
		System.out.println("Cow sound.");
	}

}
