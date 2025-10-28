package resource;

import entity.Actor;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.ActorService;

import java.util.List;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    ActorService actorService;

    @GET
    public List<Actor> getAllActors() {
        return actorService.getAllActorsSorted();
    }

    @GET
    @Path("{id}")
    public Actor getActorById(@PathParam("id") long id) {
        return actorService.findActorById(id);
    }
}
