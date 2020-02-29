package br.com.cleber.restwithspringboot.converter;


import br.com.cleber.restwithspringboot.data.model.Person;
import br.com.cleber.restwithspringboot.data.vo.PersonVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DozerConverterTest {

    MockPerson inputObject;

    @Before
    public void before() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        Person person = inputObject.mockPerson();
        PersonVO vo = DozerConverter.parseObject(person, PersonVO.class);
        Assert.assertEquals(person.getId(), vo.getId());
        Assert.assertEquals(person.getAddress(), vo.getAddress());
        Assert.assertEquals(person.getFirstName(), vo.getFirstName());
        Assert.assertEquals(person.getGender(), vo.getGender());
        Assert.assertEquals(person.getLastName(), vo.getLastName());
    }

    @Test
    public void VOToEntityTest() {
        PersonVO vo = inputObject.mockPersonVO();
        Person person = DozerConverter.parseObject(vo, Person.class);
        Assert.assertEquals(person.getId(), vo.getId());
        Assert.assertEquals(person.getAddress(), vo.getAddress());
        Assert.assertEquals(person.getFirstName(), vo.getFirstName());
        Assert.assertEquals(person.getGender(), vo.getGender());
        Assert.assertEquals(person.getLastName(), vo.getLastName());
    }

    @Test
    public void parseListEntityToListVOTest() {
        List<Person> persons = inputObject.mockListPerson(20);
        List<PersonVO> vos = DozerConverter.parseListObjects(persons, PersonVO.class);
        for (int i = 0; i < vos.size(); i++) {
            Assert.assertEquals(persons.get(i).getId(), vos.get(i).getId());
            Assert.assertEquals(persons.get(i).getAddress(), vos.get(i).getAddress());
            Assert.assertEquals(persons.get(i).getFirstName(), vos.get(i).getFirstName());
            Assert.assertEquals(persons.get(i).getGender(), vos.get(i).getGender());
            Assert.assertEquals(persons.get(i).getLastName(), vos.get(i).getLastName());
        }
    }

    @Test
    public void ListVOToListEntityTest() {
        List<PersonVO> vos = inputObject.mockListPersonVO(20);
        List<Person> persons = DozerConverter.parseListObjects(vos, Person.class);
        for (int i = 0; i < persons.size(); i++) {
            Assert.assertEquals(persons.get(i).getId(), vos.get(i).getId());
            Assert.assertEquals(persons.get(i).getAddress(), vos.get(i).getAddress());
            Assert.assertEquals(persons.get(i).getFirstName(), vos.get(i).getFirstName());
            Assert.assertEquals(persons.get(i).getGender(), vos.get(i).getGender());
            Assert.assertEquals(persons.get(i).getLastName(), vos.get(i).getLastName());
        }
    }

}
