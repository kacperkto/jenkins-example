package pl.kkz.kozlowski.jenkins.graphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kkz.kozlowski.jenkins.service.MovieService;
import pl.kkz.kozlowski.jenkins.dao.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieQuery implements GraphQLQueryResolver {

    private MovieService movieService;

    public MovieQuery(MovieService movieService) {
        this.movieService = movieService;
    }
    public List<Movie> getMovies(int limit){
       return movieService.get(limit);

    }
}
