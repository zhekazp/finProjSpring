package org.blb.service.blog;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogsRequestDTO;
import org.blb.DTO.blog.blogs.BlogResponseDTO;
import org.blb.DTO.blog.blogs.BlogsResponseDTO;
import org.blb.DTO.blog.blogs.ContentResponseDTO;
import org.blb.exeption.NotFoundException;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.blb.repository.blog.BlogFindRepository;
import org.blb.repository.blog.BlogRepository;
import org.blb.service.region.FindRegionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogFindService {


    private final BlogFindRepository blogFindRepository;
    private final FindRegionService findRegionService;
    private final BlogRepository blogRepository;
    public BlogsResponseDTO findAll(BlogsRequestDTO dto) {
        Pageable page = PageRequest.of(dto.getPageNumber(), 10);
        Page<BlogResponseDTO> blogs;
        if (dto.getRegion_ID() != 0) {
            Region region = findRegionService.getRegionById(dto.getRegion_ID());
            blogs = blogFindRepository.findDTOByRegion(region, page);
        } else {
            blogs = blogFindRepository.findAllByOrderByIdDesc(page);
        }
        BlogsResponseDTO response = new BlogsResponseDTO(blogs.getTotalPages(), dto.getPageNumber(),
                blogs.getContent());

        return response;
    }

    public ContentResponseDTO findById(Long id) {
        return blogRepository.findBlogById(id).orElseThrow(() ->
                new NotFoundException("Blog with id " + id +" not found" ));
    }
}
