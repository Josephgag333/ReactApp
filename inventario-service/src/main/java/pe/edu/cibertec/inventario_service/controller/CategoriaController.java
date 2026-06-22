package pe.edu.cibertec.inventario_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.inventario_service.model.Categoria;
import pe.edu.cibertec.inventario_service.service.CategoriaService;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService cS;

    @GetMapping
    public List<Categoria> listar() {
        return cS.findAll();
    }

}