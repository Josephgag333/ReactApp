package pe.edu.cibertec.productos_service.service;

import pe.edu.cibertec.productos_service.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    List<Categoria> listarCategorias();
    Categoria obtenerPorId(Long id);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    void eliminarCategoria(Long id);
}
