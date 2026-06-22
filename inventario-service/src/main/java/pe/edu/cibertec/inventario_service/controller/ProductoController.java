package pe.edu.cibertec.inventario_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.inventario_service.model.Producto;
import pe.edu.cibertec.inventario_service.service.ProductoService;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService pS;

    @GetMapping
    public List<Producto> listar() {
        return pS.findAll();
    }
}
