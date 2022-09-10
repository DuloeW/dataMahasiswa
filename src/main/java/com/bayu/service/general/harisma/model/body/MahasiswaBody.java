package com.bayu.service.general.harisma.model.body;

import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.bayu.service.general.harisma.entity.MahasiswaTable;

import lombok.Data;

@Data
public class MahasiswaBody {
    private Long idMahasiswa;
    private String namaMahasiswa;
    private String jenisKelamin;
    private String noTelp;
    private String alamat;
    private Long idJurusan;


    public static MahasiswaBody fromMahasiswaTable(MahasiswaTable ent) {
        var output = new MahasiswaBody();
        output.setIdMahasiswa(ent.idMahasiswa);
        output.setNamaMahasiswa(ent.namaMahasiswa);
        output.setJenisKelamin(ent.jenisKelamin);
        output.setNoTelp(ent.noTelp);
        output.setAlamat(ent.alamat);
        output.setIdJurusan(ent.idJurusan);
        return output;
    }

    public MahasiswaTable updateMahasiswa(MahasiswaTable mahasiswa) {
        mahasiswa.idMahasiswa = changeItOrNot(idMahasiswa, mahasiswa.idMahasiswa);
        mahasiswa.namaMahasiswa = changeItOrNot(namaMahasiswa, mahasiswa.namaMahasiswa);
        mahasiswa.noTelp = changeItOrNot(noTelp, mahasiswa.noTelp);
        mahasiswa.alamat = changeItOrNot(alamat, mahasiswa.alamat);
        return mahasiswa;
    }
}