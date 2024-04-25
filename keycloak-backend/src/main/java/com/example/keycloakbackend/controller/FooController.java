package com.example.keycloakbackend.controller;

import com.example.keycloakbackend.dto.ResponseMessage;
import com.example.keycloakbackend.model.Foo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/foo")
@CrossOrigin
public class FooController {

    List<Foo> foos =
            Stream.of(new Foo(1, "foo 1"),
                    new Foo(2, "foo 2"),
                    new Foo(3, "foo 3") ).collect(Collectors.toList());

    @GetMapping("/list")
    public ResponseEntity<List<Foo>> list(){
        return new ResponseEntity<>(foos, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Foo> detail(@PathVariable("id") int id){
        Foo foo = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        return new ResponseEntity(foo, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Foo foo){
        int maxIndex = foos.stream().max(Comparator.comparing(m -> m.getId())).get().getId();
        foo.setId(maxIndex + 1);
        foos.add(foo);
        return new ResponseEntity(new ResponseMessage("created"), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Foo foo){
        Foo fooUpdate = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        fooUpdate.setName(foo.getName());
        return new ResponseEntity(new ResponseMessage("actualized"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        Foo foo = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        foos.remove(foo);
        return new ResponseEntity(new ResponseMessage("eliminated"), HttpStatus.OK);
    }
}
