package br.com.iteris.adocao.animaisapi.controller.domain.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AnimalUpdateRequest {
    @NotEmpty(message = "Nome obrigatório!")
    @Size(max = 40)
    private String nome;

    @NotEmpty(message = "Idade obrigatória!")
    @Size(max = 40)
    private int idade;

    @NotEmpty(message = "Espécie obrigatória!")
    @Size(max = 40)
    private String especie;

    @Range(min = 1, max = 5)
    private Integer nivelFofura;

    @Range(min = 1, max = 5)
    private Integer nivelCarinho;
}
