package org.blb.service.news;

import lombok.AllArgsConstructor;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.DTO.news.newsJsonModel.FetchNewsDataDTO;
import org.blb.models.news.NewsDataEntity;
import org.blb.repository.news.NewsDataRepository;
import org.blb.service.util.newsMapping.NewsDataConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AddNewsDataService {
    private final FetchNewsApi fetchNewsApi;
    private final NewsDataRepository newsDataRepository;
    private final NewsDataConverter newsDataConverter;

    @Transactional
    public StandardResponseDto saveNewsFromFetchApi() {
        List<FetchNewsDataDTO> newsFromFetch = fetchNewsApi.fetchDataFromApi();

            for (FetchNewsDataDTO fetchNewsDataDTO : newsFromFetch) {
                NewsDataEntity newsDataEntity = newsDataConverter.fromFetchApiToEntity(fetchNewsDataDTO);

                if (newsDataRepository.findByTitle(newsDataEntity.getTitle()).isEmpty()) {
                    newsDataRepository.save(newsDataEntity);
                }
            }
            return new StandardResponseDto("All news loaded successfully");

    }
}
