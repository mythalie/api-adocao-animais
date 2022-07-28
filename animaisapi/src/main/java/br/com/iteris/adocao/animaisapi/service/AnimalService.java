package br.com.iteris.adocao.animaisapi.service;

import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalCreateRequest;
import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalResponse;
import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalUpdateRequest;
import br.com.iteris.adocao.animaisapi.controller.domain.entity.Animal;
import br.com.iteris.adocao.animaisapi.exception.AnimalNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> listaDeAnimais;
    private static int proximoId = 1;

    private static List<String> especie() {
        List<String> especies = new ArrayList<String>();
        especies.add("Cachorro");
        especies.add("Gato");
        especies.add("Coelho");
        especies.add("Capivara");
        return especies;
    }

    public AnimalService() {
        if (listaDeAnimais == null) {
            listaDeAnimais = new ArrayList<>();
            listaDeAnimais.add(new Animal(proximoId++, "Leona", 7, "Gato", LocalDate.of(2015,01,01), 5, 5, "leona@hotmail.com"));
            listaDeAnimais.add(new Animal(proximoId++, "Teemo", 2, "Coelho", LocalDate.of(2016,01,01), 5, 3, "teemo@hotmail.com"));
            listaDeAnimais.add(new Animal(proximoId++, "Zed", 5, "Cachorro", LocalDate.of(2017,01,01), 5, 5, "zeed@hotmail.com"));
        }
    }

    public AnimalResponse cadastrarAnimal(AnimalCreateRequest createRequest) {

        if (!especie().contains(createRequest.getEspecie())) {
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
        for (Animal animal : listaDeAnimais) {
            if(animal.getIdAnimal() == idAnimal) {
                return new AnimalResponse(
                        animal
                );
            }
        }
        throw new AnimalNaoEncontradoException();
    }

    public AnimalResponse editarAnimal (Integer idAnimal, AnimalUpdateRequest updateRequest) {
        for (Animal animal : listaDeAnimais) {
            if(animal.getIdAnimal() == idAnimal) {
                animal.setNome(updateRequest.getNome());
                animal.setIdade(updateRequest.getIdade());
                animal.setEspecie(updateRequest.getEspecie());
                animal.setNivelFofura(updateRequest.getNivelFofura());
                animal.setNivelCarinho(updateRequest.getNivelCarinho());
                animal.setEmail(updateRequest.getEmail());
                return new AnimalResponse(animal);
            }
        }
        throw new IllegalArgumentException("Animal não encontrado!");
    }

    public AnimalResponse deletarAnimal (Integer idAnimal) {
        for (Animal animal : listaDeAnimais) {
            if (animal.getIdAnimal() == idAnimal) {
                listaDeAnimais.remove(animal);
                return new AnimalResponse(animal);
            }
        }
        throw new IllegalArgumentException("Animal não encontrado!");
    }
}
