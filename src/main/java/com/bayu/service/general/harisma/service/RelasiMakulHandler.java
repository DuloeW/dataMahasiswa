package com.bayu.service.general.harisma.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.entity.RelasiMahaMatkulTable;
import com.bayu.service.general.harisma.exception.ExceptionCode;
import com.bayu.service.general.harisma.exception.FormatException;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.model.body.RelasiMahaMatkulBody;
import com.bayu.service.general.harisma.model.form.MahasiswaAndMatakuliahForm;

@ApplicationScoped
public class RelasiMakulHandler {
    
    @Inject
    MahasiswaHandler mahasiswaHandler;

    @Inject
    MatakuliahHandler matakuliahHandler;

    private record RelasiMahaMakulTupple(RelasiMahaMatkulTable relasi, MahasiswaTable mahasisa, MatakuliahTable matakuliah) {}

    public List<RelasiMahaMatkulBody> getRelasiMahaMatkul(Long id) {
        return RelasiMahaMatkulTable.findById(id)
        .stream()
        .map(RelasiMahaMatkulBody::fromRelasiMakulTable)
        .collect(Collectors.toList());
    }

    public List<RelasiMahaMatkulBody> getAllMRelasiTable() {
        return RelasiMahaMatkulTable.getAllData()
        .stream()
        .map(RelasiMahaMatkulBody::fromRelasiMakulTable)
        .collect(Collectors.toList());
    }

    public MahasiswaAndMatakuliahForm createMahasiswaAndMatakuliah(MahasiswaAndMatakuliahForm form) {
        return Optional.of(form)
            .map(f -> {
                var mahasiswa = mahasiswaHandler.saveNewMahasiswaTable(f.getMahasiswa());
                var matakuliah = matakuliahHandler.saveNewMatkulTable(f.getMatakuliah());
                f.getRelasi().setIdMahasiswa(mahasiswa.idMahasiswa);
                f.getRelasi().setIdMatakuliah(matakuliah.idMatakuliah);
                return new RelasiMahaMakulTupple(saveNewRelasiMahaMatkulTable(f.getRelasi()), mahasiswa, matakuliah);
            })
            .map(f -> {
                MahasiswaAndMatakuliahForm data = new MahasiswaAndMatakuliahForm();
                data.setMahasiswa(MahasiswaBody.fromMahasiswaTable(f.mahasisa));
                data.setMatakuliah(MatakuliahBody.fromMatakuliahTable(f.matakuliah));
                data.setRelasi(RelasiMahaMatkulBody.fromRelasiMakulTable(f.relasi));
                return data;
            })
            .orElseThrow(() -> new FormatException(ExceptionCode.F_NV));
    }


    public RelasiMahaMatkulTable saveNewRelasiMahaMatkulTable(RelasiMahaMatkulBody body) {
        var relasiMahaMatkul = new RelasiMahaMatkulTable();
        relasiMahaMatkul.idRelasi = body.getIdRelasi();
        relasiMahaMatkul.idMahasiswa = body.getIdMahasiswa();
        relasiMahaMatkul.idMatakuliah = body.getIdMatakuliah();
        relasiMahaMatkul.testMessage = body.getTestMessage();
        relasiMahaMatkul.persist();
        return relasiMahaMatkul;
    }

    
}
