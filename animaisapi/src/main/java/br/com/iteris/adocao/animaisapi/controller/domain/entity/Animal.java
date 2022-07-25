package br.com.iteris.adocao.animaisapi.controller.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor // irá gerar um construtor sem parâmetros
@AllArgsConstructor // gera um construtor com 1 parâmetro para cada campo em sua classe
public class Animal {
    private int idAnimal;
    private String nome;
    private int idade;
    private String especie;
    private LocalDate dataNascimento;
    private Integer nivelFofura;
    private Integer nivelCarinho;
    private String email;
}
