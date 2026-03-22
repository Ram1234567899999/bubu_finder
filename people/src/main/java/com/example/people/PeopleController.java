package com.example.people;

import com.example.people.model.Person;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;



import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")

@RestController
public class PeopleController {

    private List<Person> people = new ArrayList<>();

    @PostMapping("/people")
    public Person addPerson(@RequestBody Person person) {
        people.add(person);
        return person;
    }

    @GetMapping("/people/all")
    public List<Person> getAllPeople() {
        return people;
    }


    @GetMapping("/people")
    public List<Person> getPeopleByZip(@RequestParam String zip) {
        return people.stream()
                .filter(p -> zip.equals(p.getZip()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/people/{phone}")
    public String deleteByPhone(@PathVariable String phone) {
        boolean removed = people.removeIf(p -> phone.equals(p.getPhone()));
        return removed ? "Deleted" : "Not Found";
    }

    @PutMapping("/people/zip/{zip}")
    public List<Person> updateByZip(@PathVariable String zip,
                                    @RequestBody Person updated) {

        List<Person> updatedPeople = new ArrayList<>();

        for (Person p : people) {
            if (zip.equals(p.getZip())) {

                if (updated.getName() != null && !updated.getName().isBlank()) {
                    p.setName(updated.getName());
                }

                updatedPeople.add(p);
            }
        }
        return updatedPeople;
    }




}
