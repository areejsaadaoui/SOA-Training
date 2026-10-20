package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestApi {
    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    @Path("/getListe")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListe(){
        return Response.status(200).entity(helper.getListeUE()).build();
    }

    @Path("/getById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id){
        return Response.status(200).entity(helper.getUEByCode(id)).build();
    }

    @Path("/getByDomaine/{domaine}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDomaine(@PathParam("domaine") String domaine){
        return Response.status(200).entity(helper.getUEByDomaine(domaine)).build();
    }

    @Path("/addEns")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUE(UniteEnseignement ue){
        return Response.status(201).entity(helper.addUniteEnseignement(ue)).build();
    }

    @Path("/getBySemestre/{smemestre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBySemestre(@PathParam("smemestre") int smemestre){
        return Response.status(200).entity(helper.getUEBySemestre(smemestre)).build();
    }

    @Path("/DeleteEns")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUE(@QueryParam("id") int id){
        return Response.status(203).entity(helper.deleteUniteEnseignement(id)).build();
    }

    @Path("/updateEns")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUE(@QueryParam("ue") UniteEnseignement ue,@QueryParam("code") int code){
        return  Response.status(202).entity(helper.updateUniteEnseignement(code,ue)).build();
    }

}