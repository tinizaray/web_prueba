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
import perss.Insumos;
import perss.Insumos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Registro;

/**
 *
 * @author userAT
 */
@Stateless
public class InsumosFacade extends AbstractFacade<Insumos> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsumosFacade() {
        super(Insumos.class);
    }

    public boolean isRegistroCollectionEmpty(Insumos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Insumos> insumos = cq.from(Insumos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(insumos, entity), cb.isNotEmpty(insumos.get(Insumos_.registroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Registro> findRegistroCollection(Insumos entity) {
        Insumos mergedEntity = this.getMergedEntity(entity);
        Collection<Registro> registroCollection = mergedEntity.getRegistroCollection();
        registroCollection.size();
        return registroCollection;
    }
    
}
