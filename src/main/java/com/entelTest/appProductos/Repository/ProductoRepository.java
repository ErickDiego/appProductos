package com.entelTest.appProductos.Repository;

import com.entelTest.appProductos.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    /**
     * @param nombreProducto
     * @return Listado de Productos encontrados
     */
    List<Producto> findAllByNombreProducto(String nombreProducto);

}
