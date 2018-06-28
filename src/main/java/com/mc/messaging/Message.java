package com.mc.messaging;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String messageBody;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "message")
    private List<Love> loves;

    public List<Love> getLoves() {
        return loves;
    }
    Message(){
        loves = new ArrayList<Love>();
    }
    public void setLoves(List<Love> loves) {
        this.loves = loves;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addLoves(Love love) {
        loves.add(love);
    }
}
