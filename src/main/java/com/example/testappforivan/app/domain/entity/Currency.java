package com.example.testappforivan.app.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="номер")
    private Integer id; //айдишник

    @Size(min=3,max=3)
    @NotBlank
    private String index; //название валюты: RUB or USD or EUR

    @Column(name="купить за")
    @NotNull
    private BigDecimal purchase; //купля банка у людей

    @Column(name="продать за")
    @NotNull
    private BigDecimal sale; //продажа людям

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="курс добавлен в",nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="курс обновлен в",nullable = true)
    private LocalDateTime updatedAt;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="курс удален в",nullable = true)
    private LocalDateTime deletedAt;


}
