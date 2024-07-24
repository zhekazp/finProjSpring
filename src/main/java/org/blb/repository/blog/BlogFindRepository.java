package org.blb.repository.blog;

import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BlogFindRepository extends PagingAndSortingRepository<Blog, Long> {

    Page<Blog> findAllByRegion(Region region, Pageable pageable);
}
