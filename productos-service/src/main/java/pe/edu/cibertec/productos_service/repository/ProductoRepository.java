package pe.edu.cibertec.productos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.productos_service.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}