package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeasonDTOTestFactory {

    public static int ID = 1337;
    public static int SEASON_NUMBER = 1;
    public static String NAME = "name";
    public static String OVERVIEW = "overview";

    public static SeasonDTO createSeasonDTO() {
        return createSeasonDTO(ID, SEASON_NUMBER, NAME, OVERVIEW);
    }

    public static SeasonDTO createSeasonDTO(int id, int season, String name, String overview) {
        return new SeasonDTO()
                .setId(id)
                .setSeason_number(season)
                .setName(name)
                .setOverview(overview)
                .setEpisodes(getEpisodes(season));
    }

    public static List<SeasonDTO> createSeasonDTOs(int numberOfSeasons) {
        List<SeasonDTO> seasonDTOs = new ArrayList<>();
        for (int i = 0; i < numberOfSeasons; i++) {
            seasonDTOs.add(createSeasonDTO(i, i + 1, NAME + " " + (i + 1), OVERVIEW + " " + (i + 1)));
        }
        return seasonDTOs;
    }

    private static List<SeasonDTO.EpisodeDTO> getEpisodes(int season) {
        return Arrays.asList(
                new SeasonDTO.EpisodeDTO()
                        .setId(1)
                        .setSeason_number(season)
                        .setEpisode_number(1)
                        .setName("Episode " + 1)
                        .setOverview("Overview " + 1),
                new SeasonDTO.EpisodeDTO()
                        .setId(2)
                        .setSeason_number(season)
                        .setEpisode_number(2)
                        .setName("Episode " + 2)
                        .setOverview("Overview " + 2),
                new SeasonDTO.EpisodeDTO()
                        .setId(3)
                        .setSeason_number(season)
                        .setEpisode_number(3)
                        .setName("Episode " + 3)
                        .setOverview("Overview " + 3)
        );
    }

}