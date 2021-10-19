/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.controlador;

/**
 *
 * @author Frank E. Gil M.
 */
public class DocumentException extends Exception {

    DocumentException() {
        super("Documento repetido.");
    }
}
