package br.com.cleber.restwithspringboot.data.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonVO implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    // campo extra para testes com JSON
    private String teste;

}
