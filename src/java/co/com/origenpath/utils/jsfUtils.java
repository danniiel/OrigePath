/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author daniel
 */
public class jsfUtils {
    
    
    public static String guardarImagenTemporal(byte[] bytes, String nombreArchivo){
        String ubicacionImagen=null;
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("")+File.separatorChar+"resources" 
                + File.separatorChar+"images"
                +File.separatorChar+"tmp"
                +File.separatorChar+nombreArchivo;
        
        File f = null;
        InputStream in = null;
        try{
            f=new File(path);
            in= new ByteArrayInputStream(bytes);
            FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
            
            int c=0;
            while((c=in.read())>=0){
                out.write(c);
            }
            out.flush();
            out.close();
            ubicacionImagen="../../resources/images/tmp/"+nombreArchivo;
        }catch(Exception e){
            System.err.println("No se pudo cargar la imagen");
        }
        return ubicacionImagen;
    }
        public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
}
