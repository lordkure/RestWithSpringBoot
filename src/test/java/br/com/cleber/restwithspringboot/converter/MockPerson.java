package br.com.cleber.restwithspringboot.converter;

import br.com.cleber.restwithspringboot.data.model.Person;
import br.com.cleber.restwithspringboot.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public PersonVO mockPersonVO() {
        PersonVO pvo = new PersonVO();
        pvo.setAddress("Address");
        pvo.setFirstName("First Name");
        pvo.setLastName("Last Name");
        pvo.setGender("Gender");
        pvo.setId(1L);
        return pvo;
    }

    public List<PersonVO> mockListPersonVO(int quantity) {
        List<PersonVO> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            PersonVO pvo = new PersonVO();
            pvo.setAddress("Address " + i);
            pvo.setFirstName("First Name " + i);
            pvo.setLastName("Last Name " + i);
            pvo.setGender((i % 2 == 0) ? "Male" : "Female");
            pvo.setId(1L);
            list.add(pvo);
        }
        return list;
    }

    public Person mockPerson() {
        Person p = new Person();
        p.setAddress("Address");
        p.setFirstName("First Name");
        p.setLastName("Last Name");
        p.setGender("Gender");
        p.setId(1L);
        return p;
    }

    public List<Person> mockListPerson(int quantity) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Person p = new Person();
            p.setAddress("Address " + i);
            p.setFirstName("First Name " + i);
            p.setLastName("Last Name " + i);
            p.setGender((i % 2 == 0) ? "Male" : "Female");
            p.setId(1L);
            list.add(p);
        }
        return list;
    }

}
