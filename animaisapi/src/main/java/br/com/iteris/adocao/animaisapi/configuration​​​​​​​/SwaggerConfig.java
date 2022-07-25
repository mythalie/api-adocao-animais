package br.com.iteris.adocao.animaisapi.configuration​​​​​​​;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
// o Swagger é ativado através da anotação @EnableSwagger2
@EnableSwagger2
public class SwaggerConfig {
    // bean nos permite configurar aspectos dos endpoints expostos por ele
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // Nos métodos apis() e paths() definimos que todas as apis e caminhos estarão disponíveis.
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.iteris.adocao.animaisapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "animaisapi",
                "Universidade Iteris - Spring Boot - Adocao Animais",
                "1.0.0",
                "Disponível para estudos",
                new Contact("Universidade Iteris", "https://iteris1.sharepoint.com/sites/universidade", "organizacao.td@iteris.com.br"),
                "", "", Collections.emptyList());
    }
}
