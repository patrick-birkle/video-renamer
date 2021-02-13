package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
// https://developers.themoviedb.org/3/tv-seasons/get-tv-season-details
public class SeasonDTO {

    private int id;
    private String name;
    private String overview;
    private int season_number;
    private List<EpisodeDTO> episodes;

    @Data
    @Accessors(chain = true)
    public static class EpisodeDTO {
        private int id;
        private String name;
        private String overview;
        private int season_number;
        private int episode_number;
    }

}
