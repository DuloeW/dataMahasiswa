package com.bayu.service.general.harisma.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "rl_maha_matkul")
public class RelasiMahaMatkulTable extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "id_relasi") 
    public Long idRelasi;
    
    @Column(name = "id_mahasiswa")
    public Long idMahasiswa;

    @Column(name = "id_matakuliah")
    public Long idMatakuliah;

    @Column(name = "test") 
    public String testMessage;

    public static Optional<RelasiMahaMatkulTable> findById(Long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<RelasiMahaMatkulTable> getAllData() {
        return RelasiMahaMatkulTable.listAll();
    }


}
