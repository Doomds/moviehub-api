package service;

import dto.FilmDTO;
import entity.Film;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Film create(FilmDTO dto) {
        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setDescription(dto.getDescription());
        film.setReleaseYear(dto.getReleaseYear());
        film.setLanguageId(dto.getLanguageId());

        filmRepository.persist(film);

        return film;
    }
}
