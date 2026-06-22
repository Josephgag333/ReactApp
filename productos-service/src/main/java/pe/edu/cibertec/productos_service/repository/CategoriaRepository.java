package pe.edu.cibertec.productos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.productos_service.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
