package cs.pc;

import java.util.logging.Logger;

public class EntidadUniversitaria {

    private String nombre;
    private String currentNotification;
    static final Logger logger = Logger.getLogger(Profesor.class.getName());

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNotification(String notification){
        this.currentNotification = notification;
        logger.info(this.nombre + " notificado correctamente.");
    }

    public String getNombre(){
        return this.nombre;
    }

    
    
}