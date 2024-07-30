package org.blb.DTO.advertisingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalResponseDto {
//    private Long id;
//    private String title;
//    private String description;
//    private String advertiserName;
//    private String advertiserEmail;
//    private String advertiserPhone;
    private String discount;
    private String  descriptionOfTheCoupon;
    private LocalDate currentDate;
}
