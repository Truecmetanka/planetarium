package ru.coursework.Planetarium.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coursework.Planetarium.entity.Person;
import ru.coursework.Planetarium.repositories.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

}
