package br.com.iteris.adocao.animaisapi.controller.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    private int idAnimal;
    private String nome;
    private Integer idade;
    private String especie;
    private LocalDate dataNascimento;
    private Integer nivelFofura;
    private Integer nivelCarinho;
    private String email;
}
