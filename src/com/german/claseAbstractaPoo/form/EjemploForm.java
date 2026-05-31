package com.german.claseAbstractaPoo.form;

import com.german.claseAbstractaPoo.form.elementos.ElementoForm;
import com.german.claseAbstractaPoo.form.elementos.InputForm;
import com.german.claseAbstractaPoo.form.elementos.SelectForm;
import com.german.claseAbstractaPoo.form.elementos.TextAreaForm;
import com.german.claseAbstractaPoo.form.elementos.select.Opcion;

import java.util.ArrayList;
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
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2", "Python"))
        .addOpcion(new Opcion("3", "JavaScript"))
        .addOpcion(new Opcion("4", "TypeScript"))
        .addOpcion(new Opcion("5", "PHP"));

        username.setValor("jhone.doe");
        password.setValor("12345");
        email.setValor("jhoncoffe@email.com");
        edad.setValor("22");
        experiencia.setValor("... 1 año de experiencia en desarrollo backend con java ...");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username,password,email,edad,experiencia,lenguaje);

        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
    }
}
