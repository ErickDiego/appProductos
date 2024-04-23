package com.entelTest.appProductos.Entity;

import lombok.Data;

import java.util.List;

@Data
public class ProductoResponse {
    private int codStatus;
    private String mensaje;
    private List<Producto> listaProducto;
}
