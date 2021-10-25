package crudmvc;

import controlador.CtrlProducto;
import modelo.ConsultasProductos;
import modelo.Producto;
import vistas.altaProductos;

public class CRUDMVC {
    
    public static void main (String [] args){
        
        Producto mod= new Producto();
        ConsultasProductos modC = new ConsultasProductos();
        altaProductos frm = new altaProductos();
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
                
    }
    
}
