/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.travelamte.ws;

import br.com.travelamte.controle.Capturar;
import br.com.travelamte.facade.LeadFacade;
import br.com.travelamte.model.Lead;
import br.com.travelamte.model.Leads;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Wolverine
 */
@Path("leadws")
public class LeadWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public LeadWS() {
    }

    /**
     * Retrieves representation of an instance of br.com.travelamte.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "teste WS GET";
    }
    
    @GET
    @Produces("application/json")
    @Path("lead/get/{id}")
    public String getLeads(@PathParam("id") int id){
        LeadFacade leadFacade = new LeadFacade();
        Lead lead = leadFacade.getLead(id);
        Gson gson = new Gson();
        return gson.toJson(lead);
    }
    
    @GET
    @Produces("application/json")
    @Path("lead/getJson")
    public String getJsonCotnato(){
        Leads contato = new Leads();
        contato.setId(11205);
        contato.setNome("SHIRLEY MARQUES CAPITA");
        contato.setEmail("capitashirley01@outlook.com");
        contato.setTelefone("(35) 9991-81908");
        contato.setUnidade(61);
        contato.setMensagem("Boa tarde, gostaria de mais informaçoes sobre esse pacote, se tem em junho de 2018. Pretendo ir com minha filha e mãe idosa. Como fica o pacote?\n" +" obrigada");
        contato.setUnidade_desc("MG - Andradas");
        contato.setUrlclient("http://travelmate.com.br/viajar/curitiba-train/");
        Gson gson = new Gson();
        return gson.toJson(contato);
    }
    
    @POST
    @Consumes("application/json")
    @Path("lead/capturar/")
    public String capturar(String contato){
        try {
            Gson gson = new Gson();
            Leads capturada = gson.fromJson(contato, Leads.class);
            Capturar capturar = new Capturar();
            capturar.salvarLeads(capturada);
            if (capturada==null){
                return "null";
            }else {
                return capturada.getId().toString();
            }
            
        } catch (Exception e) {
            return e.toString();
        }
       // return "final";
    }
    
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
   
}
