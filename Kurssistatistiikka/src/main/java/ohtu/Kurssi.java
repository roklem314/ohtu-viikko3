
package ohtu;


public class Kurssi {
    private String id;
    private String name;
    private String term;
    
    public void setId(String id){
    this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Kurssi: " + this.name + ", " + this.term; 
                }
    
    
    
}
