package pe.edu.cibertec.inventario_service.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "imagen_url", nullable = false, length = 255)
    private String imagen_url;
    @JoinColumn(name = "id_categoria")
    @ManyToOne
    private Categoria id_categoria;
}