package service;

import dto.ActorDTO;
import entity.Actor;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.ActorRepository;

import java.time.LocalDateTime;
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

    @Transactional
    public Actor create(ActorDTO dto) {
        Actor actor = new Actor();
        actor.setFirstName(dto.getFirstName());
        actor.setLastName(dto.getLastName());

        actorRepository.persist(actor);

        return actor;
    }
}
