package com.entelTest.appProductos.Entity;

import jakarta.persistence.*;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;
import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = READ_ONLY) //Evitara que se envie en el body el ID, evita actualizacion en el guardado con el mismo ID
    private int id;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    private int precio;

}
