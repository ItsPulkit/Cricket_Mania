package com.project.cricket.Cricket.Score.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.project.cricket.Cricket.Score.entities.Match;
import com.project.cricket.Cricket.Score.repositories.MatchRepo;
import com.project.cricket.Cricket.Score.services.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
  private MatchRepo matchRepo;

  public MatchServiceImpl(MatchRepo matchRepo) {
    this.matchRepo = matchRepo;
  }

  @Override
  public List<Match> getLiveMatches() {
    List<Match> matches = new ArrayList<>();
    try {
      String url = "https://www.espncricinfo.com/live-cricket-score";
      Document document = Jsoup.connect(url).get();

      Elements liveScoreElements = document.select("div.ds-text-compact-xxs");

      for (Element match : liveScoreElements) {

        String matchNumberVenue = match.select("div.ds-text-tight-xs.ds-truncate.ds-text-typo-mid3").text();
        String Teams = match.select("p.ds-text-tight-m.ds-font-bold.ds-capitalize.ds-truncate").text();
        String Score = match.select("div.ds-text-compact-s.ds-text-typo.ds-text-right.ds-whitespace-nowrap")
            .text();

        String feed = match.select("p.ds-text-tight-s.ds-font-medium.ds-truncate.ds-text-typo").text();
        String matchLink = match.select("a.ds-no-tap-higlight").attr("href").toString();

        String status = match.select("span.ds-text-tight-xs.ds-font-bold.ds-uppercase.ds-leading-5").text();

        Match match1 = new Match();
        if (status.equals("RESULT")) {
          match1.setStatus("COMPLETED");
        } else {
          match1.setStatus(status);
        }
        match1.setMatchNumberVenue(matchNumberVenue);
        match1.setTeams(Teams);
        match1.setScore(Score);
        match1.setFeed(feed);
        match1.setMatchLink(matchLink);

        matches.add(match1);

        // update the match in database

        updateMatchinDB(match1);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return matches;
  }

  private void updateMatchinDB(Match match) {
    Match match1 = this.matchRepo.findByMatchLink(match.getMatchLink()).orElse(null);
    if (match1 == null) {
      this.matchRepo.save(match);
    } else {

      match.setMatchId(match1.getMatchId());
      this.matchRepo.save(match);
    }
  }

  @Override
  public List<Match> getAllMatches() {
    return this.matchRepo.findAll();
  }

}
