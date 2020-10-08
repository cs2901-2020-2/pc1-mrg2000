package cs.pc;


public class CourseDescription {
    private String[] infoGeneral;
    private String seccion;
    private String semana;
    private String profesor;
    private String fechayTipo;

    CourseDescription(String[] infoGeneral, String seccion, String semana, String profesor, String fechayTipo){
        this.infoGeneral = infoGeneral;
        this.seccion = seccion;
        this.semana = semana;
        this.profesor = profesor;
        this.fechayTipo = fechayTipo;
    }

    public boolean isValidDescription(){
        String[] datosHorarios = this.fechayTipo.split("\\s+");
        if(this.infoGeneral.length != 4 || !infoGeneral[0].substring(0,3).matches("[0-9]")) return false;
        else if(!this.seccion.matches("[0-9]") || !this.semana.substring(0,5).equals("Semana")) return false;
        else if(!datosHorarios[0].matches("[0-9]/") || !datosHorarios[1].matches("[0-9]-")) return false;
        else return true;
    }



}