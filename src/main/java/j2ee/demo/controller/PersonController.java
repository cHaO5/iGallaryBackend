package j2ee.demo.controller;

import j2ee.demo.model.Person;
import j2ee.demo.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path = "addPerson")
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @DeleteMapping(path = "deletePerson")
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
//        personRepository.delete(id);
    }

    @GetMapping
    public List<Person> listPerson() {
        return personRepository.findAll();
    }
}