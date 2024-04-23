# Administracion de Productos
## Description
El siguiente tiene como finalidad poder ser un CRUD para la administracion de Productos.
Junto al los metodos que generalmente se construyen se solicito la creacion de una nueva funcion, la cual tiene como finalidad obtener todos los productos que tengan el mismo "nombreProducto"

## Documentacion Swagger
`http://localhost:8080/swagger-ui.html`
## Endpoints
* `GET /producto/{id}`: Obtiene un producto por su ID.
* `GET /producto`: Obtiene una lista de todos los productos.
* `PUT /producto/{id}`: Actualiza un producto existente.
* `POST /producto`: Agrega un nuevo producto.
* `DELETE /producto/{id}`: Elimina un producto por su ID.
* `POST /producto/BuscarProducto`: Busca productos por su nombre.

## Descripción de los Endpoints
###  1.- Obtener Producto por ID
* Método: `GET`
* Ruta: `/producto/{id}`
* Parámetros de ruta:
  * `id`: ID del producto a obtener.
* Descripción: Obtiene un producto por su ID.
### 2.- Obtener Lista de Productos
* Método: `GET`
* Ruta: `/producto`
* Descripción: Obtiene una lista de todos los productos.
### 3.- Actualizar Producto
* Método:` PUT`
* Ruta: `/producto/{id}`
* Parámetros de ruta:
  * `id`: ID del producto a actualizar.
  * Body Ejemplo: `{
    "nombreProducto": "string",
    "precio": int }`
* Descripción: Actualiza un producto existente.
### 4.- Agregar Producto
* Método: `POST`
* Ruta: `/producto`
* * Body Ejemplo: `{
    "nombreProducto": "string",
    "precio": int }`
* Descripción: Agrega un nuevo producto.
### 5.- Eliminar Producto
* Método: `DELETE`
* Ruta: `/producto/{id}`
* Parámetros de ruta:
  * `id`: ID del producto a eliminar.
* Descripción: Elimina un producto por su ID.
### 6.- Buscar Producto por Nombre
* Método: `POST`
* Ruta: `/producto/BuscarProducto`
* Body Ejemplo: `{"nombreProducto": "string"}`
* Descripción: Busca productos por su nombre.


## Scripts SQL
* `import.sql`: Este archivo contiene las consultas SQL para insertar datos iniciales en la base de datos. Asegúrese de que este archivo esté en la raíz del classpath de la aplicación.
* `schema.sql`: Este archivo contiene las consultas SQL para crear la estructura de la tabla de productos en la base de datos. Asegúrese de que este archivo esté en la raíz del classpath de la aplicación.