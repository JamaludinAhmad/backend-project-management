package com.sei.project.repositories;

import com.sei.project.entities.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
    public Lokasi findById(long id);
}
