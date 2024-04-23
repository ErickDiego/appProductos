package com.entelTest.appProductos.Controller;

import com.entelTest.appProductos.Entity.Producto;
import com.entelTest.appProductos.Entity.ProductoRequest;
import com.entelTest.appProductos.Entity.ProductoResponse;
import com.entelTest.appProductos.Repository.ProductoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductoControllerTest {

    @Test
    void obtenerProductoPorNombreIgnoreCase() {
        // Mock de ProductoRepository
        ProductoRepository productoRepository = mock(ProductoRepository.class);

        // Datos de prueba
        String nombreProducto = "producto1";
        Producto producto1 = new Producto(1, "Producto1", 100);
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(producto1);

        // Simular el comportamiento de findByNombreProductoIgnoreCase
        when(productoRepository.findByNombreProductoIgnoreCase(nombreProducto)).thenReturn(listaProductos);

        // Crear instancia del controlador y llamar al método a probar
        ProductoController controller = new ProductoController(productoRepository);
        ProductoRequest request = new ProductoRequest();
        request.setNombreProducto(nombreProducto);
        ResponseEntity<?> responseEntity = controller.obtenerProductoPorNombreIgnoreCase(request);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ProductoResponse response = (ProductoResponse) responseEntity.getBody();
        assertEquals(1, response.getListaProducto().size());
        assertEquals("Se ha encontrado Producto: producto1 Cantidad: 1", response.getMensaje());
        assertEquals(200, response.getCodStatus());
    }

    @Test
    void obtenerProductoPorNombreIgnoreCase_ProductoNoEncontrado() {
        // Mock de ProductoRepository
        ProductoRepository productoRepository = mock(ProductoRepository.class);

        // Datos de prueba
        String nombreProducto = "producto1";

        // Simular el comportamiento de findByNombreProductoIgnoreCase
        when(productoRepository.findByNombreProductoIgnoreCase(nombreProducto)).thenReturn(new ArrayList<>());

        // Crear instancia del controlador y llamar al método a probar
        ProductoController controller = new ProductoController(productoRepository);
        ProductoRequest request = new ProductoRequest();
        request.setNombreProducto(nombreProducto);
        ResponseEntity<?> responseEntity = controller.obtenerProductoPorNombreIgnoreCase(request);

        // Verificar el resultado
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        ProductoResponse response = (ProductoResponse) responseEntity.getBody();
        assertEquals("Producto No encontrado", response.getMensaje());
        assertEquals(404, response.getCodStatus());
    }
}