package de.itbirkle.videorenamer.core.mapper;

import de.itbirkle.videorenamer.core.domain.MediaType;
import de.itbirkle.videorenamer.core.domain.Provider;
import de.itbirkle.videorenamer.core.domain.Search;
import de.itbirkle.videorenamer.core.domain.series.Episode;
import de.itbirkle.videorenamer.core.domain.series.Season;
import de.itbirkle.videorenamer.core.domain.series.Series;
import de.itbirkle.videorenamer.core.provider.tmdb.dto.series.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TMDBMapperTest {

    @Test
    void toSearchSeries() {
        List<SearchSeriesDTO.SearchSeriesResultDTO> searchSeriesResultDTOs = SearchSeriesDTOTestFactory.createSearchSeriesResultDTOs(3);

        Search search = TMDBMapper.toSearchSeries(searchSeriesResultDTOs);

        assertEquals(Provider.TMDB, search.getProvider());
        assertEquals(MediaType.SERIES, search.getMediaType());
        assertEquals(3, search.getResults().size());

        List<String> titles = search.getResults().stream().map(Search.SearchResult::getTitle).collect(Collectors.toList());
        List<String> descriptions = search.getResults().stream().map(Search.SearchResult::getDescription).collect(Collectors.toList());
        List<Integer> ids = search.getResults().stream().map(Search.SearchResult::getId).collect(Collectors.toList());

        for (SearchSeriesDTO.SearchSeriesResultDTO searchSeriesResultDTO : searchSeriesResultDTOs) {
            assertTrue(titles.contains(searchSeriesResultDTO.getName()));
            assertTrue(descriptions.contains(searchSeriesResultDTO.getOverview()));
            assertTrue(ids.contains(searchSeriesResultDTO.getId()));
        }
    }

    @Test
    void toSeries() {
        SeriesDTO seriesDTO = SeriesDTOTestFactory.createSeriesDTO();
        Series series = TMDBMapper.toSeries(seriesDTO);

        assertEquals(seriesDTO.getName(), series.getTitle());
        assertEquals(seriesDTO.getOverview(), series.getDescription());
        assertEquals(seriesDTO.getNumber_of_seasons(), series.getNumOfSeasons());
        assertEquals(seriesDTO.getNumber_of_episodes(), series.getNumOfEpisodes());
        assertEquals(seriesDTO.getStatus(), series.getStatus());
        assertTrue(series.getGenres().contains(SeriesDTOTestFactory.GENRE_1.getName()));
        assertTrue(series.getGenres().contains(SeriesDTOTestFactory.GENRE_2.getName()));
        assertTrue(series.getSeasons().isEmpty());
    }

    @Test
    void toSeriesNull() {
        Series series = TMDBMapper.toSeries(null);

        assertNotNull(series);
        assertNotNull(series.getTitle());
        assertNotNull(series.getDescription());
        assertNotNull(series.getStatus());
        assertEquals(0, series.getNumOfSeasons());
        assertEquals(0, series.getNumOfEpisodes());
        assertNotNull(series.getGenres());
        assertNotNull(series.getSeasons());
    }

    @Test
    void toSeriesStringValuesNotNull() {
        SeriesDTO seriesDTO = SeriesDTOTestFactory.createSeriesDTO();
        seriesDTO.setName(null);
        seriesDTO.setOverview(null);
        seriesDTO.setStatus(null);

        Series series = TMDBMapper.toSeries(seriesDTO);

        assertNotNull(series.getTitle());
        assertTrue(series.getTitle().isEmpty());
        assertNotNull(series.getDescription());
        assertTrue(series.getDescription().isEmpty());
        assertNotNull(series.getStatus());
        assertTrue(series.getStatus().isEmpty());
    }

    @Test
    void toSeason() {

        SeasonDTO seasonDTO = SeasonDTOTestFactory.createSeasonDTO();

        Season season = TMDBMapper.toSeason(seasonDTO);
        assertEquals(seasonDTO.getName(), season.getTitle());
        assertEquals(seasonDTO.getOverview(), season.getDescription());
        assertEquals(seasonDTO.getSeason_number(), season.getSeason());
        assertEquals(seasonDTO.getEpisodes().size(), season.getEpisodes().size());

        List<String> episodeTitles = season.getEpisodes().stream().map(Episode::getTitle).collect(Collectors.toList());
        List<String> episodeDescription = season.getEpisodes().stream().map(Episode::getDescription).collect(Collectors.toList());
        List<Integer> episodeNumbers = season.getEpisodes().stream().map(Episode::getEpisode).collect(Collectors.toList());


        for (SeasonDTO.EpisodeDTO episodeDTO : seasonDTO.getEpisodes()) {
            assertTrue(episodeTitles.contains(episodeDTO.getName()));
            assertTrue(episodeDescription.contains(episodeDTO.getOverview()));
            assertTrue(episodeNumbers.contains(episodeDTO.getEpisode_number()));
        }
    }

    @Test
    void toSeasons() {
        List<SeasonDTO> seasonDTOs = SeasonDTOTestFactory.createSeasonDTOs(2);
        List<Season> seasons = TMDBMapper.toSeasons(seasonDTOs);
        assertEquals(seasonDTOs.size(), seasons.size());
    }

    @Test
    void toSeasonNull() {
        Season season = TMDBMapper.toSeason(null);
        assertNotNull(season);
        assertNotNull(season.getTitle());
        assertNotNull(season.getDescription());
        assertNotNull(season.getEpisodes());
    }

    @Test
    void toSeasonsNull() {

        List<Season> seasons = TMDBMapper.toSeasons(null);
        assertNotNull(seasons);
        assertTrue(seasons.isEmpty());

    }

}