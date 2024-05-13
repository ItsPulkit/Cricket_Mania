package com.project.cricket.Cricket.Score.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cricket_matches")
public class Match {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int matchId;

  private String matchNumberVenue;

  private String Teams;

  private String Score;

  private String feed;

  private String matchLink;

  private String status;

  private Date date = new Date();

  public Match() {
  }

  public Match(int matchId, String matchNumberVenue, String Teams, String Score, String feed, String matchLink,
      String status, Date date) {
    this.matchId = matchId;
    this.matchNumberVenue = matchNumberVenue;
    this.Teams = Teams;
    this.Score = Score;
    this.feed = feed;
    this.matchLink = matchLink;
    this.status = status;
    this.date = date;
  }

  public int getMatchId() {
    return this.matchId;
  }

  public void setMatchId(int matchId) {
    this.matchId = matchId;
  }

  public String getMatchNumberVenue() {
    return this.matchNumberVenue;
  }

  public void setMatchNumberVenue(String matchNumberVenue) {
    this.matchNumberVenue = matchNumberVenue;
  }

  public String getTeams() {
    return this.Teams;
  }

  public void setTeams(String Teams) {
    this.Teams = Teams;
  }

  public String getScore() {
    return this.Score;
  }

  public void setScore(String Score) {
    this.Score = Score;
  }

  public String getFeed() {
    return this.feed;
  }

  public void setFeed(String feed) {
    this.feed = feed;
  }

  public String getMatchLink() {
    return this.matchLink;
  }

  public void setMatchLink(String matchLink) {
    this.matchLink = matchLink;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Match matchId(int matchId) {
    setMatchId(matchId);
    return this;
  }

  public Match matchNumberVenue(String matchNumberVenue) {
    setMatchNumberVenue(matchNumberVenue);
    return this;
  }

  public Match Teams(String Teams) {
    setTeams(Teams);
    return this;
  }

  public Match Score(String Score) {
    setScore(Score);
    return this;
  }

  public Match feed(String feed) {
    setFeed(feed);
    return this;
  }

  public Match matchLink(String matchLink) {
    setMatchLink(matchLink);
    return this;
  }

  public Match status(String status) {
    setStatus(status);
    return this;
  }

  public Match date(Date date) {
    setDate(date);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Match)) {
      return false;
    }
    Match match = (Match) o;
    return matchId == match.matchId && Objects.equals(matchNumberVenue, match.matchNumberVenue)
        && Objects.equals(Teams, match.Teams) && Objects.equals(Score, match.Score) && Objects.equals(feed, match.feed)
        && Objects.equals(matchLink, match.matchLink) && Objects.equals(status, match.status)
        && Objects.equals(date, match.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, matchNumberVenue, Teams, Score, feed, matchLink, status, date);
  }

  @Override
  public String toString() {
    return "{" +
        " matchId='" + getMatchId() + "'" +
        ", matchNumberVenue='" + getMatchNumberVenue() + "'" +
        ", Teams='" + getTeams() + "'" +
        ", Score='" + getScore() + "'" +
        ", feed='" + getFeed() + "'" +
        ", matchLink='" + getMatchLink() + "'" +
        ", status='" + getStatus() + "'" +
        ", date='" + getDate() + "'" +
        "}";
  }

}
