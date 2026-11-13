// El HTML estático no tiene datos precargados: solicita el empleado a la API.
async function cargarEmpleado() {
    const mensaje = document.getElementById("mensajeError");
    try {
        const respuesta = await fetch("/api/empleado/home", { credentials: "same-origin" });
        if (respuesta.status === 401) {
            // Si no hay sesión, vuelve al login REST.
            window.location.replace("/html/login.html");
            return;
        }
        const datos = await respuesta.json();
        if (!respuesta.ok) {
            mensaje.textContent = datos.mensaje || "Error al cargar el empleado.";
            return;
        }
        // textContent evita interpretar HTML en los valores recibidos.
        for (const campo of ["id", "nombre", "login", "turno", "nivel"]) {
            document.getElementById(campo).textContent = datos[campo] ?? "";
        }
        const extra = document.getElementById("datoExtra");
        extra.hidden = true;
        if (datos.turno === "diurno") {
            extra.textContent = "Retención: " + datos.retencion;
            extra.hidden = false;
        } else if (datos.turno === "nocturno") {
            extra.textContent = "Plus productividad: " + datos.plusProductividad;
            extra.hidden = false;
        }
        document.getElementById("home-container").hidden = false;
    } catch (error) {
        mensaje.textContent = "No se pudo conectar con el servidor.";
    }
}

// El logout REST invalida la MISMA sesión que está usando Thymeleaf.
document.getElementById("cerrarSesion").addEventListener("click", async function (event) {
    event.preventDefault();
    try {
        const respuesta = await fetch("/api/empleado/logout", { credentials: "same-origin" });
        if (respuesta.ok || respuesta.status === 401) {
            window.location.replace("/html/login.html");
        } else {
            document.getElementById("mensajeError").textContent = "No se pudo cerrar la sesión.";
        }
    } catch (error) {
        document.getElementById("mensajeError").textContent = "No se pudo conectar con el servidor.";
    }
});

cargarEmpleado();
