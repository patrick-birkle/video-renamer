package de.itbirkle.videorenamer.core.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Search {

    private Provider provider;
    private MediaType mediaType;
    private List<SearchResult> results;

    private Search() {
    }

    public Search(Provider provider, MediaType mediaType) {
        this.provider = provider;
        this.mediaType = mediaType;
    }

    @Data
    @Accessors(chain = true)
    public static class SearchResult {
        private int id;
        private String title;
        private String description;
    }
}
