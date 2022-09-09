package com.bayu.service.general.harisma.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "matakuliah")
public class MatakuliahTable extends PanacheEntityBase {
    
    @Id

    @Column(name = "id_matakuliah")
    public Long idMatakuliah;

    
    @Column(name = "nama_matakuliah")
    public String namaMatakuliah;
    
    @Column(name = "sks")
    public Integer sks;


    public static Optional<MatakuliahTable> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<MatakuliahTable> getAllData() {
        return MatakuliahTable.listAll();
    }
}
