package troller.tests.adsNearTrafficLights.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

public class Subscription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="consumer_id")
    private User consumer;

    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="stopLight_id")
    private Stoplight stoplight;
    
    @ManyToOne
    @JoinColumn(name="pedestrianButton_id")
    private PedestrianButton pedestrianButton;

    @Column(name="timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;

    // setters and getters

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public User getConsumer(){
        return this.consumer;
    }

    public void setConsumer(User consumer){
        this.consumer = consumer;
    }

    public Stoplight getStoplight(){
        return this.stoplight;
    }

    public void setStoplight(Stoplight stoplight){
        this.stoplight = stoplight;
    }

    public PedestrianButton getPedestrianbutton(){
        return this.pedestrianButton;
    }

    public void setPedestrianbutton(PedestrianButton pedestrianButton){
        this.pedestrianButton = pedestrianButton;
    }

    public Topic geTopic(){
        return this.topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    } 
    
}