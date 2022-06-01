package com.app.ecommerce.entity;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product_category")
// @Data tiene un bug cuando hacemos relaciones de uno a muchos o de muchos a uno
// Entonces debemos usar en estos casos @Getter y @Setter
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private  String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
}

