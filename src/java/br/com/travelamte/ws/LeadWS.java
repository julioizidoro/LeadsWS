/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.ws;

import br.com.travelamte.controle.Capturar;
import br.com.travelamte.facade.LeadFacade;
import br.com.travelamte.model.Lead;
import br.com.travelamte.model.Leadblog;
import br.com.travelamte.model.Leadbot;
import br.com.travelamte.model.Leads;
import br.com.travelamte.model.Retorno;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Wolverine
 */
@Path("")
public class LeadWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public LeadWS() {
    }

    /**
     * Retrieves representation of an instance of
     * br.com.travelamte.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "teste WS GET";
    }

    @GET
    @Produces("application/json")
    @Path("get/{id}")
    public String getLeads(@PathParam("id") int id) {
        LeadFacade leadFacade = new LeadFacade();
        Lead lead = leadFacade.getLead(id);
        Gson gson = new Gson();
        return gson.toJson(lead);
    }

    @GET
    @Produces("application/json")
    @Path("getid/")
    public String getId() {
        LeadFacade leadFacade = new LeadFacade();
        Lead lead = leadFacade.getLead(12330);
        Gson gson = new Gson();
        return gson.toJson(lead);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("fc/")
    public Response capturarFC(String contato) {
        Gson gson = new Gson();
        Leads capturada = gson.fromJson(contato, Leads.class);
        Capturar capturar = new Capturar();
        capturar.salvarLeads(capturada);
        if (capturada == null) {
            return Response.status(200).entity("ERRO").build();
        } else {
            return Response.status(200).entity("OK").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("blog/")
    public Response capturarBlog(String leadblog) {

        Gson gson = new Gson();
        Leadblog capturada = gson.fromJson(leadblog, Leadblog.class);
        Capturar capturar = new Capturar();
        boolean resultado = false;
        Lead lead = capturar.salvarLeadBlog(capturada);
        if (lead == null) {
            return Response.status(200).entity("ERRO").build();
        } else {
            return Response.status(200).entity("OK").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bot/")
    public Response capturarBot(String leadbot) {
        Gson gson = new Gson();
        Leadbot capturada = gson.fromJson(leadbot, Leadbot.class);
        Capturar capturar = new Capturar();

        Lead lead = capturar.salvarLeadBot(capturada);
        if (lead == null) {
            return Response.status(200).entity("ERRO").build();
        } else {
            return Response.status(200).entity("OK").build();
        }

    }

}
