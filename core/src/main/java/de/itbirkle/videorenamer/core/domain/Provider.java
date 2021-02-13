package de.itbirkle.videorenamer.core.domain;

import lombok.Getter;

@Getter
public enum Provider {

    TMDB("TheMovieDB");

    private final String name;

    Provider(String name) {
        this.name = name;
    }

    public boolean isTMDB() {
        return this.equals(TMDB);
    }
}
