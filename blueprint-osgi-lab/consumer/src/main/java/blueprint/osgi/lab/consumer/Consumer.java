package blueprint.osgi.lab.consumer;

import javax.annotation.PostConstruct;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blueprint.osgi.lab.producer.api.Producer;

@Component
public class Consumer {
	
	@Autowired
	private ConsumerFrame consumerFrame;	
	@Autowired
	private Producer producer;

	@PostConstruct
	public void start() {
		consumerFrame.setRefreshListener(new RefreshListener() {			
			@Override
			public String refresh() {
				return producer.produceString();
			}
		});
		
		SwingUtilities.invokeLater(
				new Runnable() {
					
					@Override
					public void run() {
						consumerFrame.setVisible(true);
					}
				}
				);
	}
	
}
