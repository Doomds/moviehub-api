package resource;

import entity.Actor;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import repository.ActorRepository;

import java.util.List;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    ActorRepository actorRepository;

    @GET
    public List<Actor> getAllActors() {
        return actorRepository.listAll(Sort.by("firstName"));
    }
}
