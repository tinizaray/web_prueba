package controller;

import perss.Insumos;
import perss.Registro;
import java.util.Collection;
import facade.InsumosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "insumosController")
@ViewScoped
public class InsumosController extends AbstractController<Insumos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroCollectionEmpty;

    public InsumosController() {
        // Inform the Abstract parent controller of the concrete Insumos Entity
        super(Insumos.class);
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
        Insumos selected = this.getSelected();
        if (selected != null) {
            InsumosFacade ejbFacade = (InsumosFacade) this.getFacade();
            this.isRegistroCollectionEmpty = ejbFacade.isRegistroCollectionEmpty(selected);
        } else {
            this.isRegistroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Insumos and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        Insumos selected = this.getSelected();
        if (selected != null) {
            InsumosFacade ejbFacade = (InsumosFacade) this.getFacade();
            Collection<Registro> selectedRegistroCollection = ejbFacade.findRegistroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", selectedRegistroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registro/index";
    }

}
