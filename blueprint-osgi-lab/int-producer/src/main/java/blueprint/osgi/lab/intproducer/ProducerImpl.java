package blueprint.osgi.lab.intproducer;


import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

import blueprint.osgi.lab.producer.api.Producer;

@Component
public class ProducerImpl implements Producer {
	
	private Random random = new Random(new Date().getTime());
	
	@Override
	public String produceString() {
		return String.valueOf(random.nextInt());
	}

}
