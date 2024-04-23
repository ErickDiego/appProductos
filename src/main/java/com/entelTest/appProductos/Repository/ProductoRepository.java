package com.entelTest.appProductos.Repository;

import com.entelTest.appProductos.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
