package de.itbirkle.videorenamer.core.provider.tmdb.dto.series;

import java.util.ArrayList;
import java.util.List;

public class SearchSeriesDTOTestFactory {

    public static List<SearchSeriesDTO.SearchSeriesResultDTO> createSearchSeriesResultDTOs(int numberOfResults) {
        List<SearchSeriesDTO.SearchSeriesResultDTO> results = new ArrayList<>();
        for (int i = 0; i < numberOfResults; i++) {
            results.add(new SearchSeriesDTO.SearchSeriesResultDTO()
                    .setId(i + 1)
                    .setName("name " + (i + 1))
                    .setOverview("overview " + (i + 1)));
        }
        return results;
    }

}