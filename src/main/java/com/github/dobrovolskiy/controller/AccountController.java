package com.github.dobrovolskiy.controller;

import com.github.dobrovolskiy.model.Account;
import com.github.dobrovolskiy.service.AccountService;
import com.github.dobrovolskiy.service.AccountServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * RESTful controller for accounts
 *
 * @see AccountService
 * @see Account
 * @since 1.0
 */
@Path("/accounts")
public class AccountController {
    private AccountService accountService = new AccountServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account get(@PathParam("id") String id) {
        return accountService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account create(Account account) {
        return accountService.create(account);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account update(@PathParam("id") String id, Account account) {
        account.setId(id);
        return accountService.update(account);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        accountService.delete(id);
    }
}
