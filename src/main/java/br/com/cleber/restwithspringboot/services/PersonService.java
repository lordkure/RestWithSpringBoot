package br.com.cleber.restwithspringboot.services;

import br.com.cleber.restwithspringboot.converter.DozerConverter;
import br.com.cleber.restwithspringboot.data.vo.PersonVO;
import br.com.cleber.restwithspringboot.exception.ResourceNotFoundException;
import br.com.cleber.restwithspringboot.data.model.Person;
import br.com.cleber.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO personVO) {
        var entity = DozerConverter.parseObject(personVO, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO findById(Long id) {
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO update(PersonVO personVO) {
        var entity = DozerConverter.parseObject(findById(personVO.getId()), Person.class);
        entity.setAddress(personVO.getAddress());
        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setGender(personVO.getGender());
        return DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        var entity = DozerConverter.parseObject(findById(id), Person.class);
        personRepository.delete(entity);
    }

}
