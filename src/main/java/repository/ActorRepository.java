package repository;

import entity.Actor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {

    public List<Actor> ListPaginated(int page, int size) {
        return findAll().page(page, size).list();
    }
}
