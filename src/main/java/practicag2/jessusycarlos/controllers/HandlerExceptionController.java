package practicag2.jessusycarlos.controllers;

import practicag2.jessusycarlos.models.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

import practicag2.jessusycarlos.exceptiones.ContraseñaIncorrectaException;
import practicag2.jessusycarlos.exceptiones.CredencialesInvalidasException;
import practicag2.jessusycarlos.exceptiones.LoginIncorrectoException;
import practicag2.jessusycarlos.exceptiones.SessionNoIniciadaException;
import practicag2.jessusycarlos.exceptiones.UsuarioNotFoundException;

@RestControllerAdvice(assignableTypes = { EmpleadoController.class, EmpleadoRestControlller.class})
public class HandlerExceptionController {

    // CredencialesInvalidasException (401)
    @ExceptionHandler(CredencialesInvalidasException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error handleCredencialesInvalidas(CredencialesInvalidasException ex) {
        return new Error(ex.getMessage(), "Error de autenticación -> Las credenciales son incorrectas.",
                HttpStatus.UNAUTHORIZED.value(), new Date());
    }

    // SesionNoIniciada (401)
    @ExceptionHandler(SessionNoIniciadaException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error handleSesionNoIniciada(SessionNoIniciadaException ex) {
        return new Error(ex.getMessage(), "El usuario no está autorizado",
                HttpStatus.UNAUTHORIZED.value(), new Date());
    }

    // UsuarioNotFound (404)
    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleUsuarioNoEncontrado(UsuarioNotFoundException ex) {
        return new Error(ex.getMessage(), "El usuario no existe",
                HttpStatus.NOT_FOUND.value(), new Date());
    }

    // NullPointerException (500)
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleNullPointerException(UsuarioNotFoundException ex) {
        return new Error(ex.getMessage(), "El servidor está fura de servicio.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }

    // ContraseñaIncorrectaException (222)
    @ExceptionHandler(ContraseñaIncorrectaException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error handleContraseñaIncorrectaException(ContraseñaIncorrectaException ex) {
        return new Error(ex.getMessage(), "Error. Contraseña incorrecta", 222,
                new Date());
    }

    // LoginIncorrectoException (111)
    @ExceptionHandler(LoginIncorrectoException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Error handleLoginIncorrecto(LoginIncorrectoException ex) {
        return new Error(ex.getMessage(), "Error. Inicio de sesión incorrecto", 111,
                new Date());
    }
}
