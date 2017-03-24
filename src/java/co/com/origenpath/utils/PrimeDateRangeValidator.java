/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenpath.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author danie
 */
@FacesValidator("primeDateRangeValidator")
public class PrimeDateRangeValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
            if(value == null){
                return;
            }
            
            SimpleDateFormat startDateValue = new SimpleDateFormat("dd-MMM-yyyy");
            
            Date date1 = startDateValue.parse("01-01-1999");
            Date endDate = (Date)value;
            
            if (endDate.after(date1)) {
                FacesMessage message = new FacesMessage("La Fecha no es correcta debe ser mayo a 18 años.");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PrimeDateRangeValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
