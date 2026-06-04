<!-- Encabezado Principal -->
<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9+-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/Jetpack_Compose-334D5C?style=for-the-badge&logo=jetpackcompose&logoColor=61D9FA" alt="Compose">
  <img src="https://img.shields.io/badge/Room_Database-211F1F?style=for-the-badge&logo=sqlite&logoColor=003B57" alt="Room">
  <img src="https://img.shields.io/badge/Architecture-MVVM-green?style=for-the-badge" alt="MVVM">
</p>

<h1 align="center">📦 InventarioManager</h1>

<p align="center">
  <strong>Aplicación móvil nativa para la administración y control de flujos de equipos tecnológicos en laboratorios de informática.</strong>
</p>

<p align="center">
  Desarrollada en Kotlin, utilizando metodologías modernas de diseño declarativo y persistencia de datos local robusta.
</p>

---

## ✨ Características

<table>
  <tr>
    <td>🔐 <b>Acceso Seguro</b>: Inicio de sesión restrictivo para administradores.</td>
    <td>💻 <b>Control de Inventario</b>: Registro y administración completa de equipos.</td>
  </tr>
  <tr>
    <td>✏️ <b>Gestión CRUD</b>: Edición rápida y eliminación de registros obsoletos.</td>
    <td>📋 <b>Consulta Ágil</b>: Buscador optimizado para la consulta de equipos.</td>
  </tr>
  <tr>
    <td>📦 <b>Préstamos y Devoluciones</b>: Control y registro exacto del flujo de equipos.</td>
    <td>📖 <b>Trazabilidad Histórica</b>: Bitácora de movimientos detallada por fecha.</td>
  </tr>
  <tr>
    <td>📊 <b>Métricas de Control</b>: Dashboard intuitivo con estadísticas generales en tiempo real.</td>
    <td>💾 <b>Seguridad de Datos</b>: Almacenamiento local persistente implementado con Room Database.</td>
  </tr>
</table>

---

## 🏗️ Arquitectura y Patrón de Diseño

La aplicación se rige bajo la arquitectura **MVVM (Model-View-ViewModel)** y buenas prácticas de desarrollo en Android:
* <b>Separación de Capas:</b> Desacoplamiento total entre la lógica de negocio y los componentes visuales.
* <b>Reactividad Eficiente:</b> Implementación de flujos de datos asíncronos mediante `StateFlow` y control de concurrencia con `Coroutines`.
* <b>Navegación Fluida:</b> Rutas centralizadas y seguras utilizando `Navigation Compose`.
* <b>Diseño Moderno:</b> UI responsiva construida enteramente sobre los estándares de **Material Design 3**.

---

## 🚀 Guía de Funcionamiento

1. <b>Autenticación:</b> El administrador ingresa sus credenciales en la interfaz de seguridad.
2. <b>Panel Central:</b> Se accede al *Dashboard* donde se consolida el estado global de los recursos informáticos.
3. <b>Módulo Operativo:</b> Desde las diferentes secciones, es posible ingresar nuevos equipos, editar metadatos o asignar préstamos a solicitantes.
4. <b>Cierre de Ciclo:</b> Las devoluciones se procesan y validan directamente desde la interfaz del Historial.
5. <b>Persistencia Local:</b> Cada transacción o modificación se procesa atómicamente en la base de datos SQLite integrada.

---

## 📸 Galería de la Aplicación (Capturas de Pantalla)

<p align="center">
  <i>Diseño de interfaz optimizado para dispositivos móviles en modo claro con paletas corporativas.</i>
</p>

<table align="center">
  <tr>
    <td align="center" width="33%">
      <b>🔑 Inicio de Sesión</b><br><br>
      <img src="captura/Screenshot%202026-06-04%20140716.png" width="230" alt="Login">
    </td>
    <td align="center" width="33%">
      <b>📊 Dashboard Principal</b><br><br>
      <img src="captura/Screenshot%202026-06-04%20140741.png" width="230" alt="Dashboard">
    </td>
    <td align="center" width="33%">
      <b>💻 Gestión de Equipos</b><br><br>
      <img src="captura/Screenshot%202026-06-04%20140802.png" width="230" alt="Inventario">
    </td>
  </tr>
  <tr>
    <td align="center" width="33%">
      <br><b>📦 Historial</b><br><br>
      <img src="captura/Screenshot%202026-06-04%20140842.png" width="230" alt="Historial">
    </td>
    <td align="center" width="33%">
      <br><b>📈 Reportes</b><br><br>
      <img src="captura/Screenshot%202026-06-04%20140905.png" width="230" alt="Reportes">
    </td>
    <td align="center" width="33%">
      </td>
  </tr>
</table>

---

## 👨‍💻 Detalles del Autor

<table align="center" width="100%">
  <tr>
    <td align="center" padding="10">
      <b>Allan Raúl Valentín Acuña Otero</b><br>
      🚀 <i>Estudiante de Ingeniería en Sistemas</i><br>
      🏛️ Universidad Americana (UAM)
    </td>
  </tr>
</table>
