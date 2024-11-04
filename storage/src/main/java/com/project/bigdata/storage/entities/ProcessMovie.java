package com.project.bigdata.storage.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document("process-movie")
@TypeAlias("process-movie")
public class ProcessMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    @JsonProperty("id")
    @Indexed(unique = true)
    private long sourceId;

    private String name;
    private String type;
    private int typeNumber;
    private int year;
    private String slogan;
    private String status;
    private List<ProcessMovie.Fact> facts;
    private ProcessMovie.Rating rating;
    private ProcessMovie.Votes votes;
    private int movieLength;
    private String ratingMpaa;
    private int ageRating;
    private ProcessMovie.Videos videos;
    private List<ProcessMovie.Genre> genres;
    private List<ProcessMovie.Country> countries;
    private List<ProcessMovie.Person> persons;
    private ProcessMovie.ReviewInfo reviewInfo;
    private List<ProcessMovie.SeasonInfo> seasonsInfo;
    private ProcessMovie.Budget budget;
    private ProcessMovie.Fees fees;
    private ProcessMovie.Premiere premiere;
    private List<ProcessMovie.SimilarMovie> similarMovies;
    private List<ProcessMovie.SequelOrPrequel> sequelsAndPrequels;
    private ProcessMovie.Watchability watchability;
    private List<ProcessMovie.ReleaseYear> releaseYears;
    private int top10;
    private int top250;
    private boolean ticketsOnSale;
    private int totalSeriesLength;
    private int seriesLength;
    private Boolean isSeries;
    private List<ProcessMovie.Audience> audience;
    private List<String> lists;
    private ProcessMovie.Networks networks;
    private String updatedAt;
    private String createdAt;

    @Data
    public static class Fact {
        private String value;
        private String type;
        private boolean spoiler;
    }

    @Data
    public static class Rating {
        private double kp;
        private double imdb;
        private double tmdb;
        private double filmCritics;
        private double russianFilmCritics;
        private double await;
    }

    @Data
    public static class Votes {
        private String kp;
        private int imdb;
        private int tmdb;
        private int filmCritics;
        private int russianFilmCritics;
        private int await;
    }

    @Data
    public static class Logo {
        private String url;
    }

    @Data
    public static class Poster {
        private String url;
        private String previewUrl;
    }

    @Data
    public static class Videos {
        private List<RowMovie.Trailer> trailers;
    }

    @Data
    public static class Trailer {
        private String url;
        private String name;
        private String site;
        private int size;
        private String type;
    }

    @Data
    public static class Genre {
        private String name;
    }

    @Data
    public static class Country {
        private String name;
    }

    @Data
    public static class Person {
        private int id;
        private String photo;
        private String name;
        private String enName;
        private String description;
        private String profession;
        private String enProfession;
    }

    @Data
    public static class ReviewInfo {
        private int count;
        private int positiveCount;
        private String percentage;
    }

    @Data
    public static class SeasonInfo {
        private int number;
        private int episodesCount;
    }

    @Data
    public static class Budget {
        private int value;
        private String currency;
    }

    @Data
    public static class Fees {
        private RowMovie.Fee world;
        private RowMovie.Fee russia;
        private RowMovie.Fee usa;
    }

    @Data
    public static class Fee {
        private int value;
        private String currency;
    }

    @Data
    public static class Premiere {
        private String country;
        private String world;
        private String russia;
        private String digital;
        private String cinema;
        private String bluray;
        private String dvd;
    }

    @Data
    public static class SimilarMovie {
        private int id;
        private String name;
        private String enName;
        private String alternativeName;
        private String type;
        private RowMovie.Poster poster;
        private RowMovie.Rating rating;
        private int year;
    }



    @Data
    public static class SequelOrPrequel {
        private int id;
        private String name;
        private String enName;
        private String alternativeName;
        private String type;
        private RowMovie.Poster poster;
        private RowMovie.Rating rating;
        private int year;
    }

    @Data
    public static class Watchability {
        private List<RowMovie.WatchabilityItem> items;
    }

    @Data
    public static class WatchabilityItem {
        private String name;
        private RowMovie.Logo logo;
        private String url;
    }

    @Data
    public static class ReleaseYear {
        private int start;
        private int end;
    }

    @Data
    public static class Audience {
        private int count;
        private String country;
    }

    @Data
    public static  class Networks {
        private List<RowMovie.NetworkItem> items;
    }

    @Data
    public static class NetworkItem {
        private String name;
        private RowMovie.Logo logo;
    }
}
