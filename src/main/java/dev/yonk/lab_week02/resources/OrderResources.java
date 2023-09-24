package dev.yonk.lab_week02.resources;

import dev.yonk.lab_week02.models.Order;
import dev.yonk.lab_week02.services.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/order")
public class OrderResources {

    OrderService orderService;
    @Inject
    public OrderResources(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct() {
        List<Order> order = orderService.getAllOrder();
        return Response.ok().status(200).build();
    }
}
