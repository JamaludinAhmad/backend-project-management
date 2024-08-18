package com.sei.project.controllers;

import com.sei.project.entities.Proyek;
import com.sei.project.exceptions.InvalidDateException;
import com.sei.project.services.ProyekService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @GetMapping
    public ResponseEntity getListProyeks(){
        Map<String, Object> data = new HashMap<>();

        data.put("data", proyekService.getAll());
        data.put("message", "success");
        data.put("status", "200");

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProyek(@RequestBody @Valid Proyek proyek){
        Proyek newProyek = proyekService.create(proyek);

        Map<String, Object> data = new HashMap<>();
        data.put("status", "201");
        data.put("message", "created");
        data.put("data", newProyek.getId());

        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateProyek(@RequestBody Proyek proyek){
        Proyek updatedProyek = proyekService.update(proyek);

        Map<String, Object> data = new HashMap<>();
        data.put("status", "200");
        data.put("message", "data updated");
        data.put("data", updatedProyek);

        return new ResponseEntity(data, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity deleteProyek (@RequestBody Proyek proyek){
        proyekService.delete(proyek);

        Map<String, Object> data = new HashMap<>();

        data.put("status", "200");
        data.put("message", "data deleted");

        return new ResponseEntity(data, HttpStatus.OK);
    }

}
