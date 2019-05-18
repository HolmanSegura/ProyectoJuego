/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Acer
 */
public class Pregunta {

    String respuesta, pregunta, opcionesR;

    public Pregunta(String pregunta, String opcionesR, String respuesta) {
        this.respuesta = respuesta;
        this.pregunta = pregunta;
        this.opcionesR = opcionesR;
    }

    public String getOpcionesR() {
        return opcionesR;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpcionesR(String opcionesR) {
        this.opcionesR = opcionesR;
    }

    public String getPregunta() {
        return pregunta;
    }

}
