import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../api/auth";
import { validateToken } from "../api/validate";

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

const handleLogin = async (e) => {
  e.preventDefault();
  try {
    const data = await login(username, password);
    const token = data.token;

    // Guardar token
    localStorage.setItem("token", token);
    setMessage("Inicio de sesión exitoso ✅");

    // Validar token contra el backend
    const validation = await validateToken(token);
    console.log("Validación:", validation);

    if (validation && validation.valid) {
      // Guardar username
      localStorage.setItem("username", validation.username);
        localStorage.setItem("role", validation.role); // 👈 ESTA LÍNEA FALTABA

      // Redirigir según rol
      if (validation.role === "ROLE_ADMIN") {
        navigate("/admin");
      } else if (validation.role === "ROLE_USER") {
        navigate("/user");
      } else {
        setMessage("Rol desconocido ❌");
      }
    } else {
      setMessage("Token inválido o expirado ❌");
    }
  } catch (error) {
    setMessage("Error en las credenciales ❌");
  }
};

  return (
    <div style={{ display: "flex", justifyContent: "center", marginTop: "100px" }}>
      <form onSubmit={handleLogin} style={{ display: "flex", flexDirection: "column", width: "300px" }}>
        <h2>Iniciar Sesión</h2>
        <input
          type="text"
          placeholder="Usuario"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Entrar</button>
        <p>{message}</p>
      </form>
    </div>
  );
}
