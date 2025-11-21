package service;

import entity.Actor;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.ActorRepository;

import java.util.List;

@ApplicationScoped
public class ActorService {

    @Inject
    ActorRepository actorRepository;

    public List<Actor> getAllActorsSorted() {
        return actorRepository.listAll(Sort.by("firstName"));
    }

    public Actor findActorById(long id) {
        return actorRepository.findById(id);
    }

    public List<Actor> getActorsPaginated(int page, int size) {
        return actorRepository.ListPaginated(page, size);
    }
}
