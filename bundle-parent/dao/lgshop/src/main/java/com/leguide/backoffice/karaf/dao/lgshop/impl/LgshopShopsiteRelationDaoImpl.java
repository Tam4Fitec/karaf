package com.leguide.backoffice.karaf.dao.lgshop.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteRelationDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteRelation;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteRelationKey;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopShopsiteRelationDaoImpl implements LgshopShopsiteRelationDao {

	 private static final Logger logger = LoggerFactory.getLogger(LgshopShopsiteRelationDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Integer> findIdsByShopsiteAndNamespace(Long shopsiteId, String namespace) {
        List<Integer> values = new ArrayList<Integer>();
        for (LgshopShopsiteRelation relation : findByShopsiteAndNamespace(shopsiteId, namespace)) {
            values.add(relation.getKey().getLabelId());
        }
        return values;
    }

    private List<LgshopShopsiteRelation> findByShopsiteAndNamespace(Long shopsiteId, String namespace) {
        TypedQuery<LgshopShopsiteRelation> query = em.createNamedQuery(LgshopShopsiteRelation.FIND_BY_SHOPSITE_AND_NAMESPACE, LgshopShopsiteRelation.class);
        query.setParameter("shopsiteId", shopsiteId);
        query.setParameter("namespace", namespace);
        return query.getResultList();
    }

    @Override
    public void createForShopsiteAndNamespace(List<Integer> ids, Long shopsiteId, String namespace) {
    	if(ids != null){
    		 for (Integer id : ids) {
    			 	logger.debug("namespace : "+namespace+" id : "+id+" shopsiteId : "+shopsiteId);
    	            em.persist(new LgshopShopsiteRelation(new LgshopShopsiteRelationKey(id, shopsiteId, namespace)));
    	      }
    	}
    }

    @Override
    public void deleteAllForShopsiteAndNamespace(Long shopsiteId, String namespace) {
        for (LgshopShopsiteRelation relation : findByShopsiteAndNamespace(shopsiteId, namespace)) {
              em.remove(relation);
        }
    }


    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
