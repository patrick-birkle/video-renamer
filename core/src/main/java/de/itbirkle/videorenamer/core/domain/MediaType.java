package de.itbirkle.videorenamer.core.domain;

public enum MediaType {

    MOVIE("Movie"),
    SERIES("Series");

    private final String name;

    MediaType(String name) {
        this.name = name;
    }

    public boolean isMovie() {
        return this.equals(MOVIE);
    }

    public boolean isSeries() {
        return this.equals(SERIES);
    }
}
