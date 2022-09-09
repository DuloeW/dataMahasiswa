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

import com.bayu.service.general.harisma.entity.JurusanTable;
import com.bayu.service.general.harisma.model.body.JurusanBody;
import com.bayu.service.general.harisma.service.JurusanHandler;

@Path("api/v1/jurusan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JurusanController {
    @Inject
    JurusanHandler jurusanHandler;

    //Read one
    @GET
    @Path("/get/{id}")
    public List<JurusanBody> getJadwal(@PathParam("id") long id) {
        return jurusanHandler.getJurusan(id);
    }

    //Read all
    @GET
    @Path("/get-all")
    public List<JurusanBody> getAllJurusan() {
        return jurusanHandler.getAllJurusanTable();
    }

    //Uploud
    @PUT
    @Path("/update/{id}")
    @Transactional 
    public JurusanTable updadtejurusan(JurusanBody body) {
        return jurusanHandler.updateJadwalTable(body);
    }

    //Create
    @POST
    @Path("/create")
    @Transactional  
    public JurusanBody crateJurusan(JurusanBody body) {
        return jurusanHandler.createJurusanTable(body);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteJurusan(@PathParam("id") long id) {
        jurusanHandler.deleteJurusan(id);
    }
}
