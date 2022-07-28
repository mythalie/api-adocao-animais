package br.com.iteris.adocao.animaisapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class AnimalNaoEncontradoException extends RuntimeException {
    public AnimalNaoEncontradoException() {
        super("Não foi encontrado Animal para a entrada");
    }
}
