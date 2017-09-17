/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import model.Trening;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Milan
 */
@Named(value = "mBPrijavaNaTrening")
@ViewScoped
public class MBPrijavaNaTrening implements Serializable {

    public void izaberiTrening() {
        try {
            Map<String, Object> options = new HashMap<>();
            options.put("resizable", false);
            options.put("draggable", false);
            options.put("modal", true);

            RequestContext.getCurrentInstance().openDialog("dijalogTreningPrijava", options, null);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("greska: " + e.getMessage()));
        }
    }

    public void naIzabranTrening(SelectEvent evt) {
        Trening trening = (Trening) evt.getObject();
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Prijavljen na trening: ", trening.toString());
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
