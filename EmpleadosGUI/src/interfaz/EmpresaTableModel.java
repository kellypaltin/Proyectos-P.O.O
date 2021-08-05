/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.ControladorEmpresa;
import javax.swing.table.AbstractTableModel;
import modelo.Empresa;

/**
 *
 * @author kellypaltin
 */
public class EmpresaTableModel extends AbstractTableModel{
    
    public ControladorEmpresa controladorEmpresa;
    public String nombreColumnas[] = {"Id", "Nombre"};
    public Class tipoColumnas[] = {Long.class, String.class};
    public EmpresaTableModel(ControladorEmpresa controladorEmpresa){
        this.controladorEmpresa = controladorEmpresa;
    }
    
    @Override
    public int getRowCount() {
        return controladorEmpresa.getListaEmpresa().size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Empresa empresa = controladorEmpresa.getListaEmpresa().get(row);
        switch(column){
            case 0:
                return empresa.getId();
            case 1:
                return empresa.getNombre();
        }
        controladorEmpresa.setSeleccionado(empresa);
        return null;
    }

    @Override
    public void setValueAt(Object valor, int row, int column) {
        Empresa empresa = controladorEmpresa.getListaEmpresa().get(row);
        switch(column){
            case 1:
                controladorEmpresa.actualizar(empresa.getId(), String.valueOf(valor));
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return (column != 0);
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return this.tipoColumnas[i];
    }

    @Override
    public String getColumnName(int i) {
        return this.nombreColumnas[i];
    }
    
    
    
    
}
