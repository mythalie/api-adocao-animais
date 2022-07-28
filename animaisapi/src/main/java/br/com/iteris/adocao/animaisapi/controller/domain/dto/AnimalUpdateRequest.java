package br.com.iteris.adocao.animaisapi.controller.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimalUpdateRequest {
    @NotEmpty(message = "Nome obrigatório!")
    private String nome;

    @NotNull(message = "Idade obrigatória!")
    private Integer idade;

    @NotEmpty(message = "Espécie obrigatória!")
    private String especie;

    @Range(min = 1, max = 5)
    private Integer nivelFofura;

    @Range(min = 1, max = 5)
    private Integer nivelCarinho;

    @Email
    private String email;
}
