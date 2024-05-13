package com.project.cricket.Cricket.Score.services;

import java.util.List;
import java.util.Map;

import com.project.cricket.Cricket.Score.entities.Match;

public interface MatchService {

  List<Match> getAllMatches();

  List<Match> getLiveMatches();

}
