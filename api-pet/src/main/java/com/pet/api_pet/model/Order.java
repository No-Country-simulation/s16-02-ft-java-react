package com.pet.api_pet.model;

import com.pet.api_pet.model.enums.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId = UUID.randomUUID();
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_serial_code")
    private String orderSerialCode;
    private OrderState orderState;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_USER"))
    private User user;

}
