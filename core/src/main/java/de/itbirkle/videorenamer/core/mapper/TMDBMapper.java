package de.itbirkle.videorenamer.core.mapper;

import de.itbirkle.videorenamer.core.domain.MediaType;
import de.itbirkle.videorenamer.core.domain.Provider;
import de.itbirkle.videorenamer.core.domain.Search;
import de.itbirkle.videorenamer.core.domain.series.Episode;
import de.itbirkle.videorenamer.core.domain.series.Season;
import de.itbirkle.videorenamer.core.domain.series.Series;
import de.itbirkle.videorenamer.core.provider.tmdb.dto.series.SearchSeriesDTO;
import de.itbirkle.videorenamer.core.provider.tmdb.dto.series.SeriesDTO;
import de.itbirkle.videorenamer.core.provider.tmdb.dto.series.SeasonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TMDBMapper {

    public static Search toSearchSeries(final List<SearchSeriesDTO.SearchSeriesResultDTO> searchSeriesResultDTOs) {
        return new Search(Provider.TMDB, MediaType.SERIES)
                .setResults(getSearchResults(searchSeriesResultDTOs));
    }

    private static List<Search.SearchResult> getSearchResults(final List<SearchSeriesDTO.SearchSeriesResultDTO> searchSeriesResultDTOs) {
        return searchSeriesResultDTOs != null ? searchSeriesResultDTOs.stream()
                .map(searchSeriesResultDTO -> new Search.SearchResult()
                        .setId(searchSeriesResultDTO.getId())
                        .setTitle(getValueString(searchSeriesResultDTO.getName()))
                        .setDescription(getValueString(searchSeriesResultDTO.getOverview())))
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    public static Series toSeries(final SeriesDTO tvDTO) {
        return tvDTO != null ? new Series()
                .setTitle(getValueString(tvDTO.getName()))
                .setDescription(getValueString(tvDTO.getOverview()))
                .setNumOfSeasons(tvDTO.getNumber_of_seasons())
                .setNumOfEpisodes(tvDTO.getNumber_of_episodes())
                .setStatus(getValueString(tvDTO.getStatus()))
                .setGenres(getGenres(tvDTO))
                .setSeasons(new ArrayList<>()) : new Series();
    }

    public static Season toSeason(final SeasonDTO seasonDTO) {
        return seasonDTO != null ? new Season()
                .setTitle(getValueString(seasonDTO.getName()))
                .setDescription(getValueString(seasonDTO.getOverview()))
                .setSeason(seasonDTO.getSeason_number())
                .setEpisodes(getEpisodes(seasonDTO.getEpisodes())) : new Season();
    }

    public static List<Season> toSeasons(final List<SeasonDTO> seasonDTOs) {
        return seasonDTOs != null ? seasonDTOs.stream()
                .map(TMDBMapper::toSeason)
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    private static List<String> getGenres(final SeriesDTO seriesDTO) {
        return seriesDTO.getGenres() != null ? seriesDTO.getGenres().stream()
                .map(SeriesDTO.GenreDTO::getName)
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    private static List<Episode> getEpisodes(final List<SeasonDTO.EpisodeDTO> episodeDTOs) {
        return episodeDTOs != null ? episodeDTOs.stream()
                .map(episodeDTO -> new Episode()
                        .setTitle(episodeDTO.getName())
                        .setDescription(episodeDTO.getOverview())
                        .setEpisode(episodeDTO.getEpisode_number()))
                .collect(Collectors.toList()) : new ArrayList<>();
    }

    private static String getValueString(final String value) {
        return value != null ? value : "";
    }

}
