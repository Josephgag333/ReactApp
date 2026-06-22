package pe.edu.cibertec.productos_service.service;

import pe.edu.cibertec.productos_service.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto crearProducto(Producto producto);
    List<Producto> listarProductos();
    Producto obtenerPorId(Long id);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}