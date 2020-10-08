package cs.pc;

import java.util.logging.Logger;
import java.util.Scanner;

public class RegistrApp {

    static final Logger logger = Logger.getLogger(RegistrApp.class.getName());
    private EntidadUniversitaria profesor;
    String[] idiomas = {"ES","EN"};
    
    public boolean loginAndRegister(String nombreProfesor) {
        logger.info("Bienvenido a RegistrApp");
        logger.info("Por favor, ingrese su nombre: ");
        if(nombreProfesor.equals("")){
            Scanner input = new Scanner(System.in);
            profesor.setNombre(input.toString());
        }else{
            profesor.setNombre(nombreProfesor);
        }

        logger.info("Ingrese la descripcion del curso: ");
        Scanner descInput = new Scanner(System.in);
        logger.info("Ingrese el link del curso: ");
        Scanner linkInput = new Scanner(System.in);
        if(validateDescription(descInput.toString()) && validateLink(linkInput.toString())){
            notify("Curso creado con exito");
            return true;
        }else 
            return false;
    }

    public boolean validateDescription(String description){
        String[] descComponentes = description.split(",");
        String[] infoGeneral = descComponentes[0].split("\\s+");
        String seccion = descComponentes[1];
        String semana = descComponentes[2];
        String profesor = descComponentes[3];
        String fechayTipo = descComponentes[4];

        CourseDescription curso = new CourseDescription(infoGeneral, seccion, semana, profesor, fechayTipo);

        if(curso.isValidDescription()) return true;
        else return false;
    }

    public boolean validateLink(String link){
        CourseLink courseLink = new CourseLink(link);
        if(courseLink.isValidLink()) return true;
        else return false;
    }

    public String notify(String mensaje){
        EntidadUniversitaria ce2a = new EntidadUniversitaria();
        EntidadUniversitaria dga = new EntidadUniversitaria();
        EntidadUniversitaria counterDocentes = new EntidadUniversitaria();
        EntidadUniversitaria counterAlumnos = new EntidadUniversitaria();
        ce2a.setNombre("ce2a");
        dga.setNombre("dga");
        counterDocentes.setNombre("counterDocentes");
        counterAlumnos.setNombre("counterAlumnos");
        
        
        return "Entidades notificada correctamente";
    }

    public void main(String []args){
        this.loginAndRegister("");
    }


}