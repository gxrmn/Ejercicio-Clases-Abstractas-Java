package com.german.claseAbstractaPoo.form;

import com.german.claseAbstractaPoo.form.elementos.*;
import com.german.claseAbstractaPoo.form.elementos.select.Opcion;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextAreaForm experiencia = new TextAreaForm("exp", 5,9);

        SelectForm lenguaje = new SelectForm("lenguaje");

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
        password.setValor("12345");
        email.setValor("jhoncoffe@email.com");
        edad.setValor("22");
        experiencia.setValor("... 1 año de experiencia en desarrollo backend con java ...");

        List<ElementoForm> elementos = Arrays.asList(username,password,email,edad,experiencia,lenguaje,saludar);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
    }
}
