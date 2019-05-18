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
public interface LogicaI {
    
    public String tiempo(int i);
    public double puntuacion(double i);
    public boolean pregunta(int index);
    public void guardar();
    public boolean choque(int index);
    
}
