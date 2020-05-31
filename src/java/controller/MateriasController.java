package controller;

import perss.Materias;
import perss.Registro;
import java.util.Collection;
import facade.MateriasFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "materiasController")
@ViewScoped
public class MateriasController extends AbstractController<Materias> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroCollectionEmpty;

    public MateriasController() {
        // Inform the Abstract parent controller of the concrete Materias Entity
        super(Materias.class);
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
        Materias selected = this.getSelected();
        if (selected != null) {
            MateriasFacade ejbFacade = (MateriasFacade) this.getFacade();
            this.isRegistroCollectionEmpty = ejbFacade.isRegistroCollectionEmpty(selected);
        } else {
            this.isRegistroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Materias and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        Materias selected = this.getSelected();
        if (selected != null) {
            MateriasFacade ejbFacade = (MateriasFacade) this.getFacade();
            Collection<Registro> selectedRegistroCollection = ejbFacade.findRegistroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", selectedRegistroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registro/index";
    }

}
