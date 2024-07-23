package org.blb.service.blog;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogResponseDTO;
import org.blb.DTO.blog.BlogsRequestDTO;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.blb.repository.blog.BlogFindRepository;
import org.blb.service.region.FindRegionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogFindService {


    private final BlogFindRepository blogFindRepository;
    private final FindRegionService findRegionService;

    public List<BlogResponseDTO> findAll(BlogsRequestDTO dto) {
        Region region = findRegionService.findRegionById(dto.getRegion_ID());
        Pageable page = PageRequest.of(0, 2);
        Page<Blog> blogs = blogFindRepository.findAllByRegion(region, page);
        return new ArrayList<>();
    }
//    public Blog findById(Integer id) {
//        return blogRepository.findById(id).orElseThrow(()->
//                new NotFoundException("Blog not found with id " + id));
//    }
}
