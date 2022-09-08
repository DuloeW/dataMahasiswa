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

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.service.MahasiswaHandler;

@Path("api/v1/mahasiswa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MahasiswaController {
    @Inject
    MahasiswaHandler mahasiswaHandler;

    @GET
    public List<MahasiswaBody> getMahasiswa(@QueryParam long id) {
        return mahasiswaHandler.getMahasiswa(id);
    }

    //Read
    @GET
    @Path("/get-all")
    public List<MahasiswaBody> getAllMahasiswa() {
        return mahasiswaHandler.getAllMahasiswaTable();
    }

    //Uploud
    @PUT
    @Path("/update")
    @Transactional
    public MahasiswaTable updateMahasiswa(MahasiswaBody body) {
        return mahasiswaHandler.updateMahasiswaTable(body);
    }

    //Create
    @POST
    @Path("/create")
    @Transactional
    public MahasiswaBody createMahasiswa(MahasiswaBody body) {
        return mahasiswaHandler.createMahasiswaTable(body);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMahasiswa(@PathParam("id") long id) {
        mahasiswaHandler.deleteMahasiswa(id);
    }
    
}