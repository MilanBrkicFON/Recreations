/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@FacesConverter(forClass = LocalDate.class, value = "ldConv")
public class LocalDateConverter implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDate.parse(value,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof LocalDate) {
            LocalDate ld = (LocalDate) value;
            return ld.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } else {
            return "";
        }

    }
}
