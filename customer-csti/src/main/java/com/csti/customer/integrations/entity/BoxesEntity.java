package com.csti.customer.integrations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "boxes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoxesEntity {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private String productType;
    private String plate;
}
