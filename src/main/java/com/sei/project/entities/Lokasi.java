package com.sei.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter  @Setter @NoArgsConstructor
@ToString
public class Lokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToMany (mappedBy = "lokasiProyek")
    @JsonIgnore
    Set<Proyek> lokasi;
}
