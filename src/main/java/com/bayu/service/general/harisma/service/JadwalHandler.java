package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.bayu.service.general.harisma.entity.JadwalTable;
import com.bayu.service.general.harisma.exception.DataNotFoundException;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.model.body.JadwalBody;

@ApplicationScoped
public class JadwalHandler {
    public List<JadwalBody> getJadwal(long id) {
        return JadwalTable.findById(id)
                .stream()
                .map(JadwalBody::fromJadwalTable)
                .collect(Collectors.toList());
    }

    public List<JadwalBody> getAllJadwalTable() {
        return JadwalTable.getAllData()
                .stream()
                .map(JadwalBody::fromJadwalTable)
                .collect(Collectors.toList());
    }

    public JadwalTable updateJadwalTable(JadwalBody body) {
        JadwalTable jadwal = JadwalTable.findById(body.getIdJadwal());
        if(jadwal == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Jadwal not found");
        }
        body.updateJadwal(jadwal);
        return jadwal;
    }

    public JadwalBody createJadwalTable(JadwalBody body) {
        var jadwalTable = saveNewJadwalTable(body);
        return JadwalBody.fromJadwalTable(jadwalTable);
    }

    public JadwalTable saveNewJadwalTable(JadwalBody body) {
        var jadwalTable = new JadwalTable();
        jadwalTable.idJadwal = body.getIdJadwal();
        jadwalTable.tanggal = body.getTanggal();
        jadwalTable.ruangan = body.getRuangan();
        jadwalTable.persist();
        return jadwalTable;
    }

    public void deleteJadwal(long id) {
        JadwalTable.deleteById(id);
    }
}