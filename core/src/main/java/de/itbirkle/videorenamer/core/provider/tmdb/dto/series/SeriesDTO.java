package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
// https://developers.themoviedb.org/3/tv/get-tv-details
public class SeriesDTO {

    private int id;
    private String name;
    private String overview;
    private List<GenreDTO> genres;
    private int number_of_episodes;
    private int number_of_seasons;
    private List<SeasonBaseDTO> seasons;
    private String status;

    @Data
    @Accessors(chain = true)
    public static class GenreDTO {
        private int id;
        private String name;
    }

    @Data
    @Accessors(chain = true)
    public static class SeasonBaseDTO {
        private int id;
        private String name;
        private String overview;
        private int episode_count;
        private int season_number;
    }
}

