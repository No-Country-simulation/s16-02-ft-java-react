package com.pet.api_pet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_detail_id")
    private UUID orderdetailId = UUID.randomUUID();
    private Integer detailQuantity;
    private Double detailPrice;
    @OneToOne
    @JoinColumn(name = "order_order_id", nullable = false)
    private Order order;
}
