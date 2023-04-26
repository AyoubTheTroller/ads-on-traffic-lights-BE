package troller.tests.adsNearTrafficLights.component;

import troller.tests.adsNearTrafficLights.model.TrafficLightEvent;
import troller.tests.adsNearTrafficLights.service.producer.TrafficLightEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class TrafficEventGenerator {

    @Autowired
    private TrafficLightEventProducer trafficLightEventProducer;

    @Scheduled(fixedRate = 5000)
    public void generateAndSendTrafficLightEvents() {
        String[] states = {"RED", "GREEN"};
        String randomState = states[new Random().nextInt(states.length)];

        TrafficLightEvent event = new TrafficLightEvent();
        event.setState(randomState);
        event.setTimeStamp(LocalDateTime.now());

        trafficLightEventProducer.sendTrafficLightEvent(event);
    }
}

