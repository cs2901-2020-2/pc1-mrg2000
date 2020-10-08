package cs.pc;

public class CourseLink {
    private String link;
    private String linkPrefix = "https://utec.zoom.us/rec/share/";

    CourseLink(String link){
        this.link = link;
    }

    public boolean isValidLink(){
        return this.link.substring(0,30).matches(this.linkPrefix);
    }


}