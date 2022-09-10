package com.bayu.service.general.harisma.model.body;
import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;
import com.bayu.service.general.harisma.entity.RelasiMahaMatkulTable;

import lombok.Data;

@Data
public class RelasiMahaMatkulBody {
    private Long idRelasi;
    private Long idMahasiswa;
    private Long idMatakuliah;
    private String testMessage;

    public static RelasiMahaMatkulBody fromRelasiMakulTable(RelasiMahaMatkulTable ent) {
        var output = new RelasiMahaMatkulBody();
        output.setIdRelasi(ent.idRelasi); 
        output.setIdMahasiswa(ent.idMahasiswa);
        output.setIdMatakuliah(ent.idMatakuliah);
        output.setTestMessage(ent.testMessage);
        return output;
    }

    public RelasiMahaMatkulTable updateRelasiMakul(RelasiMahaMatkulTable relasiMakul) {
        relasiMakul.idRelasi = changeItOrNot(idRelasi,relasiMakul.idRelasi);
        relasiMakul.idMahasiswa = changeItOrNot(idMahasiswa, relasiMakul.idMahasiswa);
        relasiMakul.idMatakuliah = changeItOrNot(idMatakuliah, relasiMakul.idMatakuliah);
        relasiMakul.testMessage = changeItOrNot(testMessage, relasiMakul.testMessage);
        return relasiMakul;
    }
}
