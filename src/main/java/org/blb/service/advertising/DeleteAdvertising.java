package org.blb.service.advertising;

import lombok.AllArgsConstructor;
import org.blb.exeption.NotFoundException;
import org.blb.models.advertising.Advertising;
import org.blb.repository.advertising.AdvertisingRepository;
import org.blb.service.util.AdvertisingConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteAdvertising {
    private final AdvertisingRepository advertisingRepository;


    public void deleteAdvertising(Long advertisingid) {
        Advertising advertising = advertisingRepository.findById(advertisingid)
                .orElseThrow(() ->new NotFoundException("Advertising not found"));
        advertisingRepository.delete(advertising);
    }
}
