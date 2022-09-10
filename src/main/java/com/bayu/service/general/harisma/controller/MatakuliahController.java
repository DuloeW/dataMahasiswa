package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.model.form.MatakuliahAndDosenFrom;
import com.bayu.service.general.harisma.service.MatakuliahHandler;

@Path("api/v1/matakuliah")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatakuliahController {
    @Inject
    MatakuliahHandler matakuliahHandler;

    //Read one
    @GET
    @Path("/get/{id}")
    public List<MatakuliahBody> getMatkul(@PathParam("id") long id) {
        return matakuliahHandler.getMatakuliah(id);
    }
    
    //Read all
    @GET
    @Path("/get-all")
    public List<MatakuliahBody> getAllMatkul() {
        return matakuliahHandler.getAllMatkulTable();
    }

    //Uploud
    @PUT
    @Path("/update/{id}")
    @Transactional
    public MatakuliahTable updateMatkul(MatakuliahBody body) {
        return matakuliahHandler.updateMatkulTable(body);
    }

    //create with dosen
    @POST
    @Path("/create/with-dosen")
    @Transactional
    public MatakuliahAndDosenFrom createMatakuliahAndDosen(MatakuliahAndDosenFrom from) {
        return matakuliahHandler.createMatakuliahAndDosen(from);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMatkul(@PathParam("id") long id) {
        matakuliahHandler.deleteMatakuliah(id);
    }

    
}
