package pe.edu.cibertec.inventario_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.inventario_service.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}