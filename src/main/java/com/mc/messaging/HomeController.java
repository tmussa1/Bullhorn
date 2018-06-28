package com.mc.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    LoveRepository loveRepository;

    @RequestMapping("/")
    public String showHomepage(Model model){
        model.addAttribute("amessage", new Message());
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/savemessage")
    public String saveMessage(@ModelAttribute("amessage") Message message, Model model){
        model.addAttribute("messages", messageRepository.findAll());
        messageRepository.save(message);
        return "messageBoard";
    }

    @RequestMapping("/update/{id}")
    public String updateLike(@PathVariable("id") long id, Model model){
        Message message = messageRepository.findById(id).get();

        Love love = new Love();
        love.setMessage(message);
        loveRepository.save(love);

        model.addAttribute("messages", messageRepository.findAll());
        return "messageBoard";
    }
    @PostConstruct
    public void fillPersons(){
        Person person = new Person();
        person.setPersonName("John");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Darryl");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Jamie");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Belcher");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Barabara");
        personRepository.save(person);

        person = new Person();
        person.setPersonName("Mark");
        personRepository.save(person);
    }
}
