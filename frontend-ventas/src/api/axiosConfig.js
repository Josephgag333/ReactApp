import axios from "axios";
import { createBrowserHistory } from "history";

// base por gateway
const API_GATEWAY = "http://localhost:8080";

export const history = createBrowserHistory();

const api = axios.create({
  baseURL: API_GATEWAY,
});

// Interceptor para enviar Authorization automáticamente
api.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
}, (error) => Promise.reject(error));

// Interceptor para manejar 401: limpiar y redirigir al login
api.interceptors.response.use(
  (res) => res,
  (err) => {
    if (err.response && err.response.status === 401) {
      localStorage.removeItem("token");
      localStorage.removeItem("username");
      localStorage.removeItem("role");
      // redirigir al login simple:
      window.location.href = "/";
    }
    return Promise.reject(err);
  }
);

export default api;
