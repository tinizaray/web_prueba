package converter;

import perss.Registro;
import facade.RegistroFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "registroConverter")
public class RegistroConverter implements Converter {

    private RegistroFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    perss.RegistroPK getKey(String value) {
        perss.RegistroPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new perss.RegistroPK();
        key.setReId(Integer.parseInt(values[0]));
        key.setMaId(Integer.parseInt(values[1]));
        key.setAlId(Integer.parseInt(values[2]));
        key.setCurId(Integer.parseInt(values[3]));
        key.setUnId(Integer.parseInt(values[4]));
        key.setDoId(Integer.parseInt(values[5]));
        key.setQuiId(Integer.parseInt(values[6]));
        key.setPaId(Integer.parseInt(values[7]));
        key.setInId(Integer.parseInt(values[8]));
        return key;
    }

    String getStringKey(perss.RegistroPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getReId());
        sb.append(SEPARATOR);
        sb.append(value.getMaId());
        sb.append(SEPARATOR);
        sb.append(value.getAlId());
        sb.append(SEPARATOR);
        sb.append(value.getCurId());
        sb.append(SEPARATOR);
        sb.append(value.getUnId());
        sb.append(SEPARATOR);
        sb.append(value.getDoId());
        sb.append(SEPARATOR);
        sb.append(value.getQuiId());
        sb.append(SEPARATOR);
        sb.append(value.getPaId());
        sb.append(SEPARATOR);
        sb.append(value.getInId());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Registro) {
            Registro o = (Registro) object;
            return getStringKey(o.getRegistroPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Registro.class.getName()});
            return null;
        }
    }

    private RegistroFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(RegistroFacade.class).get();
        return this.ejbFacade;
    }
}
