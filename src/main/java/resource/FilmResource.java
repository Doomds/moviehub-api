package resource;

import entity.Film;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.FilmService;

import java.util.List;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {

    @Inject
    FilmService filmService;

    @GET
    public List<Film> getAllFilms() {
        return filmService.getAllFilmsSorted();
    }

    @GET
    @Path("{id}")
    public Film getFilmById(@PathParam("id") long id) {
        return filmService.findFilmById(id);
    }

}
