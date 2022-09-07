package com.bayu.service.general.harisma.model.body;

import static com.bayu.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;
import com.bayu.service.general.harisma.entity.MatakuliahTable;

import lombok.Data;

@Data
public class MatakuliahBody {
    private Long sks;
    private String namaMatakuliah;
    private Long idMatakuliah;

    public static MatakuliahBody fromMatakuliahTable(MatakuliahTable ent) {
        var output =  new MatakuliahBody();
        output.setSks(ent.sks);
        output.setNamaMatakuliah(ent.namaMatakuliah);
        output.setIdMatakuliah(ent.idMatakuliah);
        return output;
    }

    public MatakuliahTable updateMatkul(MatakuliahTable matakuliah) {
       matakuliah.sks = changeItOrNot(sks, matakuliah.sks);
       matakuliah.namaMatakuliah = changeItOrNot(namaMatakuliah, matakuliah.namaMatakuliah);
       matakuliah.idMatakuliah = changeItOrNot(idMatakuliah, matakuliah.idMatakuliah);
       return matakuliah;
    }
}
