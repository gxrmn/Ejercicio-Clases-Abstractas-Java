package com.german.claseAbstractaPoo.form.validador;

public abstract class Validador {
    protected String mensaje;
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public boolean esValido(String valor);
}
