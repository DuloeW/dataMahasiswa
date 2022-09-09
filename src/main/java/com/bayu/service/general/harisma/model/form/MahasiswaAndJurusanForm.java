package com.bayu.service.general.harisma.model.form;

import com.bayu.service.general.harisma.model.body.JurusanBody;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;

import lombok.Data;

@Data
public class MahasiswaAndJurusanForm {
    private MahasiswaBody mahasiswa;
    private JurusanBody jurusan;
}
