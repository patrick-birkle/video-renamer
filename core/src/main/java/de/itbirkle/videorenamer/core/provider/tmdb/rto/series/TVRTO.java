package de.itbirkle.videorenamer.core.provider.tmdb.rto.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
// https://developers.themoviedb.org/3/tv/get-tv-details
public class TVRTO {

    private int id;
    private String name;
    private String overview;
    private List<GenreRTO> genres;
    private int number_of_episodes;
    private int number_of_seasons;
    private List<SeasonRTO> seasons;
    private String status;

    @Data
    @Accessors(chain = true)
    public class GenreRTO {
        private int id;
        private String name;
    }

    @Data
    @Accessors(chain = true)
    public class SeasonRTO {
        private int id;
        private String air_date;
        private int episode_count;
        private String name;
        private String overview;
        private int season_number;
    }
}

