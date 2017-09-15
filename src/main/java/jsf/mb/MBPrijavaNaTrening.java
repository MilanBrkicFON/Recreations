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
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Milan
 */
@Named(value = "mBPrijavaNaTrening")
@ViewScoped
public class MBPrijavaNaTrening implements Serializable {

    public void izaberiTrening(){
        try{
        Map<String,Object> opcije = new HashMap<>();
        opcije.put("resizable", true);
        opcije.put("dragable", true);
        opcije.put("modal", true);
        opcije.put("contentWidth", "100%");
        opcije.put("width", "70%");
        
        //null - moze se poslati parametri na dijalog! Ako zatreba
        RequestContext.getCurrentInstance().openDialog("prijavaNaTrening", opcije, null);
        }catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("greska: "+e.getMessage()));
        } 
    }
    
    public void naIzabranTrening(SelectEvent evt){
        
    }
}
