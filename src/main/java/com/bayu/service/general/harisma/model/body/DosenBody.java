package com.bayu.service.general.harisma.model.body;

import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;
import com.bayu.service.general.harisma.entity.DosenTable;

import lombok.Data;

@Data
public class DosenBody {
    private Long idDosen;
    private String namaDosen;
    private String noTelp;
    private String alamat;
 
    public static DosenBody fromDosenTable(DosenTable ent) {
        var output = new DosenBody();
        output.setIdDosen(ent.id);
        output.setNamaDosen(ent.namaDosen);
        output.setNoTelp(ent.noTelp);
        output.setAlamat(ent.alamat);
        return output;
    }

    public DosenTable updateDosen(DosenTable dosen) {
        dosen.id = changeItOrNot(idDosen, dosen.id);
        dosen.namaDosen = changeItOrNot(namaDosen, dosen.namaDosen);
        dosen.noTelp = changeItOrNot(noTelp, dosen.noTelp);
        dosen.alamat = changeItOrNot(alamat, dosen.alamat);
        return dosen;
    }

}
