package com.kani;

import com.kani.dto.ToDoEntry;
import com.kani.service.ToDoService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("rpc")
public class TodoRpcResource {
    private static final Logger LOGGER = Logger.getLogger(TodoRpcResource.class);

    @Inject
    ToDoService toDoService;

    @GET
    @Path("getAll")
    public List<ToDoEntry> getAll(){
        LOGGER.info("'getAll' RPC call invoked");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toDoService.findAll().list();
    }

    @POST
    @Path("update")
    @Transactional
    public ToDoEntry update(@QueryParam("id") Integer id,
                     @QueryParam("text") String text,
                     @QueryParam("done") Boolean done){
        LOGGER.info("'update' RPC call invoked");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ToDoEntry byId = toDoService.findById(Long.valueOf(id));
        if(byId == null){
            throw new NotFoundException();
        }
        byId.setText(text);
        byId.setDone(done);

        return byId;
    }

    @POST
    @Path("create")
    @Transactional
    public ToDoEntry create(@QueryParam("text") String text,
                     @QueryParam("done") Boolean done){
        LOGGER.info("'create' RPC call invoked");
        ToDoEntry toDoEntry = new ToDoEntry(text, done);
        toDoService.persist(toDoEntry);
        return toDoEntry;
    }

    @POST
    @Path("delete")
    @Transactional
    public Response delete(@QueryParam("id") Long id){
        LOGGER.info("'delete' RPC call invoked");
        toDoService.deleteById(Long.valueOf(id));
        return Response.ok().build();
    }

    @GET
    @Path("export")
    public Response export(){
        LOGGER.info("Export began");
        for (int i = 0; i < 5000000; i++) {
//            for (int j = 0; j < 50000000; j++) {
                Math.sqrt(1325285734.32537453453);
//            }
        }
        LOGGER.info("Export end");
        return Response.ok().build();
    }
}
