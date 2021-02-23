package pl.kkz.kozlowski.jenkins.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kkz.kozlowski.jenkins.dao.Movie;


public interface MovieRepositor extends JpaRepository<Movie,Long> {



}
