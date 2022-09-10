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
@Table(name = "jadwal")
public class JadwalTable extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "id_jadwal")
    public Long idJadwal;

    @Column(name = "tanggal")
    public String tanggal;

    @Column(name = "ruangan")
    public String ruangan;

    public static Optional<JadwalTable> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<JadwalTable> getAllData() {
        return JadwalTable.listAll();
    }
    
}
