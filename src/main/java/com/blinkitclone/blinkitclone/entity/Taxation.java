package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "taxation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Taxation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer categoryId;

    Integer TaxPercentage;

    LocalDate createdDate;

    LocalDate updatedDate;
    DeletionStatus deletionStatus;
}
