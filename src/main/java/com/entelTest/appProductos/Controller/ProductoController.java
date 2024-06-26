package com.entelTest.appProductos.Controller;

import com.entelTest.appProductos.Entity.Producto;
import com.entelTest.appProductos.Entity.ProductoRequest;
import com.entelTest.appProductos.Entity.ProductoResponse;
import com.entelTest.appProductos.Repository.ProductoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository _productoRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this._productoRepository = productoRepository;
    }

    @Tag(name = "Producto")
    @GetMapping("/{id}")
    public ResponseEntity obtenerProducto(@PathVariable int id){
        Optional<Producto> producto = _productoRepository.findById(id);

        if(producto.isPresent()){
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Tag(name = "Producto")
    @GetMapping("")
    public List<Producto> listaProductos(){
        List<Producto> lista = new ArrayList<>();

        lista = _productoRepository.findAll();

        return lista;
    }

    @Tag(name = "Producto")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable int id, @RequestBody Producto productoInput){
        Optional<Producto> optionalProducto = _productoRepository.findById(id);

        if(optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            producto.setNombreProducto(productoInput.getNombreProducto());
            producto.setPrecio(productoInput.getPrecio());

            Producto save = _productoRepository.save(producto);

            return new ResponseEntity<>(save, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Tag(name = "Producto")
    @PostMapping("")
    public Producto addProducto(@RequestBody Producto producto){

        return _productoRepository.save(producto);

    }

    @Tag(name = "Producto")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id){
        _productoRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Tag(name = "Producto")
    @PostMapping("/BuscarProducto")
    public  ResponseEntity<?> obtenerProductoPorNombre(@RequestBody ProductoRequest productoRequest){
        ProductoResponse response = new ProductoResponse();
        List<Producto> listaProducto = _productoRepository.findAllByNombreProducto(productoRequest.getNombreProducto());

        if (!listaProducto.isEmpty()){
            response.setListaProducto(listaProducto);
            response.setMensaje("Se ha encontrado Producto: " + productoRequest.getNombreProducto() +
                    " Cantidad: " + listaProducto.size());
            response.setCodStatus(200);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            response.setListaProducto(listaProducto);
            response.setMensaje("Producto No encontrado");
            response.setCodStatus(404);
            return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @Tag(name = "Producto")
    @PostMapping("/BuscarProductoIgnoreCase")
    public  ResponseEntity<?> obtenerProductoPorNombreIgnoreCase(@RequestBody ProductoRequest productoRequest){
        ProductoResponse response = new ProductoResponse();
        List<Producto> listaProducto = _productoRepository.findByNombreProductoIgnoreCase(productoRequest.getNombreProducto());

        if (!listaProducto.isEmpty()){
            response.setListaProducto(listaProducto);
            response.setMensaje("Se ha encontrado Producto: " + productoRequest.getNombreProducto() +
                    " Cantidad: " + listaProducto.size());
            response.setCodStatus(200);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            response.setListaProducto(listaProducto);
            response.setMensaje("Producto No encontrado");
            response.setCodStatus(404);
            return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
}
