package fullyAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Pen implements Item {

	@Override
	public void used() {
		System.out.println("Pen is used to write");

	}

}
