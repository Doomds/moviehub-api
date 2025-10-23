package repository;

import entity.Actor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {
}
