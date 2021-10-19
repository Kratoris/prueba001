/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.controlador;

import GestionUsuario.modelo.Usuario;
import GestionUsuario.vista.Listado;
import GestionUsuario.vista.Login_Usuario;
import GestionUsuario.vista.Registro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class ControlUsuario {

    //Atributos:
    Registro registro;
    Listado listado;
    Login_Usuario login;

    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    //Constructor:
    public ControlUsuario() {
    }

    //Metodos:
    public void registrarUsuario() {
        Usuario u = new Usuario();
        try {
            verificarVacio(registro.getIdentificacion());
            if (usuarios.isEmpty()) {
                u.setDocumento(Integer.parseInt(registro.getIdentificacion()));
                u.setNombre(registro.getNombres());
                u.setApellidos(registro.getApellidos());
                usuarios.add(u);
                registro.setMensaje("Usuario Registrado");
                registro.setIdentificacion("");
                registro.setNombres("");
                registro.setApellidos("");

            } else {
                for (int i = 0; i < 10; i++) {
                    if ((Integer.parseInt(registro.getIdentificacion())) == usuarios.get(i).getDocumento()) {
                        verificarDocumento();
                    }
                }
                u.setDocumento(Integer.parseInt(registro.getIdentificacion()));
                u.setNombre(registro.getNombres());
                u.setApellidos(registro.getApellidos());
                usuarios.add(u);
                registro.setMensaje("Usuario Registrado");
                registro.setIdentificacion("");
                registro.setNombres("");
                registro.setApellidos("");
            }

        } catch (DocumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (EmptyException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "En el documento solo se deben ingresar numeros.");
        }
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            String datos[] = {String.valueOf(u.getDocumento()), u.getNombre(), u.getApellidos()};
            listado.agregarFila(datos);
        }
    }

    public void iniciarSesion() {
        long id = Long.parseLong(login.getIdentificacion());
        String password = login.getContrasena();
        for (int i = 0; i < usuarios.size(); i++) {
            if (id == usuarios.get(i).getDocumento() && usuarios.get(i).getClave().equals(password)) {
                login.p.activador(true);
                login.setMensaje("Sesión Iniciada");
            } else {
                login.setMensaje("Fallo al iniciar sesión");
            }
        }
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Listado getListado() {
        return listado;
    }

    public void setListado(Listado listado) {
        this.listado = listado;
    }

    public Login_Usuario getLogin() {
        return login;
    }

    public void setLogin(Login_Usuario login) {
        this.login = login;
    }

    public void verificarDocumento() throws DocumentException {
        throw new DocumentException();
    }

    public void verificarVacio(String p) throws EmptyException {
        String texto = p.trim();
        if (texto.equals("")) {
            throw new EmptyException();
        }
    }
}
