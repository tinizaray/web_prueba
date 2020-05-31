package controller;

import perss.Registro;
import facade.RegistroFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroController")
@ViewScoped
public class RegistroController extends AbstractController<Registro> {

    @Inject
    private AlumnosController alumnosController;
    @Inject
    private CursoController cursoController;
    @Inject
    private DocenteController docenteController;
    @Inject
    private InsumosController insumosController;
    @Inject
    private MateriasController materiasController;
    @Inject
    private ParcialesController parcialesController;
    @Inject
    private QuimestreController quimestreController;
    @Inject
    private UnidadController unidadController;
    @Inject
    private MobilePageController mobilePageController;

    public RegistroController() {
        // Inform the Abstract parent controller of the concrete Registro Entity
        super(Registro.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getRegistroPK().setMaId(this.getSelected().getMaterias().getMaId());
        this.getSelected().getRegistroPK().setAlId(this.getSelected().getAlumnos().getAlId());
        this.getSelected().getRegistroPK().setCurId(this.getSelected().getCurso().getCurId());
        this.getSelected().getRegistroPK().setUnId(this.getSelected().getUnidad().getUnId());
        this.getSelected().getRegistroPK().setDoId(this.getSelected().getDocente().getDoId());
        this.getSelected().getRegistroPK().setQuiId(this.getSelected().getQuimestre().getQuiId());
        this.getSelected().getRegistroPK().setPaId(this.getSelected().getParciales().getPaId());
        this.getSelected().getRegistroPK().setInId(this.getSelected().getInsumos().getInId());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setRegistroPK(new perss.RegistroPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        alumnosController.setSelected(null);
        cursoController.setSelected(null);
        docenteController.setSelected(null);
        insumosController.setSelected(null);
        materiasController.setSelected(null);
        parcialesController.setSelected(null);
        quimestreController.setSelected(null);
        unidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Alumnos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAlumnos(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && alumnosController.getSelected() == null) {
            alumnosController.setSelected(selected.getAlumnos());
        }
    }

    /**
     * Sets the "selected" attribute of the Curso controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCurso(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && cursoController.getSelected() == null) {
            cursoController.setSelected(selected.getCurso());
        }
    }

    /**
     * Sets the "selected" attribute of the Docente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDocente(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && docenteController.getSelected() == null) {
            docenteController.setSelected(selected.getDocente());
        }
    }

    /**
     * Sets the "selected" attribute of the Insumos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareInsumos(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && insumosController.getSelected() == null) {
            insumosController.setSelected(selected.getInsumos());
        }
    }

    /**
     * Sets the "selected" attribute of the Materias controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMaterias(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && materiasController.getSelected() == null) {
            materiasController.setSelected(selected.getMaterias());
        }
    }

    /**
     * Sets the "selected" attribute of the Parciales controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParciales(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && parcialesController.getSelected() == null) {
            parcialesController.setSelected(selected.getParciales());
        }
    }

    /**
     * Sets the "selected" attribute of the Quimestre controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareQuimestre(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && quimestreController.getSelected() == null) {
            quimestreController.setSelected(selected.getQuimestre());
        }
    }

    /**
     * Sets the "selected" attribute of the Unidad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUnidad(ActionEvent event) {
        Registro selected = this.getSelected();
        if (selected != null && unidadController.getSelected() == null) {
            unidadController.setSelected(selected.getUnidad());
        }
    }

}
