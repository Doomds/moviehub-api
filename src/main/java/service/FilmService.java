package service;

import entity.Film;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.FilmRepository;

import java.util.List;

@ApplicationScoped
public class FilmService {

    @Inject
    FilmRepository filmRepository;

    public List<Film> getAllFilmsSorted() {
        return filmRepository.listAll(Sort.by("title"));
    }

    public Film findFilmById(long id) {
        return filmRepository.findById(id);
    }

    public List<Film> getFilmsPaginated(int page, int size) {
        return filmRepository.listPaginated(page, size);
    }

    public Film getRandomFilm() {
        return filmRepository.getRandomFilm();
    }
}
