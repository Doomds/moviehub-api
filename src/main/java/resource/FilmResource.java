package resource;

import dto.FilmDTO;
import entity.Film;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.FilmService;

import java.net.URI;
import java.util.List;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmResource {

    @Inject
    FilmService filmService;

    //http://localhost:8080/film?page=2&size=16
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

    @GET
    @Path("/random")
    public Film getRandomFilm() {
        return filmService.getRandomFilm();
    }

    @POST
    public Response create(FilmDTO dto) {

        Film film = filmService.create(dto);

        return Response
                .created(URI.create("/film/" + film.getId()))
                .build();
    }
}
