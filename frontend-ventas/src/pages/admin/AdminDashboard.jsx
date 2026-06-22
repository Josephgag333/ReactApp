import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import ProductosPage from "../productos/index";
import CategoriasPage from "../categorias/CategoriasPage";

export default function AdminDashboard() {
  return (
    <div style={{ display: "flex" }}>
      {/* Sidebar */}
      <aside style={{ width: "200px", padding: 20, borderRight: "1px solid #ddd" }}>
        <h3>Panel Admin</h3>
        <nav style={{ display: "flex", flexDirection: "column", gap: 8 }}>
          <Link to="productos">🛒 Productos</Link>
          <Link to="categorias">📂 Categorías</Link>
        </nav>
      </aside>

      {/* Contenido principal */}
      <main style={{ flex: 1, padding: 20 }}>
        <Routes>
          <Route path="productos" element={<ProductosPage />} />
          <Route path="categorias" element={<CategoriasPage />} />
          <Route path="*" element={<p>Selecciona una opción del menú</p>} />
        </Routes>
      </main>
    </div>
  );
}
