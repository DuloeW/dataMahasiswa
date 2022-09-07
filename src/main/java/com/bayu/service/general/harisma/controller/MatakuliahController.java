package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.service.MatakuliahHandler;

@Path("api/v1/matakuliah")
public class MatakuliahController {
    @Inject
    MatakuliahHandler matakuliahHandler;

    @GET
    public List<MatakuliahBody> getMatkul(@QueryParam long id) {
        return matakuliahHandler.getMatakuliah(id);
    }
    
    @GET
    @Path("/get-all")
    @Transactional
    public List<MatakuliahBody> getAllMatkul() {
        return matakuliahHandler.getAllMatkulTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public MatakuliahTable updateMatkul(MatakuliahBody body) {
        return matakuliahHandler.updateMatkulTable(body);
    }

    @GET
    @Path("/create")
    public MatakuliahBody createMatkul(MatakuliahBody body) {
        return matakuliahHandler.createMatkulTable(body);
    }

    
}
