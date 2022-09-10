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

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.model.form.MahasiswaAndJurusanForm;
import com.bayu.service.general.harisma.service.MahasiswaHandler;

@Path("api/v1/mahasiswa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MahasiswaController {
    @Inject
    MahasiswaHandler mahasiswaHandler;

    //Read one
    @GET
    @Path("/get/{id}")
    public List<MahasiswaBody> getMahasiswa(@PathParam("id") long id) {
        return mahasiswaHandler.getMahasiswa(id);
    }

    //Read all
    @GET
    @Path("/get-all")
    public List<MahasiswaBody> getAllMahasiswa() {
        return mahasiswaHandler.getAllMahasiswaTable();
    }

    //Uploud
    @PUT
    @Path("/update/{id}")
    @Transactional
    public MahasiswaTable updateMahasiswa(MahasiswaBody body) {
        return mahasiswaHandler.updateMahasiswaTable(body);
    }

    //create with jurusan
    @POST
    @Path("/create/with-jurusan")
    @Transactional
    public MahasiswaAndJurusanForm createMahasiswaAndJurusan(MahasiswaAndJurusanForm form) {
        return mahasiswaHandler.createMahasiswaAndJurusan(form);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMahasiswa(@PathParam("id") long id) {
        mahasiswaHandler.deleteMahasiswa(id);
    }
    
}
