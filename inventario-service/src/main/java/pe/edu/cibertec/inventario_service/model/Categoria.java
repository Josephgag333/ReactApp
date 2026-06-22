package pe.edu.cibertec.inventario_service.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
}