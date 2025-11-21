package resource;

import entity.Actor;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.ActorService;

import java.util.List;

@Path("/actor")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    ActorService actorService;

    @GET
    public List<Actor> getActors(@QueryParam("page") Integer page,
                                 @QueryParam("size") Integer size) {

        if (page == null || size == null) {
            return actorService.getAllActorsSorted();
        }

        return actorService.getActorsPaginated(page, size);
    }

    @GET
    @Path("{id}")
    public Actor getActorById(@PathParam("id") long id) {
        return actorService.findActorById(id);
    }
}
