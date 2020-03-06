package br.com.cleber.restwithspringboot;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.com.cleber.restwithspringboot.data.vo.PersonVO;
import br.com.cleber.restwithspringboot.exception.IncorrectParamsException;
import br.com.cleber.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO personVO) {
        if (personVO.getId() != null) {
            throw new IncorrectParamsException("Incorrect params {ID} sent.");
        }
        PersonVO vo = personService.create(personVO);
        vo.add(linkTo(methodOn(PersonController.class).create(vo)).withSelfRel().withType("POST"));
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withRel("get_person").withType("GET"));
        vo.add(linkTo(methodOn(PersonController.class).update(vo)).withRel("edit_person").withType("PUT"));
        vo.add(linkTo(methodOn(PersonController.class).delete(vo.getId())).withRel("delete_person").withType("DELETE"));
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    @PutMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> update(@RequestBody PersonVO personVO) {
        PersonVO vo = personService.update(personVO);
        vo.add(linkTo(methodOn(PersonController.class).update(vo)).withSelfRel().withType("PUT"));
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withRel("get_person").withType("GET"));
        vo.add(linkTo(methodOn(PersonController.class).delete(vo.getId())).withRel("delete_person").withType("DELETE"));
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> findById(@PathVariable("id") Long id) {
        PersonVO personVO = personService.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getId())).withSelfRel().withType("GET"));
        personVO.add(linkTo(methodOn(PersonController.class).delete(personVO.getId())).withRel("delete_person").withType("DELETE"));
        return new ResponseEntity<>(personVO, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll", produces = {"application/json", "application/xml"})
    public ResponseEntity<List<PersonVO>> findAll() {
        List<PersonVO> personVOS = personService.findAll();
        personVOS
                .stream()
                .forEach(personVO -> {
                    personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getId())).withSelfRel().withType("GET"));
                    personVO.add(linkTo(methodOn(PersonController.class).delete(personVO.getId())).withRel("delete_person").withType("DELETE"));
                });
        return new ResponseEntity<>(personVOS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
