package controller;

import perss.Quimestre;
import perss.Registro;
import java.util.Collection;
import facade.QuimestreFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "quimestreController")
@ViewScoped
public class QuimestreController extends AbstractController<Quimestre> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRegistroCollectionEmpty;

    public QuimestreController() {
        // Inform the Abstract parent controller of the concrete Quimestre Entity
        super(Quimestre.class);
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
        Quimestre selected = this.getSelected();
        if (selected != null) {
            QuimestreFacade ejbFacade = (QuimestreFacade) this.getFacade();
            this.isRegistroCollectionEmpty = ejbFacade.isRegistroCollectionEmpty(selected);
        } else {
            this.isRegistroCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Registro entities that
     * are retrieved from Quimestre and returns the navigation outcome.
     *
     * @return navigation outcome for Registro page
     */
    public String navigateRegistroCollection() {
        Quimestre selected = this.getSelected();
        if (selected != null) {
            QuimestreFacade ejbFacade = (QuimestreFacade) this.getFacade();
            Collection<Registro> selectedRegistroCollection = ejbFacade.findRegistroCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Registro_items", selectedRegistroCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/registro/index";
    }

}
