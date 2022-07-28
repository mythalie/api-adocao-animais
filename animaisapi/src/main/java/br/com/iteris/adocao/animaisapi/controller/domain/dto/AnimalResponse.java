package br.com.iteris.adocao.animaisapi.controller.domain.dto;

import br.com.iteris.adocao.animaisapi.controller.domain.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AnimalResponse {
    private int idAnimal;
    private String nome;
    private int idade;
    private String especie;
    private LocalDate dataNascimento;
    private Integer nivelFofura;
    private Integer nivelCarinho;
    private String email;

    public AnimalResponse(Animal animal){
        this.idAnimal = animal.getIdAnimal();
        this.nome = animal.getNome();
        this.idade = animal.getIdade();
        this.especie = animal.getEspecie();
        this.dataNascimento = animal.getDataNascimento();
        this.nivelFofura = animal.getNivelFofura();
        this.nivelCarinho = animal.getNivelCarinho();
        this.email = animal.getEmail();
    }
}
