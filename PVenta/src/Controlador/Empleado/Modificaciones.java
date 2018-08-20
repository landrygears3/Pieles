/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Empleado;

/**
 *
 * @author win 10
 */
public class Modificaciones {
    public String Nombre = "", Usuario = "", Contra = "", Tel = "";
    public boolean mod = false;
    
    
    public Boolean n (String Nom, Boolean b){
        Nombre=Nom;
        mod = true;
        mo();
        System.out.println(Nombre);
        return mod;
        
}
    
    public String u (String Nom){
        Usuario=Nom;
        return Usuario;
    
}
    
    public String c (String Nom){
        Contra=Nom;
        return Contra;
    
}
    
    public String t (String Nom){
        Tel=Nom;
        return Tel;
    
}
    
    public boolean mo(){
        System.out.println(mod);
        return mod;
    }
    
    public void fm(Boolean m){
        mod = false;
        System.out.println(mod);
    }
    
    
}
