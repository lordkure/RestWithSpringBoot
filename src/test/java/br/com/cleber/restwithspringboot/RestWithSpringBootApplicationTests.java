package br.com.cleber.restwithspringboot;

import br.com.cleber.restwithspringboot.data.vo.PersonVO;
import com.github.dozermapper.core.inject.Inject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RestWithSpringBootApplicationTests {

    @Autowired
    private PersonController controller;

    @Test
    void teste() {
        PersonVO vo = new PersonVO();
        vo.setGender("Male");
        vo.setFirstName("First");
        vo.setLastName("Last");
        vo.setAddress("Address");
        PersonVO response = controller.create(vo).getBody();
        Assert.assertEquals(response, controller.findById(response.getId()).getBody());
        controller.delete(response.getId());
    }

}
