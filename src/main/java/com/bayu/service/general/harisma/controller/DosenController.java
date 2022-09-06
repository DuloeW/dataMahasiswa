package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.DosenTable;
import com.bayu.service.general.harisma.model.body.DosenBody;
import com.bayu.service.general.harisma.service.DosenHandler;

@Path("api/v1/dosen")
public class DosenController {
    @Inject
    DosenHandler dosenHandler;

    @GET
    public List<DosenBody> getDosen(@QueryParam long id) {
        return dosenHandler.getDosen(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<DosenBody> getAllDosen() {
        return dosenHandler.getAllDosenTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public DosenTable updatDosen(DosenBody body) {
        return dosenHandler.updateDosenTable(body);
    }

    @GET
    @Path("/create")
    public DosenBody createDosen(DosenBody body) {
        return dosenHandler.createDosenTable(body);
    } 
}
