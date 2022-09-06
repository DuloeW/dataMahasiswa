package com.bayu.service.general.harisma.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "dosen")
public class DosenTable extends PanacheEntityBase{
    @Id

    @Column(name = "id_dosen")
    public Long id;

    @Column(name = "nama_dosen")
    public String namaDosen;

    @Column(name = "no_telp")
    public String noTelp;

    @Column(name = "alamat_dosen")
    public String alamat;

    public static Optional<DosenTable> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<DosenTable> getAllData() {
        return DosenTable.listAll();
    }
    
}
