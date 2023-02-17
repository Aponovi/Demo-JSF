package fr.eql.aicap1.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/* Les portées possibles pour la durée de vie du bean géré :
Request - View - Session - Application
 */
@ManagedBean(name = "mbBasic")
@RequestScoped

public class BasicManagedBean {
    private String input;
    private String output;

    public String click(){
        String forward;
        output = input;
        switch (input){
            case "toto":
                forward = "/toto.xhtml?faces-redirect=true";
                break;
            case "titi":
                forward = "/titi.xhtml?faces-redirect=true";
                break;
            default:
                forward = "/basic.xhtml?faces-redirect=false";

        }
        return forward;
    }

    /// Gestters ///
    public String getInput() {return input;}
    public String getOutput() {return output;}
    /// Setters ///
    public void setInput(String input){this.input = input;}
}
