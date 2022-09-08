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

import com.bayu.service.general.harisma.entity.JadwalTable;
import com.bayu.service.general.harisma.model.body.JadwalBody;
import com.bayu.service.general.harisma.service.JadwalHandler;

@Path("api/v1/jadwal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JadwalController {
    @Inject
    JadwalHandler jadwalHandler;

    @GET
    public List<JadwalBody> getJadwal(@QueryParam long id) {
        return jadwalHandler.getJadwal(id);
    }

    //Read
    @GET
    @Path("/get-all")
    public List<JadwalBody> getAllDosen() {
        return jadwalHandler.getAllJadwalTable();
    }
    
    //Create
    @POST
    @Path("/create")
    @Transactional
    public JadwalBody createJadwal(JadwalBody body) {
        return jadwalHandler.createJadwalTable(body);
    }
    
    //Uploud
    @PUT
    @Path("/update")
    @Transactional
    public JadwalTable updateJadwal(JadwalBody body) {
        return jadwalHandler.updateJadwalTable(body);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteJadwal(@PathParam("id") long id) {
        jadwalHandler.deleteJadwal(id);
    }
}
