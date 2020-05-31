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
import perss.Parciales;
import perss.Parciales_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Registro;

/**
 *
 * @author userAT
 */
@Stateless
public class ParcialesFacade extends AbstractFacade<Parciales> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParcialesFacade() {
        super(Parciales.class);
    }

    public boolean isRegistroCollectionEmpty(Parciales entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Parciales> parciales = cq.from(Parciales.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(parciales, entity), cb.isNotEmpty(parciales.get(Parciales_.registroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Registro> findRegistroCollection(Parciales entity) {
        Parciales mergedEntity = this.getMergedEntity(entity);
        Collection<Registro> registroCollection = mergedEntity.getRegistroCollection();
        registroCollection.size();
        return registroCollection;
    }
    
}
