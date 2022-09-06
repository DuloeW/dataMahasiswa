package com.bayu.service.general.harisma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matakuliah")
public class MatakuliahTable {
    
    @Id

    @Column(name = "sks")
    public Integer sks;

    @Column(name = "nama_matakuliah")
    public String namaMatakuliah;

    @Column(name = "id_matakuliah")
    public Long idMatakuliah;
}
