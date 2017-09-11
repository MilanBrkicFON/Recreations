/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Mesto;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named(value = "mestoConv")
@FacesConverter(value = "mestoConv", forClass = Mesto.class)
public class MestoConverters implements Converter {
    @Inject
    private Kontroler kontroler;

    public MestoConverters() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Vrednost pristigla u getAsObject: " + value);
        System.out.println("kontroler: " + kontroler);
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Kontroler k = new Kontroler();
            return kontroler.pronadjiMesto(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            throw new ConverterException(new FacesMessage(value + " is not a valid Mesto"));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Mesto) {
            Mesto m = (Mesto) value;
            return "" + m.getPtt();
        } else {
            throw new ConverterException(new FacesMessage(value + " is not a valid Mesto"));
        }
    }

}
