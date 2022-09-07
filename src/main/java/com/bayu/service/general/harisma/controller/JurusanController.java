package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.JurusanTable;
import com.bayu.service.general.harisma.model.body.JurusanBody;
import com.bayu.service.general.harisma.service.JurusanHandler;

@Path("api/v1/jadwal")
public class JurusanController {
    @Inject
    JurusanHandler jurusanHandler;

    @GET
    public List<JurusanBody> getJadwal(@QueryParam long id) {
        return jurusanHandler.getJurusan(id);
    }

    @GET
    @Path("/get-all")
    public List<JurusanBody> getAllJurusan() {
        return jurusanHandler.getAllJurusanTable();
    }

    @GET
    @Path("/update") 
    @Transactional
    public JurusanTable updadtejurusan(JurusanBody body) {
        return jurusanHandler.updateJadwalTable(body);
    }

    @GET
    @Path("/create")
    public JurusanBody crateJurusan(JurusanBody body) {
        return jurusanHandler.createJurusanTable(body);
    }
}
