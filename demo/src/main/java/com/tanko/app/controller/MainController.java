package com.tanko.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanko.app.DTO.CatDTO;
import com.tanko.app.entry.Cat;
import com.tanko.app.repository.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController //Аннотация
@RequiredArgsConstructor
public class MainController {
  /*  @Autowired*/
  /*  private final ObjectMapper objectMapper;*/
    private final CatRepo catRepo;

/*
    @GetMapping("/api/main") //Контроллер
    public String mainListner() {
        return "Hello World";
    }

    @GetMapping("/api/cat")
    public String giveCat() {
        Cat cat = new Cat("Snusik", 5, 3);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }

        return jsonData;

    }

    @PostMapping("api/special")
    public String giveSpecialCat(@RequestParam String name) {
        Cat cat = new Cat(name, 5, 3);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error with cat");
        }

        return jsonData;
    }*/

    @Operation(
            summary = "Добавление нового кота в базу",
            description = "Получает DTO кота и билдером собирает и сохраняет сущность в базу",
            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "На вход подаем имя, вес и возвраст кота"
            )
    )

    @PostMapping ("/api/add")
    public void addCat(@RequestBody CatDTO catDTO)
    {
        log.info("New row: " + catRepo.save(
                Cat.builder()
                        .name(catDTO.getName())
                        .weight(catDTO.getWeight())
                        .age(catDTO.getAge())
                        .build()));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAllCats()
    {
        return catRepo.findAll();
    }

    @GetMapping("/api/find")
    public Cat getCat(@RequestParam int id)
        {
        return catRepo.findById(id).orElse(null);
        }

    @DeleteMapping("/api/delete")
    public void deleteCat(@RequestParam int id)
    {
        catRepo.deleteById(id);
    }

    @PutMapping("/api/update")
       public String updateCat(@RequestBody Cat cat) {
        if (!catRepo.existsById(cat.getId()))
        {
            return "No such cat";
        }
        return catRepo.save(cat).toString();
    }

}

