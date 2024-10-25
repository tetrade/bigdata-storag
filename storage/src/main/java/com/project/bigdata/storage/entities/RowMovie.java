package com.project.bigdata.storage.entities;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RowMovie extends ProcessMovie {
    private String description;
    private String alternativeName;
    private String enName;
    private String shortDescription;
    private List<Name> names;
    private ExternalId externalId;
    private RowMovie.Logo logo;
    private Poster poster;
    private Backdrop backdrop;

    @Data
    public static class Backdrop {
        private String url;
        private String previewUrl;
    }

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
}
