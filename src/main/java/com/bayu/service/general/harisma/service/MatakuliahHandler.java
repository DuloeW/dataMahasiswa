package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.exception.DataNotFoundException;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;

@ApplicationScoped
public class MatakuliahHandler {
    public List<MatakuliahBody> getMatakuliah(long id) {
        return MatakuliahTable.findById(id)
                .stream()
                .map(MatakuliahBody::fromMatakuliahTable)
                .collect(Collectors.toList());
    }
    
    public List<MatakuliahBody> getAllMatkulTable() {
        return MatakuliahTable.getAllData()
                .stream()
                .map(MatakuliahBody::fromMatakuliahTable)
                .collect(Collectors.toList());
    }

    public MatakuliahTable updateMatkulTable(MatakuliahBody body) {
        MatakuliahTable matkul = MatakuliahTable.findById(body.getIdMatakuliah());
        if(matkul == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Matkul not Faund");
        }
        body.updateMatkul(matkul);
        return matkul;
    }

    public MatakuliahBody createMatkulTable(MatakuliahBody body) {
        var matakuliahTable = saveNewMatkulTable(body);
        return MatakuliahBody.fromMatakuliahTable(matakuliahTable);
    }

    public MatakuliahTable saveNewMatkulTable(MatakuliahBody body) {
        var matkulTable = new MatakuliahTable();
        matkulTable.sks = body.getSks();
        matkulTable.namaMatakuliah = body.getNamaMatakuliah();
        matkulTable.idMatakuliah = body.getIdMatakuliah();
        matkulTable.persist();
        return matkulTable;
    }

}
