package com.german.claseAbstractaPoo.form.elementos;
import com.german.claseAbstractaPoo.form.validador.Validador;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {

    protected String valor;
    protected String nombre;

    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm(){
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre){
        this();
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){
        this.validadores.add(validador);
        return this;
    }

    public boolean esValido(){
        for(Validador valido: validadores){
            if(!valido.esValido(this.valor)){
                this.errores.add(valido.getMensaje());
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();

    public void setValor(String valor){
        this.valor = valor;
    }

    public List<String> getErrores() {
        return errores;
    }

    public String getNombre() {
        return nombre;
    }
}
