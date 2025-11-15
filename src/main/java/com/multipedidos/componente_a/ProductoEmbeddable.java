package com.multipedidos.componentea.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEmbeddable {
    private String nombre;
    private double precio;
}
