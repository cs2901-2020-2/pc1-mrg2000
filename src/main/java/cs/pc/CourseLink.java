package cs.pc;
import java.lang.String;

public class CourseLink {
    private String link;
    private String linkPrefix = "https://utec.zoom.us/rec/share/";

    CourseLink(String link){
        this.link = link;
    }

    public boolean isValidLink(){
        if(this.link.substring(0,30).matches(this.linkPrefix)) return true;
        else return false;
    }


}