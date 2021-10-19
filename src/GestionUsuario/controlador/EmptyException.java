/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.controlador;

/**
 *
 * @author User
 */
public class EmptyException extends Exception {

    //Metodo:
    public EmptyException() {
        super("Campos vacios");
    }
}
