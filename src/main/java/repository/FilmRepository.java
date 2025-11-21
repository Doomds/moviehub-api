package repository;

import entity.Film;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Random;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {

    public List<Film> listPaginated(int page, int size) {
        return findAll().page(page, size).list();
    }

    public Film getRandomFilm() {
        List<Film> listOfFilms = listAll();
        if(listOfFilms.isEmpty()) {
            return null;
        }

        int index = new Random().nextInt(listOfFilms.size());
        return listOfFilms.get(index);
    }

}
