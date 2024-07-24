package org.blb.service.util;

import org.blb.DTO.advertisingDto.AdvertisingRequestDto;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.blb.models.advertising.Advertising;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingConverter {
    public Advertising fromDtoToEntity(AdvertisingRequestDto advertisingRequestDto) {
        Advertising advertising = new Advertising();
        if (advertisingRequestDto.getTitle() != null) {
            advertising.setTitle(advertisingRequestDto.getTitle());
        }

        if (advertisingRequestDto.getDescription() != null) {
            advertising.setDescription(advertisingRequestDto.getDescription());
        }

        if (advertisingRequestDto.getAdvertiserName() != null) {
            advertising.setAdvertiserName(advertisingRequestDto.getAdvertiserName());
        }
        if (advertisingRequestDto.getAdvertiserEmail() != null) {
            advertising.setAdvertiserEmail(advertisingRequestDto.getAdvertiserEmail());
        }
        if (advertisingRequestDto.getAdvertiserPhone() != null) {
            advertising.setAdvertiserPhone(advertisingRequestDto.getAdvertiserPhone());

        }
        if (advertisingRequestDto.getDiscount() != null) {
            advertising.setDiscount(advertisingRequestDto.getDiscount());
        }
        if (advertisingRequestDto.getCreateData() != null) {
            advertising.setCreateData(advertisingRequestDto.getCreateData());
        }

        return advertising;

    }

    public AdvertisingResponseDto fromEntityToDto(Advertising advertising) {
        return new AdvertisingResponseDto(
                advertising.getId(),
                advertising.getTitle(),
                advertising.getDescription(),
                advertising.getAdvertiserName(),
                advertising.getAdvertiserEmail(),
                advertising.getAdvertiserPhone(),
                advertising.getDiscount(),
                advertising.getCreateData(),
                advertising.getEndData()
        );


    }
}