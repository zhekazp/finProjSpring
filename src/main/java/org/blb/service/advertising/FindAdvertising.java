package org.blb.service.advertising;

import lombok.AllArgsConstructor;
import org.blb.DTO.advertisingDto.AdvertisingResponseDto;
import org.blb.exeption.NotFoundException;
import org.blb.models.advertising.Advertising;
import org.blb.repository.advertising.AdvertisingRepository;
import org.blb.service.util.AdvertisingConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindAdvertising {
    private final AdvertisingRepository advertisingRepository;
    private final AdvertisingConverter advertisingConverter;

    public AdvertisingResponseDto findByAdvertiserEmail(String email) {
        Optional<Advertising> optionalAdvertising = advertisingRepository.findByAdvertiserEmail(email);
        if (optionalAdvertising.isPresent()) {
            return advertisingConverter.fromEntityToDto(optionalAdvertising.get());
        }else {
            throw new  NotFoundException("Advertising not found");
        }
    }

    public List<AdvertisingResponseDto> findAll() {

        List<Advertising> advertisings = advertisingRepository.findAll();
        List<AdvertisingResponseDto> advertisingResponseDtos = new ArrayList<>();
        for (Advertising advertising : advertisings) {
            advertisingResponseDtos.add(advertisingConverter.fromEntityToDto(advertising));
        }
        return advertisingResponseDtos;
    }
}
