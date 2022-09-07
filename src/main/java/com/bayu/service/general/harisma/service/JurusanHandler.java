package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.bayu.service.general.harisma.entity.JurusanTable;
import com.bayu.service.general.harisma.exception.DataNotFoundException;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.model.body.JurusanBody;

@ApplicationScoped
public class JurusanHandler {
    public List<JurusanBody> getJurusan(long id) {
        return JurusanTable.findById(id)
                .stream()
                .map(JurusanBody::fromJurusanTable)
                .collect(Collectors.toList());
    }

    public List<JurusanBody> getAllJurusanTable() {
        return JurusanTable.getAllData()
                .stream()
                .map(JurusanBody::fromJurusanTable)
                .collect(Collectors.toList());
    }

    public JurusanTable updateJadwalTable(JurusanBody body) {
        JurusanTable jurusan = JurusanTable.findById(body.getIdJurusan());
        if(jurusan == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "jurusan not found");
        }
        body.updateJurusan(jurusan);
        return jurusan;
    }

    public JurusanBody createJurusanTable(JurusanBody body) {
        var jurusanTable = saveNewjJurusanTable(body);
        return JurusanBody.fromJurusanTable(jurusanTable);
    } 

    public JurusanTable saveNewjJurusanTable(JurusanBody body) {
        var jurusanTable = new JurusanTable();
        jurusanTable.idJurusan = body.getIdJurusan();
        jurusanTable.namaJurusan = body.getNamaJurusan();
        return jurusanTable;
    }
}
