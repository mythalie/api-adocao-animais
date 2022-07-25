package br.com.iteris.adocao.animaisapi.service;

import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalCreateRequest;
import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalResponse;
import br.com.iteris.adocao.animaisapi.controller.domain.entity.Animal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> listaDeAnimais;
    private static int proximoId = 1;

    public AnimalService() {
        if (listaDeAnimais == null) {
            listaDeAnimais = new ArrayList<>();
            listaDeAnimais.add(new Animal(proximoId++, "Leona", 7, "Gato", LocalDate.of(2015,01,01), 5, 5, "leona@hotmail.com"));
            listaDeAnimais.add(new Animal(proximoId++, "Teemo", 2, "Coelho", LocalDate.of(2016,01,01), 5, 3, "teemo@hotmail.com"));
            listaDeAnimais.add(new Animal(proximoId++, "Zed", 5, "Cachorro", LocalDate.of(2017,01,01), 5, 5, "zeed@hotmail.com"));
        }
    }

    public AnimalResponse cadastrarAnimal(AnimalCreateRequest createRequest) {

        if (!createRequest.getEspecie().equalsIgnoreCase("Cachorro") && !createRequest.getEspecie().equalsIgnoreCase("Gato")
                && !createRequest.getEspecie().equalsIgnoreCase("Coelho") && !createRequest.getEspecie().equalsIgnoreCase("Capivara")) {
            throw new IllegalArgumentException("Somente será possível as espécies: Cachorro, Gato, Coelho e Capivara.");
        }

        Animal novoAnimal = new Animal();
        novoAnimal.setIdAnimal(proximoId++);
        novoAnimal.setNome(createRequest.getNome());
        novoAnimal.setIdade(createRequest.getIdade());
        novoAnimal.setEspecie(createRequest.getEspecie());
        novoAnimal.setDataNascimento(createRequest.getDataNascimento());
        novoAnimal.setNivelFofura(createRequest.getNivelFofura());
        novoAnimal.setNivelCarinho(createRequest.getNivelCarinho());
        novoAnimal.setEmail(createRequest.getEmail());

        listaDeAnimais.add(novoAnimal);
        AnimalResponse animalResponse = new AnimalResponse(novoAnimal);
        return animalResponse;
    }

    public List<AnimalResponse> listarTodos() {
        List<AnimalResponse> responseList = new ArrayList<AnimalResponse>();
        for (Animal a : listaDeAnimais) {
            responseList.add(new AnimalResponse(a));
        }
        return responseList;
    }

    public AnimalResponse buscarId (Integer idAnimal) {

//        listaDeAnimais.forEach(animal -> {
//            animal.getIdAnimal();
//        });

        // pra cada elemento da minha lista de animais, eu tenho um animal.
        for (Animal animal : listaDeAnimais) {
            if(animal.getIdAnimal() == idAnimal) {
                return new AnimalResponse(
                        animal
                );
            }
        }
        throw new IllegalArgumentException("ID não encontrado");
    }

}
