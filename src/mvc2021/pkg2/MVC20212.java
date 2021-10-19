/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc2021.pkg2;

import GestionUsuario.controlador.ControlUsuario;
import GestionUsuario.modelo.Usuario;

/**
 *
 * @author Jose Luis
 */
public class MVC20212 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Principal p = new Principal();
        p.setVisible(true);
        Usuario u = new Usuario();
        u.setDocumento(123456L);
        u.setNombre("Jose");
        u.setApellidos("lopez");
        u.setClave("0000");
  
        ControlUsuario.usuarios.add(u);
    }
    
}
