package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.entity.DosenTable;
import com.bayu.service.general.harisma.entity.JadwalTable;
import com.bayu.service.general.harisma.exception.DataNotFoundException;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.exception.FormatException;
import com.bayu.service.general.harisma.model.body.DosenBody;
import com.bayu.service.general.harisma.model.body.JadwalBody;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.model.form.MatakuliahAndDosenFrom;

@ApplicationScoped
public class MatakuliahHandler {

    @Inject
    DosenHandler dosenHandler;

    @Inject
    JadwalHandler jadwalHandler;

    private record MatakuliahAndDosenTupple(MatakuliahTable matakuliah, DosenTable dosen, JadwalTable jadwal) {}

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

    @PUT
    @Path("/update/{id}")
    public MatakuliahTable updateMatkulTable(MatakuliahBody body) {
        MatakuliahTable matkul = MatakuliahTable.findById(body.getIdMatakuliah());
        if(matkul == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Matkul not Faund");
        }
        body.updateMatkul(matkul);
        return matkul;
    }

    public MatakuliahAndDosenFrom createMatakuliahAndDosen(MatakuliahAndDosenFrom form) {
        return Optional.of(form)
            .map(f -> {
                var dosen = dosenHandler.saveNewDosenTable(f.getDosen());
                var jadwal = jadwalHandler.saveNewJadwalTable(f.getJadwal());
                f.getMatakuliah().setIdDosen(dosen.id);
                f.getMatakuliah().setIdJadwal(jadwal.idJadwal);
                return new MatakuliahAndDosenTupple(saveNewMatkulTable(f.getMatakuliah()), dosen, jadwal);
            })
            .map(f -> {
                MatakuliahAndDosenFrom data = new MatakuliahAndDosenFrom();
                data.setDosen(DosenBody.fromDosenTable(f.dosen));
                data.setJadwal(JadwalBody.fromJadwalTable(f.jadwal));
                data.setMatakuliah(MatakuliahBody.fromMatakuliahTable(f.matakuliah));
                return data;
            })
            .orElseThrow(() -> new FormatException(ExceptionCode.F_NV));
    }

    public MatakuliahBody createMatkulTable(MatakuliahBody body) {
        var matakuliahTable = saveNewMatkulTable(body);
        return MatakuliahBody.fromMatakuliahTable(matakuliahTable);
    }

    public MatakuliahTable saveNewMatkulTable(MatakuliahBody body) {
        var matkulTable = new MatakuliahTable();
        matkulTable.idMatakuliah = body.getIdMatakuliah();
        matkulTable.namaMatakuliah = body.getNamaMatakuliah();
        matkulTable.sks = body.getSks();
        matkulTable.idDosen = body.getIdDosen();
        matkulTable.idJadwal = body.getIdJadwal();
        matkulTable.persist();
        return matkulTable;
    }

    public void deleteMatakuliah(long id) {
        MatakuliahTable.deleteById(id);
    }
}
