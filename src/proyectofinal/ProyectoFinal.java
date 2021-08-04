
package proyectofinal;

import Controlador.C_Login;
import Modelo.M_Login;
import Vista.V_Login;

/**
 *
 * @author pabli
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        V_Login vista = new V_Login();
        M_Login modelo = new M_Login();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        C_Login controlador = new C_Login(vista, modelo);
    }
    
}
