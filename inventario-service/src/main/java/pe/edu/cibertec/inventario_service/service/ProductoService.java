package pe.edu.cibertec.inventario_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.inventario_service.model.Producto;
import pe.edu.cibertec.inventario_service.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id){
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
    public void deletePorId(Long id) {
        productoRepository.deleteById(id);
    }
}