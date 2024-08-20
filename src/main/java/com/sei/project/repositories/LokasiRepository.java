package com.sei.project.repositories;

import com.sei.project.entities.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
    public Lokasi findById(long id);
    public Lokasi findByNegaraAndProvinsiAndKotaAndNamaLokasi(
            String negara, String provinsi, String kota, String namaLokasi
    );
}
