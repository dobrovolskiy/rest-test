package com.github.dobrovolskiy.controller;

import com.github.dobrovolskiy.model.Transfer;
import com.github.dobrovolskiy.service.TransferService;
import com.github.dobrovolskiy.service.TransferServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * RESTful controller for money transfers
 *
 * @see TransferService
 * @see Transfer
 * @since 1.0
 */
@Path("/transfers")
public class TransferController {
    private TransferService transferService = new TransferServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PageResponse<Transfer> getAll(@QueryParam("page") @DefaultValue("0") Integer page,
                                 @QueryParam("size") @DefaultValue("10") Integer size) {
        return transferService.getAll(new PageRequest(page, size));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transfer get(@PathParam("id") String id) {
        return transferService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transfer create(Transfer transfer) {
        return transferService.create(transfer);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transfer update(@PathParam("id") String id, Transfer transfer) {
        transfer.setId(id);
        return transferService.update(transfer);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        transferService.delete(id);
    }
}
