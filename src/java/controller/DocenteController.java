package controller;

import perss.Docente;
import perss.Registro;
import java.util.Collection;
import facade.DocenteFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "docenteController")
@ViewScoped
public class DocenteController extends AbstractController<Docente> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroCollectionEmpty;

    public DocenteController() {
        // Inform the Abstract parent controller of the concrete Docente Entity
        super(Docente.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroCollectionEmpty();
    }

    public boolean getIsRegistroCollectionEmpty() {
        return this.isRegistroCollectionEmpty;
    }

    private void setIsRegistroCollectionEmpty() {
        Docente selected = this.getSelected();
        if (selected != null) {
            DocenteFacade ejbFacade = (DocenteFacade) this.getFacade();
            this.isRegistroCollectionEmpty = ejbFacade.isRegistroCollectionEmpty(selected);
        } else {
            this.isRegistroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Docente and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        Docente selected = this.getSelected();
        if (selected != null) {
            DocenteFacade ejbFacade = (DocenteFacade) this.getFacade();
            Collection<Registro> selectedRegistroCollection = ejbFacade.findRegistroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", selectedRegistroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registro/index";
    }

}
