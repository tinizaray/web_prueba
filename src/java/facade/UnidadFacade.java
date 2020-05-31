/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import perss.Unidad;
import perss.Unidad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Registro;

/**
 *
 * @author userAT
 */
@Stateless
public class UnidadFacade extends AbstractFacade<Unidad> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadFacade() {
        super(Unidad.class);
    }

    public boolean isRegistroCollectionEmpty(Unidad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Unidad> unidad = cq.from(Unidad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(unidad, entity), cb.isNotEmpty(unidad.get(Unidad_.registroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Registro> findRegistroCollection(Unidad entity) {
        Unidad mergedEntity = this.getMergedEntity(entity);
        Collection<Registro> registroCollection = mergedEntity.getRegistroCollection();
        registroCollection.size();
        return registroCollection;
    }
    
}
