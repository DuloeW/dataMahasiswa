package com.bayu.service.general.harisma.model.body;

import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;
import com.bayu.service.general.harisma.entity.MatakuliahTable;

import lombok.Data;

@Data
public class MatakuliahBody {
    private Long idMatakuliah;
    private String namaMatakuliah;
    private Long sks;
    private Long idDosen;

    public static MatakuliahBody fromMatakuliahTable(MatakuliahTable ent) {
        var output =  new MatakuliahBody();
        output.setIdMatakuliah(ent.idMatakuliah);
        output.setNamaMatakuliah(ent.namaMatakuliah);
        output.setSks(ent.sks);
        output.setIdDosen(ent.idDosen);
        return output;
    }

    public MatakuliahTable updateMatkul(MatakuliahTable matakuliah) {
        matakuliah.idMatakuliah = changeItOrNot(idMatakuliah, matakuliah.idMatakuliah);
        matakuliah.namaMatakuliah = changeItOrNot(namaMatakuliah, matakuliah.namaMatakuliah);
        matakuliah.sks = changeItOrNot(sks, matakuliah.sks);
       return matakuliah;
    }
}
