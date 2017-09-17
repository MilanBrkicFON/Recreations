/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author Milan
 */
@Named
@ApplicationScoped
public class LocalTimeConverter implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalTime.parse(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof LocalTime) {
            LocalTime ld = (LocalTime) value;
            //return ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return ld.toString();
        } else {
            return "";
        }

    }
}
