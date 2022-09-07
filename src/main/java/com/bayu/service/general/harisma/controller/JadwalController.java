package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.JadwalTable;
import com.bayu.service.general.harisma.model.body.JadwalBody;
import com.bayu.service.general.harisma.service.JadwalHandler;

@Path("api/v1/jadwal")
public class JadwalController {
    @Inject
    JadwalHandler jadwalHandler;

    @GET
    public List<JadwalBody> getJadwal(@QueryParam long id) {
        return jadwalHandler.getJadwal(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<JadwalBody> getAllDosen() {
        return jadwalHandler.getAllJadwalTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public JadwalTable updateJadwal(JadwalBody body) {
        return jadwalHandler.updateJadwalTable(body);
    }

    @GET
    @Path("/create")
    public JadwalBody createJadwal(JadwalBody body) {
        return jadwalHandler.createJadwalTable(body);
    }
}
