package com.bayu.service.general.harisma.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "jurusan")
public class JurusanTable extends PanacheEntityBase{
    
    @Id

    @Column(name = "id_jurusan")
    public Long idJurusan;

    @Column(name = "nama_jurusan")
    public String namaJurusan;

    public static Optional<JurusanTable> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<JurusanTable> getAllData() {
        return JurusanTable.listAll();
    }
    
}
