package com.sei.project.controllers;

import com.sei.project.entities.Lokasi;
import com.sei.project.entities.Proyek;
import com.sei.project.repositories.LokasiRepository;
import com.sei.project.services.LokasiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/api/lokasi")

public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public ResponseEntity getAllLokasi(){
        Map <String, Object> data = new HashMap<>();
        data.put("status", "200");
        data.put("message", "success");
        data.put("data", lokasiService.getAll());
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createLokasi(@RequestBody @Valid Lokasi lokasi) throws Exception {
        Lokasi newLokasi = lokasiService.create(lokasi);

        Map<String, Object> data = new HashMap<>();
        data.put("status", "201");
        data.put("message", "data created");
        data.put("data", newLokasi.getId());

        return new ResponseEntity(data, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity editLokasi(@RequestBody Lokasi lokasi){
        Lokasi newLokasi = lokasiService.update(lokasi);

        Map<String, Object> data = new HashMap<>();
        data.put("status", "200");
        data.put("message", "data updated");
        data.put("data", newLokasi);

        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity deleteLokasi(@RequestBody Lokasi lokasi){
        lokasiService.delete(lokasi);

        Map<String, Object> data = new HashMap<>();
        data.put("status", "200");
        data.put("message", "data deleted");

        return new ResponseEntity<>(data, HttpStatus.OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity getLokasiById(@PathVariable("id") long id){
        Lokasi lokasi = lokasiService.getById(id);

        Map<String, Object> data = new HashMap<>();

        data.put("status", "200");
        data.put("message", "success");
        data.put("data", lokasi);
        return new ResponseEntity(data, HttpStatus.OK);
    }


}
