package dev.yonk.lab_week02.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/order")
public class OrderResources {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct() {

        return Response.ok().status(200).build();
    }
}
