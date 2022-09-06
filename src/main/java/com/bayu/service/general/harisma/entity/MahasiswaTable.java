package com.bayu.service.general.harisma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaTable {
    
    @Id

    @Column(name = "id_mahasiswa")
    public Long idMahasiswa;

    @Column(name = "nama_mahasiswa")
    public String namaMahasiswa;

    @Column(name = "jenis_kelamin")
    public String jenisKelami;

    @Column(name = "no_telp")
    public String noTelp;

    @Column(name = "alamat")
    public String alamat;
}
