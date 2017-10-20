/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.GenericFacadeLocal;

/**
 *
 * @author bryan
 */
public abstract class GenericManagedBean<T> implements Serializable{
    List<T> listaDatos;

    /**
     * este metodo sirve para crear un nuevo un registro
     */
    public void crear() {
        if(getFacadeLocal()!=null){
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().create(getEntity());
                llenarLista();
            } catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
    }
    
    /**
     * este metodo sirve para editar un registro
     */
    public void editar() {
        if(getFacadeLocal()!=null){
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().edit(getEntity());
                llenarLista();
            } catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
    }
    
    /**
     * este metodo sirve para eliminar un registro
     */
    public void eliminar() {
        if(getFacadeLocal()!=null){
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().remove(getEntity());
                llenarLista();
            } catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
    }
    
    /**
     * Este metodo sirve para llenar una lista de datos obtenidos de la base de datos
     */
    public void llenarLista() {
         if (getFacadeLocal().findAll() != null) {
            this.listaDatos = getFacadeLocal().findAll();
        }else{
             this.listaDatos = Collections.EMPTY_LIST;
        }
    }
    
    /**
     *
     * @return
     */
    protected abstract GenericFacadeLocal<T> getFacadeLocal();
    
    /**
     * 
     * @return 
     */
    public abstract T getEntity();
    
}
