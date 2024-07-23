package org.blb.DTO.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.blb.models.region.Region;
import org.blb.models.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "Blog Response", description = "Return inserted blog id")
@Builder
public class BlogResponseDTO {
    @Schema(description = "message", example = "blog added successfully")
    private String message;
    @Schema(description = "Blog id", example = "7")
    private Long id;
}

