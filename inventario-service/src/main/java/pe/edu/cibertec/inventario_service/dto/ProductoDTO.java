package pe.edu.cibertec.inventario_service.dto;
import lombok.Data;
import pe.edu.cibertec.inventario_service.model.Categoria;

@Data
public class ProductoDTO {
    private Long id_producto;
    private String nombre;
    private String marca;
    private Double precio;
    private int stock;
    private String descripcion;
    private Categoria id_categoria;
}