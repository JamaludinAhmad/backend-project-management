package com.sei.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString
public class Proyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "nama_proyek must be not blank")
    private String namaProyek;

    @NotBlank(message = "client must be not blank")
    private String client;

    private Date tglMulai;


    private Date tglSelesai;

    @NotBlank(message = "pimpinan_proyek must be not blank")
    private String pimpinanProyek;

    @Lob
    @NotBlank(message = "keterangan must be not blank")
    @Size(min = 10, max = 5000, message = "keterangan must be at most 5000 character, and has at least 10 character")
    private String keterangan;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(
            name="proyek_lokasi",
            joinColumns = @JoinColumn(name = "proyek_id"),
            inverseJoinColumns = @JoinColumn(name = "lokasi_id")
    )
    Set<Lokasi> lokasiProyek;
}
