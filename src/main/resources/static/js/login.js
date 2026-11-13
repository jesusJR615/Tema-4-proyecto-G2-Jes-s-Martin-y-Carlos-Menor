// Esta página REST consulta la sesión compartida cuando se abre o se recarga.
// Si el empleado inició sesión desde Thymeleaf, entrará directamente en el Home REST.
async function comprobarSesion() {
    try {
        const respuesta = await fetch("/api/empleado/home", { credentials: "same-origin" });
        if (respuesta.ok) {
            window.location.replace("/html/empleadoHome.html");
        }
        // 401 es normal si todavía no ha iniciado sesión: mostramos el formulario.
    } catch (error) {
        document.getElementById("mensajeError").textContent = "No se pudo comprobar la sesión.";
    }
}

// Este formulario se procesa con fetch: no se envía al Controller MVC.
document.getElementById("formLogin").addEventListener("submit", async function (event) {
    event.preventDefault();
    const mensaje = document.getElementById("mensajeError");
    mensaje.textContent = "";
    const datos = new URLSearchParams(new FormData(event.currentTarget));
    try {
        const respuesta = await fetch("/api/login", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: datos,
            credentials: "same-origin"
        });
        const resultado = await respuesta.json();
        if (!respuesta.ok) {
            mensaje.textContent = (resultado.mensaje || "Error al iniciar sesión") +
                " (Código: " + (resultado.codigo || respuesta.status) + ")";
            return;
        }
        // La API crea HttpSession; el MVC reconocerá esta misma sesión.
        window.location.replace("/html/empleadoHome.html");
    } catch (error) {
        mensaje.textContent = "No se pudo conectar con el servidor.";
    }
});

comprobarSesion();
