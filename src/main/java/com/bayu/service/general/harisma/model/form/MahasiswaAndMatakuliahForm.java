package com.bayu.service.general.harisma.model.form;

import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.model.body.RelasiMahaMatkulBody;

import lombok.Data;

@Data
public class MahasiswaAndMatakuliahForm {
    private RelasiMahaMatkulBody relasi;
    private MahasiswaBody mahasiswa;
    private MatakuliahBody matakuliah;
}
