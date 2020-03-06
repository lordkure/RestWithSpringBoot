package br.com.cleber.restwithspringboot;

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
        return new ResponseEntity<>(personService.create(personVO), HttpStatus.OK);
    }

    @PutMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> update(@RequestBody PersonVO personVO) {
        return new ResponseEntity<>(personService.update(personVO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findAll", produces = {"application/json", "application/xml"})
    public ResponseEntity<List<PersonVO>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
