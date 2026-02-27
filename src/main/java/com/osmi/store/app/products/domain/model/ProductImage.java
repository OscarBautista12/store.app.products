package com.osmi.store.app.products.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage extends BaseEntity {

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private String url;

    @Column(name="is_main", nullable = false)
    private Boolean mainImage;

    private Integer orderIndex;
}