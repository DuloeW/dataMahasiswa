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

import com.bayu.service.general.harisma.entity.DosenTable;
import com.bayu.service.general.harisma.model.body.DosenBody;
import com.bayu.service.general.harisma.service.DosenHandler;

@Path("api/v1/dosen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DosenController {
    @Inject
    DosenHandler dosenHandler;

    @GET
    public List<DosenBody> getDosen(@QueryParam long id) {
        return dosenHandler.getDosen(id);
    }

    //Read
    @GET
    @Path("/get-all")
    public List<DosenBody> getAllDosen() {
        return dosenHandler.getAllDosenTable();
    }

    //Create
    @POST
    @Path("/create")
    public DosenBody createDosen(DosenBody body) {
        return dosenHandler.createDosenTable(body);
    } 

    //Uploud
    @PUT
    @Path("/uploud/{id}")
    @Transactional
    public DosenTable updatDosen(@PathParam("id") long id, DosenBody body) {
        return dosenHandler.updateDosenTable(body);
    }

    //Delete
    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteDosen(@PathParam("id") long id) {
        dosenHandler.deleteDosen(id);
    }
}
