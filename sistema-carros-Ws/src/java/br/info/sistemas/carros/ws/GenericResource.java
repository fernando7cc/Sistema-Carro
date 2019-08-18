/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.info.sistemas.carros.ws;

import br.info.sistemas.carros.dao.CarroDAO;
import br.info.sistemas.carros.entidade.Carro;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author ferna
 */
@Path("Carro")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of br.info.sistemas.corros.ws.GenericResource
     * @return an instance of java.lang.String
     */

    @GET
    @Produces("application/json")
    @Path("Carro/list")
    public String getCarro() throws Exception
    {
        List<Carro> lista;
        
        CarroDAO dao = new CarroDAO();
        lista = dao.buscar();
        
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
