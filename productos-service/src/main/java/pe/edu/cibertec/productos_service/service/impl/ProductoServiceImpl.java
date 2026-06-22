package pe.edu.cibertec.productos_service.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.productos_service.model.Producto;
import pe.edu.cibertec.productos_service.repository.ProductoRepository;
import pe.edu.cibertec.productos_service.service.ProductoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(producto.getNombre());
        existente.setMarca(producto.getMarca());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setDescripcion(producto.getDescripcion());
        existente.setUrlImagenPrincipal(producto.getUrlImagenPrincipal());
        existente.setCategoria(producto.getCategoria());
        return productoRepository.save(existente);
    }


    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}