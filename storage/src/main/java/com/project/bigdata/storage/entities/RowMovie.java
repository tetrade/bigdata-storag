package com.project.bigdata.storage.entities;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("row-movie")
@TypeAlias("row-movie")
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RowMovie extends ProcessMovie {
    private String description;
    private String alternativeName;
    private String enName;
    private String shortDescription;
    private List<Name> names;
    private ExternalId externalId;
    private ProcessMovie.Logo logo;
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
