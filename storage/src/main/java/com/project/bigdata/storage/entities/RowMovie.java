package com.project.bigdata.storage.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Data
@JsonIgnoreType
public class RowMovie {
    private int id;
    private ExternalId externalId;
    private String name;
    private String alternativeName;
    private String enName;
    private List<Name> names;
    private String type;
    private int typeNumber;
    private int year;
    private String description;
    private String shortDescription;
    private String slogan;
    private String status;
    private List<Fact> facts;
    private Rating rating;
    private Votes votes;
    private int movieLength;
    private String ratingMpaa;
    private int ageRating;
    private Logo logo;
    private Poster poster;
    private Backdrop backdrop;
    private Videos videos;
    private List<Genre> genres;
    private List<Country> countries;
    private List<Person> persons;
    private ReviewInfo reviewInfo;
    private List<SeasonInfo> seasonsInfo;
    private Budget budget;
    private Fees fees;
    private Premiere premiere;
    private List<SimilarMovie> similarMovies;
    private List<SequelOrPrequel> sequelsAndPrequels;
    private Watchability watchability;
    private List<ReleaseYear> releaseYears;
    private int top10;
    private int top250;
    private boolean ticketsOnSale;
    private int totalSeriesLength;
    private int seriesLength;
    private Boolean isSeries;
    private List<Audience> audience;
    private List<String> lists;
    private Networks networks;
    private String updatedAt;
    private String createdAt;

    @Data
    public static class ExternalId {
        private String kpHD;
        private String imdb;
        private int tmdb;
    }

    @Data
    public static class Name {
        private String name;
        private String language;
        private String type;
    }

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
    public static class Backdrop {
        private String url;
        private String previewUrl;
    }

    @Data
    public static class Videos {
        private List<Trailer> trailers;
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
        private Fee world;
        private Fee russia;
        private Fee usa;
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
        private Poster poster;
        private Rating rating;
        private int year;
    }



    @Data
    public static class SequelOrPrequel {
        private int id;
        private String name;
        private String enName;
        private String alternativeName;
        private String type;
        private Poster poster;
        private Rating rating;
        private int year;
    }

    @Data
    public static class Watchability {
        private List<WatchabilityItem> items;
    }

    @Data
    public static class WatchabilityItem {
        private String name;
        private Logo logo;
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
        private List<NetworkItem> items;
    }

    @Data
    public static class NetworkItem {
        private String name;
        private Logo logo;
    }
}
