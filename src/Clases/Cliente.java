/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author vale_
 */
public class Cliente extends Persona {

    int codigo;
    String contacto, email2, tip_pers, vend, ciudad, provincia, cod_post, pais, iva, categoria, cliente_ac;

    public Cliente() {
        this.codigo = 0;
        this.contacto = "";
        this.email2 = "";
        this.tip_pers = "";
        this.vend = "";
        this.ciudad = "";
        this.provincia = "";
        this.cod_post = "";
        this.pais = "";
        this.iva = "";
        this.categoria = "";
        this.cliente_ac = "";
    }

    public Cliente(int codigo, String contacto, String email2, String tip_pers, String vend,
            String ciudad, String provincia, String cod_post, String pais, String iva,
            String categoria, String cliente_ac) {
        this.codigo = codigo;
        this.contacto = contacto;
        this.email2 = email2;
        this.tip_pers = tip_pers;
        this.vend = vend;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.cod_post = cod_post;
        this.pais = pais;
        this.iva = iva;
        this.categoria = categoria;
        this.cliente_ac = cliente_ac;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTip_pers() {
        return tip_pers;
    }

    public void setTip_pers(String tip_pers) {
        this.tip_pers = tip_pers;
    }

    public String getVend() {
        return vend;
    }

    public void setVend(String vend) {
        this.vend = vend;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCod_post() {
        return cod_post;
    }

    public void setCod_post(String cod_post) {
        this.cod_post = cod_post;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCliente_ac() {
        return cliente_ac;
    }

    public void setCliente_ac(String cliente_ac) {
        this.cliente_ac = cliente_ac;
    }
}
