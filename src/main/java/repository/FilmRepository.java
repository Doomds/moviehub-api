package repository;

import entity.Film;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {

    public List<Film> listPaginated(int page, int size) {
        return findAll().page(page, size).list();
    }

}
