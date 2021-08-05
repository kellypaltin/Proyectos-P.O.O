/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author kellypaltin
 */
public class ValidadorCedula extends Exception{
    public final static String mensaje = "Cedula incorrecta";
    
    public ValidadorCedula(){
        super(mensaje);
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

}
