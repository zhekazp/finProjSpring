package org.blb.repository.blog;

import org.blb.DTO.blog.blogs.BlogResponseDTO;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

public interface BlogFindRepository extends PagingAndSortingRepository<Blog, Long> {

    Page<BlogResponseDTO> findDTOByRegion(Region region, Pageable pageable);
    Page<Blog> findAllByRegion(Region region, Pageable pageable);
 }
