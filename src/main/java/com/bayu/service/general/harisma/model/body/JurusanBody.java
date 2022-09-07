package com.bayu.service.general.harisma.model.body;

import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;
import com.bayu.service.general.harisma.entity.JurusanTable;

import lombok.Data;

@Data
public class JurusanBody {
    private Long idJurusan;
    private String namaJurusan;

    public static JurusanBody fromJurusanTable(JurusanTable ent) {
        var output = new JurusanBody();
        output.setIdJurusan(ent.idJurusan);
        output.setNamaJurusan(ent.namaJurusan);
        return output;
    }

    public JurusanTable updateJurusan(JurusanTable jurusan) {
        jurusan.idJurusan = changeItOrNot(idJurusan, jurusan.idJurusan);
        jurusan.namaJurusan = changeItOrNot(namaJurusan, jurusan.namaJurusan);
        return jurusan;
    }
}
