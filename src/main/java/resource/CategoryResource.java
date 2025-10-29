package resource;

import entity.Category;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.CategoryService;

import java.util.List;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    public List<Category> getAllCategory() {
        return categoryService.getAllCategoriesSorted();
    }

    @GET
    @Path("{id}")
    public Category getCategoryById(@PathParam("id") long id) {
        return categoryService.findCategoryById(id);
    }
}
