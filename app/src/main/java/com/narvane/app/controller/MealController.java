package com.narvane.app.controller;

import com.narvane.app.datadispatcher.MealDataDispatcher;
import com.narvane.app.dto.CreateMealDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
/*import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meal")
@RequiredArgsConstructor
@Validated
public class MealController {

    private final MealDataDispatcher dataDispatcher;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMealDTO.Response create(@RequestBody @Valid CreateMealDTO.Request request) {
        return dataDispatcher.newMeal(request);
    }

    // TODO Later infra
    /*@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateMealDTO.Response update(@RequestBody UpdateMealDTO.Request request) {
        return dataDispatcher.existentMeal(request);
    }*/

    @GetMapping("/test")
    public String test(@RequestHeader HttpHeaders headers) {
        // Aqui você pode acessar os headers da requisição
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        // Se quiser acessar um header específico, pode fazer assim:
        String contentType = headers.getFirst("Content-Type");
        System.out.println("Content-Type: " + contentType);

        // Seu código aqui...

        return "Resposta do seu endpoint";
    }

}
