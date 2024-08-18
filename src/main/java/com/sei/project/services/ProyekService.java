package com.sei.project.services;

import com.sei.project.entities.Proyek;
import com.sei.project.exceptions.DataNotFoundExceptionHander;
import com.sei.project.exceptions.InvalidDateException;
import com.sei.project.repositories.LokasiRepository;
import com.sei.project.repositories.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public List<Proyek> getAll(){
        return proyekRepository.findAll();
    }

    public Proyek create(Proyek proyek){
        if(proyek.getTglSelesai().before(proyek.getTglMulai())){
            throw new InvalidDateException("tgl selesai must not earlier than the tgl mulai");
        }
        return proyekRepository.save(proyek);
    }

    public Proyek update(Proyek proyek){
        if(proyek.getTglSelesai().before(proyek.getTglMulai())){
            throw new InvalidDateException("tgl selesai must not earlier than the tgl mulai");
        }

        long idProyek = proyek.getId();
        boolean isProyekExist = proyekRepository.existsById(idProyek);
        if(!isProyekExist) throw new DataNotFoundExceptionHander("proyek with id " + idProyek + " not found");

        return proyekRepository.save(proyek);
    }

    public void delete(Proyek proyek){

        long idProyek = proyek.getId();
        boolean isProyekExist = proyekRepository.existsById(idProyek);
        if(!isProyekExist) throw new DataNotFoundExceptionHander("proyek with id " + idProyek + " not found");

        proyekRepository.delete(proyek);
    }

    public Proyek getById(long id){
        boolean isProyekExist = proyekRepository.existsById(id);
        if(!isProyekExist) throw new DataNotFoundExceptionHander("proyek with id " + id + " not found");

        return proyekRepository.findById(id);
    }
}
