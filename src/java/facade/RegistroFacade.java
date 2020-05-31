/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import perss.Registro;
import perss.Registro_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Alumnos;
import perss.Curso;
import perss.Docente;
import perss.Insumos;
import perss.Materias;
import perss.Parciales;
import perss.Quimestre;
import perss.Unidad;

/**
 *
 * @author userAT
 */
@Stateless
public class RegistroFacade extends AbstractFacade<Registro> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroFacade() {
        super(Registro.class);
    }

    public boolean isAlumnosEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.alumnos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Alumnos findAlumnos(Registro entity) {
        return this.getMergedEntity(entity).getAlumnos();
    }

    public boolean isCursoEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.curso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Curso findCurso(Registro entity) {
        return this.getMergedEntity(entity).getCurso();
    }

    public boolean isDocenteEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.docente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Docente findDocente(Registro entity) {
        return this.getMergedEntity(entity).getDocente();
    }

    public boolean isInsumosEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.insumos)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Insumos findInsumos(Registro entity) {
        return this.getMergedEntity(entity).getInsumos();
    }

    public boolean isMateriasEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.materias)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Materias findMaterias(Registro entity) {
        return this.getMergedEntity(entity).getMaterias();
    }

    public boolean isParcialesEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.parciales)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Parciales findParciales(Registro entity) {
        return this.getMergedEntity(entity).getParciales();
    }

    public boolean isQuimestreEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.quimestre)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Quimestre findQuimestre(Registro entity) {
        return this.getMergedEntity(entity).getQuimestre();
    }

    public boolean isUnidadEmpty(Registro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Registro> registro = cq.from(Registro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registro, entity), cb.isNotNull(registro.get(Registro_.unidad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Unidad findUnidad(Registro entity) {
        return this.getMergedEntity(entity).getUnidad();
    }
    
}
