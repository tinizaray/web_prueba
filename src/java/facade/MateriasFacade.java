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
import perss.Materias;
import perss.Materias_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Registro;

/**
 *
 * @author userAT
 */
@Stateless
public class MateriasFacade extends AbstractFacade<Materias> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriasFacade() {
        super(Materias.class);
    }

    public boolean isRegistroCollectionEmpty(Materias entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Materias> materias = cq.from(Materias.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(materias, entity), cb.isNotEmpty(materias.get(Materias_.registroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Registro> findRegistroCollection(Materias entity) {
        Materias mergedEntity = this.getMergedEntity(entity);
        Collection<Registro> registroCollection = mergedEntity.getRegistroCollection();
        registroCollection.size();
        return registroCollection;
    }
    
}
