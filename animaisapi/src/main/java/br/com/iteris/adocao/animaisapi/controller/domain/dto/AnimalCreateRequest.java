package br.com.iteris.adocao.animaisapi.controller.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AnimalCreateRequest {

    @NotEmpty(message = "Nome obrigatório!")
    private String nome;

    @NotNull(message = "Idade obrigatória!")
    private int idade;

    @NotEmpty(message = "Espécie obrigatória!")
    private String especie;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "A data deve ser igual ou anterior a data de hoje")
    private LocalDate dataNascimento;

    @Range(min = 1, max = 5)
    private Integer nivelFofura;

    @Range(min = 1, max = 5)
    private Integer nivelCarinho;

    private String email;
}
