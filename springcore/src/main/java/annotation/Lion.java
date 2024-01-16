package annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 

public class Lion implements Animal {

	@Override
	public void sound() {
		System.out.println("Lion sound.");
	}

}
