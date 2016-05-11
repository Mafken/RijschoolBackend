
package domain;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Leerling")
@NamedQueries({
    @NamedQuery(name = "Leerling.findAll", query = "SELECT l FROM Leerling l")
})
public class Leerling {
    
    @Id
    private String nummer; 
    
    private String naam;
    private String email ; 
    private String geboorteDatum ; 
   // private Image afbeelding; 
    
    @OneToOne
    private Verkeerstechniek VT; 
    
    @OneToOne
    private Rijtechniek RT;
    
    @OneToOne
    private Hoofdscherm hoofdscherm;
    
    @OneToMany
    private List<Evaluatie> evaluaties; 
    
    private List<String> attitude; 
    private List<String> opmerkingen;

  
    public Leerling(){
        
    }
    
    public Leerling(String nummer, String naam) {
        this.nummer = nummer;
        this.naam = naam;
        this.hoofdscherm = new Hoofdscherm();
        this.RT = new Rijtechniek();
        this.VT = new Verkeerstechniek();
        evaluaties = new ArrayList<>();
        attitude = new ArrayList<>();
        opmerkingen = new ArrayList<>();
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    public Verkeerstechniek getVT() {
        return VT;
    }

    public void setVT(Verkeerstechniek VT) {
        this.VT = VT;
    }

    public Rijtechniek getRT() {
        return RT;
    }

    public void setRT(Rijtechniek RT) {
        this.RT = RT;
    }

    public List<String> getOpmerkingen() {
        return opmerkingen;
    }
    
    public List<String> getAttitude() {
        return attitude;
    }

    public List<Evaluatie> getEvaluaties() {
        return evaluaties;
    }
    
//    public Image getAfbeelding() {
//        return afbeelding;
//    }
//
//    public void setAfbeelding(Image afbeelding) {
//        this.afbeelding = afbeelding;
//    }

    public Hoofdscherm getHoofdscherm() {
        return hoofdscherm;
    }

    public void setHoofdscherm(Hoofdscherm hoofdscherm) {
        this.hoofdscherm = hoofdscherm;
    }

    
    public String getnaam() {
        return naam;
    }

    public void setnaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    @Override
    public String toString() {
        return String.format("%s", naam); 
    }
 
}
