package controller;

import perss.Parciales;
import perss.Registro;
import java.util.Collection;
import facade.ParcialesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "parcialesController")
@ViewScoped
public class ParcialesController extends AbstractController<Parciales> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroCollectionEmpty;

    public ParcialesController() {
        // Inform the Abstract parent controller of the concrete Parciales Entity
        super(Parciales.class);
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
        Parciales selected = this.getSelected();
        if (selected != null) {
            ParcialesFacade ejbFacade = (ParcialesFacade) this.getFacade();
            this.isRegistroCollectionEmpty = ejbFacade.isRegistroCollectionEmpty(selected);
        } else {
            this.isRegistroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Parciales and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        Parciales selected = this.getSelected();
        if (selected != null) {
            ParcialesFacade ejbFacade = (ParcialesFacade) this.getFacade();
            Collection<Registro> selectedRegistroCollection = ejbFacade.findRegistroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", selectedRegistroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registro/index";
    }

}
