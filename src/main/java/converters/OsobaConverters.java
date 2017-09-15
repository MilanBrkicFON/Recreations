/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import model.Mesto;
import model.Osoba;
import utility.Kontroler;

/**
 *
 * @author Milan
 */
@Named
@ApplicationScoped
public class OsobaConverters implements Converter {

    @Inject
    private Kontroler kontroler;

    public OsobaConverters() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Vrednost pristigla u getAsObject: " + value);
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            return kontroler.pronadjiOsobu(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            throw new ConverterException(new FacesMessage(value + " is not a valid Osoba"));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Osoba) {
            Osoba o = (Osoba) value;
            return o.toString();
        } else {
            throw new ConverterException(new FacesMessage(value + " is not a valid Osoba"));
        }
    }

}
