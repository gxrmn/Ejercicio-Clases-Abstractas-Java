package com.german.claseAbstractaPoo.form.validador;

public class LargoValidador extends Validador{

    protected String mensaje ="la cantidad minima de caracteres debe ser %d y la cantidad maxima de %d";
    private int min = 0;
    private int max = Integer.MAX_VALUE;

    public LargoValidador(){

    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        this.mensaje = String.format(this.mensaje, this.min, this.max);
        if(valor == null){
            return true;
        }
        else if(valor.length() >= min && valor.length() <= max){
            return true;
        }
        else {
            return false;
        }
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
