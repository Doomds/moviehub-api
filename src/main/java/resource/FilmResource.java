package resource;

import entity.Film;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import service.FilmService;

import java.util.List;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {

    @Inject
    FilmService filmService;

    @GET
    public List<Film> getFilms(@QueryParam("page") Integer page,
                               @QueryParam("size") Integer size) {

        if (page == null || size == null) {
            return filmService.getAllFilmsSorted();
        }

        return filmService.getFilmsPaginated(page, size);
    }

    @GET
    @Path("{id}")
    public Film getFilmById(@PathParam("id") long id) {
        return filmService.findFilmById(id);
    }


}
