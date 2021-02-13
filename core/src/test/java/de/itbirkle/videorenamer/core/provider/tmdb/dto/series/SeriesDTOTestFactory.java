package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import java.util.Arrays;
import java.util.List;

public class SeriesDTOTestFactory {

    public static int ID = 1337;
    public static String NAME = "name";
    public static String OVERVIEW = "overview";
    public static String STATUS = "status";
    public static SeriesDTO.GenreDTO GENRE_1 = new SeriesDTO.GenreDTO().setId(1).setName("action");
    public static SeriesDTO.GenreDTO GENRE_2 = new SeriesDTO.GenreDTO().setId(2).setName("drama");
    public static List<SeriesDTO.GenreDTO> GENRES = Arrays.asList(GENRE_1, GENRE_2);
    public static SeriesDTO.SeasonBaseDTO SEASON_1 = new SeriesDTO.SeasonBaseDTO()
            .setId(1)
            .setName("Season 1")
            .setOverview("Overview 1")
            .setSeason_number(1)
            .setEpisode_count(16);
    public static SeriesDTO.SeasonBaseDTO SEASON_2 = new SeriesDTO.SeasonBaseDTO()
            .setId(2)
            .setName("Season 2")
            .setOverview("Overview 2")
            .setSeason_number(2)
            .setEpisode_count(16);
    public static List<SeriesDTO.SeasonBaseDTO> SEASONS = Arrays.asList(SEASON_1, SEASON_2);

    public static SeriesDTO createSeriesDTO() {
        return new SeriesDTO()
                .setId(ID)
                .setName(NAME)
                .setOverview(OVERVIEW)
                .setStatus(STATUS)
                .setGenres(GENRES)
                .setSeasons(SEASONS)
                .setNumber_of_seasons(SEASONS.size())
                .setNumber_of_seasons(SEASON_1.getEpisode_count() + SEASON_2.getEpisode_count());
    }

}