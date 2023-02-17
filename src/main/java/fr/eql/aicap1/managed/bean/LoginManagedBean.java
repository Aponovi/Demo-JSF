package fr.eql.aicap1.managed.bean;

import fr.eql.aicap1.jdbc.demo.dao.OwnerDao;
import fr.eql.aicap1.jdbc.demo.entity.Owner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;

@ManagedBean(name = "mbLogin")
@SessionScoped
public class LoginManagedBean {
    private Owner owner;
    @Size(max = 10, message = "L'identifiant ne peut faire que 10 caractères au maximum.")
    private String login;
    private String password;

    private final OwnerDao ownerDao = new OwnerDao();

    public String connect() {
        String forward;
        owner = ownerDao.authenticate(login, password);
        if (owner !=null){
            forward = "/connectedPage.xhtml?faces-redirect=true";

        }else {
            FacesMessage facesMessage = new FacesMessage(
                    FacesMessage.SEVERITY_WARN,
                    "Identifiant et/ou mot de passe incorrect(s).",
                    "Identifiant et/ou mot de passe incorrect(s)."
            );
            FacesContext.getCurrentInstance().addMessage("loginForm:inpLogin", facesMessage);
            FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
            forward = "/simpleLogin.xhtml? faces-redirect=False";
        }

        return forward;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
