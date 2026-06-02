package com.german.claseAbstractaPoo.form;

import com.german.claseAbstractaPoo.form.elementos.*;
import com.german.claseAbstractaPoo.form.elementos.select.Opcion;
import com.german.claseAbstractaPoo.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());
        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));
        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());
        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNulo());

        lenguaje.addOpcion(new Opcion("1", "Java"))
        .addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JavaScript").setSelected())
        .addOpcion(new Opcion("4", "TypeScript"))
        .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\">";
            }
        };
        saludar.setValor("Hola que tal este campo esta deshabilitado!");
        username.setValor("jhone.doe");
        password.setValor("12346");
        email.setValor("jhoncoffe@email.com");
        edad.setValor("22");
        experiencia.setValor("... 1 año de experiencia en desarrollo backend con java ...");

        List<ElementoForm> elementos = Arrays.asList(username,password,email,edad,experiencia,lenguaje,saludar);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }

        elementos.forEach(e ->{
            if(!e.esValido()){
                e.getErrores().forEach(err -> System.out.println(e.getNombre() + ": " + err));
            }
        });
    }
}
