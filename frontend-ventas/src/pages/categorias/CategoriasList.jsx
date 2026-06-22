import React, { useEffect, useState } from "react";
import { listarCategorias, eliminarCategoria } from "../../api/categorias";

export default function CategoriasList({ onEdit }) {
  const [cats, setCats] = useState([]);
  const role = localStorage.getItem("role");

  useEffect(() => {
    (async () => {
      try {
        const data = await listarCategorias();
        setCats(data);
      } catch (e) {
        console.error(e);
      }
    })();
  }, []);

  const handleDelete = async (id) => {
    if (!window.confirm("Eliminar categoría?")) return;
    try {
      await eliminarCategoria(id);
      setCats(prev => prev.filter(c => c.idCategoria !== id));
    } catch (e) { alert("No se pudo eliminar"); }
  };

  return (
    <div>
      <h2>Categorías</h2>
      {role === "ROLE_ADMIN" && <button onClick={() => onEdit(null)}>➕ Crear categoría</button>}
      <ul>
        {cats.map(c => (
          <li key={c.idCategoria}>
            <strong>{c.nombre}</strong> - {c.descripcion}
            {role === "ROLE_ADMIN" && (
              <>
                <button onClick={() => onEdit(c)}>✏️</button>
                <button onClick={() => handleDelete(c.idCategoria)}>🗑️</button>
              </>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}
