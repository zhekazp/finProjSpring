package org.blb.models.advertising;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blb.models.giftСoupon.Coupon;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String advertiserName;
    private String advertiserEmail;
    private String advertiserPhone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="coupon_id")
    private List<Coupon> coupons;
}
