package de.itbirkle.videorenamer.core.provider.tmdb.rto.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
// https://developers.themoviedb.org/3/tv-seasons/get-tv-season-details
public class TVSeasonRTO {

    private int id;
    private String name;
    private String overview;
    private List<EpisodeRTO> episodes;
    private int season_number;

    @Data
    @Accessors(chain = true)
    public static class EpisodeRTO {
        private int id;
        private String air_date;
        private int episode_number;
        private String name;
        private String overview;
        private int season_number;
    }

}
