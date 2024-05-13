package com.project.cricket.Cricket.Score.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cricket.Cricket.Score.entities.Match;

public interface MatchRepo extends JpaRepository<Match, Integer> {
  Optional<Match> findByMatchLink(String matchLink);

}
