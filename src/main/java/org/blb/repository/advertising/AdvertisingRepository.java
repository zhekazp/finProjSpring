package org.blb.repository.advertising;

import org.blb.models.advertising.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisingRepository extends JpaRepository<Advertising,Long> {
    Optional<Advertising>findByAdvertiserEmail(String email);


    @Query(value = "SELECT * FROM blb ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Advertising> findRandomAdvertisements();
}


