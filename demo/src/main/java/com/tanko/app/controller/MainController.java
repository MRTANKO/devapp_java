package com.tanko.app.controller;

import com.tanko.app.DTO.PeopleDTO;
import com.tanko.app.entry.People;
import com.tanko.app.repository.PeopleRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController //Аннотация
@RequiredArgsConstructor
public class MainController {
  /*  @Autowired*/
  /*  private final ObjectMapper objectMapper;*/
    private final PeopleRepo peopleRepo;

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

    @GetMapping("/api/main") //Контроллер для healthcheck
    public String mainListner() {
        return "Service UP";
    }

    @Operation(
            summary = "Добавление новой персоны в базу",
            description = "Получает DTO персоны и билдером собирает и сохраняет сущность в базу",
            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "На вход подаем имя, прозвище и дату"
            )
    )

    @PostMapping ("/api/add")
    public void addPersone(@RequestBody PeopleDTO peopleDTO)
    {
        log.info("New row: " + peopleRepo.save(
                People.builder()
                        .name(peopleDTO.getName())
                        .nickname(peopleDTO.getNickname())
                        .birthday(peopleDTO.getBirthday())
                        .build()));
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<People> getAllPeople()
    {
        return peopleRepo.findAll();
    }

    @GetMapping("/api/find")
    public People getPerson(@RequestParam int id)
        {
        return peopleRepo.findById(id).orElse(null);
        }

    @DeleteMapping("/api/delete")
    public void deletePersone(@RequestParam int id)
    {
        peopleRepo.deleteById(id);
    }

    @PutMapping("/api/update")
       public String updatePersone(@RequestBody People people) {
        if (!peopleRepo.existsById(people.getId()))
        {
            return "No such persone";
        }
        return peopleRepo.save(people).toString();
    }

}

