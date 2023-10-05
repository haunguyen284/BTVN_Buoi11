package com.nguyenth.btvn_buoi11.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @NotBlank(message = "Không được trống")
    @Column(name = "product_code")
    private String productCode;

    @NotBlank(message = "Không được trống")
    @Column(name = "product_name")
    @Nationalized
    private String productName;

    @Min(value = 1, message = "Giá trị lớn hơn 0")
    @Column(name = "price")
    private int price;

    @Column(name = "description")
    @NotBlank(message = "Không được trống")
    @Nationalized
    private String description;
}
