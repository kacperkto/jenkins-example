package pl.kkz.kozlowski.jenkins.service;

import pl.kkz.kozlowski.jenkins.dao.Movie;
import pl.kkz.kozlowski.jenkins.dao.MovieRepositor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private MovieRepositor movieRepositor;

    public MovieService(MovieRepositor movieRepositor) {
        this.movieRepositor = movieRepositor;
    }
    public List<Movie> get(int count){
       return movieRepositor.findAll().stream().limit(count).collect(Collectors.toList());
    }

}
