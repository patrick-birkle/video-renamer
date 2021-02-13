package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import de.itbirkle.videorenamer.core.provider.tmdb.dto.PageDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SearchSeriesDTO extends PageDTO {

    private List<SearchSeriesResultDTO> results;

    @Data
    @Accessors(chain = true)
    public static class SearchSeriesResultDTO {
        private int id;
        private String name;
        private String overview;
    }

}
