package com.sei.project.services;

import com.sei.project.entities.Lokasi;
import com.sei.project.exceptions.DataNotFoundExceptionHander;
import com.sei.project.repositories.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAll(){
        return lokasiRepository.findAll();
    }

    public Lokasi create(Lokasi lokasi){
        return lokasiRepository.save(lokasi);
    }

    public Lokasi update(Lokasi lokasi){
        long idLokasi = lokasi.getId();
        Lokasi l = lokasiRepository.findById(idLokasi);
        if(l == null) throw new DataNotFoundExceptionHander("lokasi with id " + idLokasi + " not found");
        return lokasiRepository.save(lokasi);
    }

    public void delete(Lokasi lokasi){
        long idLokasi = lokasi.getId();
        Lokasi l = lokasiRepository.findById(idLokasi);
        if(l == null) throw new DataNotFoundExceptionHander("lokasi with id " + idLokasi + " not found");
        lokasiRepository.delete(lokasi);
    }

    public Lokasi getById(long id){
        Lokasi l = lokasiRepository.findById(id);
        if(l == null) throw new DataNotFoundExceptionHander("lokasi with id " + id + " not found");

        return lokasiRepository.findById(id);
    }


}

