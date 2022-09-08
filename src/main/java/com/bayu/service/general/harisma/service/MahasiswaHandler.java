package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.exception.DataNotFoundException;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;

@ApplicationScoped
public class MahasiswaHandler {
    public List<MahasiswaBody> getMahasiswa(long id) {
        return MahasiswaTable.findById(id)
                .stream()
                .map(MahasiswaBody::fromMahasiswaTable)
                .collect(Collectors.toList());
    }

    public List<MahasiswaBody> getAllMahasiswaTable() {
        return MahasiswaTable.getAllData()
                .stream()
                .map(MahasiswaBody::fromMahasiswaTable)
                .collect(Collectors.toList());
    }

    public MahasiswaTable updateMahasiswaTable(MahasiswaBody body) {
        MahasiswaTable mahasiswa = MahasiswaTable.findById(body.getIdMahasiswa());
        if(mahasiswa == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Mahasiswa not found");
        }
        body.updateMahasiswa(mahasiswa);
        return mahasiswa;
    }

    public MahasiswaBody createMahasiswaTable(MahasiswaBody body) {
        var mahasiswaTable = saveNewMahasiswaTable(body);
        return MahasiswaBody.fromMahasiswaTable(mahasiswaTable);
    }

    public MahasiswaTable saveNewMahasiswaTable(MahasiswaBody body) {
        var mahasiswaTable = new MahasiswaTable();
        mahasiswaTable.idMahasiswa = body.getIdMahasiswa();
        mahasiswaTable.namaMahasiswa = body.getNamaMahasiswa();
        mahasiswaTable.jenisKelami = body.getJenisKelamin();
        mahasiswaTable.noTelp = body.getNoTelp();
        mahasiswaTable.alamat = body.getAlamat();
        mahasiswaTable.persist();
        return mahasiswaTable;
    }

    public void deleteMahasiswa(long id) {
        MahasiswaTable.deleteById(id);
    }

}
