package Clases;

/**
 *
 * @author LJA
 */
public class Usuario {

    String codigo, nombre, apellido, n_usuario, clave, tipo_usuario;

    public Usuario() {
        this.codigo = "";
        this.nombre = "";
        this.apellido = "";
        this.n_usuario = "";
        this.clave = "";
        this.tipo_usuario = "";
    }

    public void ing_Usuario(String cod, String n, String a, String nu, String c, String t_u) {
        this.codigo = cod;
        this.nombre = n;
        this.apellido = a;
        this.n_usuario = nu;
        this.clave = c;
        this.tipo_usuario = t_u;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(String n_usuario) {
        this.n_usuario = n_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

}
