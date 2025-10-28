package resource;

import entity.Film;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import repository.FilmRepository;

import java.util.List;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @GET
    public List<Film> getAllFilms() {
        return filmRepository.listAll();
    }

}
