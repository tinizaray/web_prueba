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
import perss.Curso;
import perss.Curso_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import perss.Registro;

/**
 *
 * @author userAT
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> {

    @PersistenceContext(unitName = "app_preubaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }

    public boolean isRegistroCollectionEmpty(Curso entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Curso> curso = cq.from(Curso.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(curso, entity), cb.isNotEmpty(curso.get(Curso_.registroCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Registro> findRegistroCollection(Curso entity) {
        Curso mergedEntity = this.getMergedEntity(entity);
        Collection<Registro> registroCollection = mergedEntity.getRegistroCollection();
        registroCollection.size();
        return registroCollection;
    }
    
}
