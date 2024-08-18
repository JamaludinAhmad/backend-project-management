package com.sei.project.repositories;

import com.sei.project.entities.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<Proyek, Long> {
    public Proyek findById(long id);
}
