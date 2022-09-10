package com.bayu.service.general.harisma.model.form;

import com.bayu.service.general.harisma.model.body.DosenBody;
import com.bayu.service.general.harisma.model.body.JadwalBody;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;

import lombok.Data;

@Data
public class MatakuliahAndDosenFrom {
    private MatakuliahBody matakuliah;
    private DosenBody dosen;
    private JadwalBody jadwal;
}