package com.leguide.backoffice.karaf.dao.lgshop.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteStateHistoryDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteReportSubscription;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteStateHistory;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteState;
import org.springframework.stereotype.Repository;

@Repository
public class LgshopShopsiteStateHistoryDaoImpl implements LgshopShopsiteStateHistoryDao {

    @PersistenceContext
	private EntityManager em;

	@Override
	public void create(LgshopShopsiteState state) {
		create(state, null);
	}

	@Override
	public void create(LgshopShopsiteState state, String user) {
		LgshopShopsiteStateHistory history = new LgshopShopsiteStateHistory();
		history.setShopsiteId(state.getShopsiteId());
		history.setIdRefState(state.getIdRefState());
		history.setShopState(state.getShopState());
		history.setReason(state.getReason());
		history.setShopLogo(state.getShopLogo());
		history.setShopLogoEngine(state.getShopLogoEngine());
		history.setShopPartner(state.getShopPartner());
		history.setShopProductImage(state.getShopProductImage());
		history.setShopDooyoo(state.getShopDooyoo());
		history.setShopStrategic(state.getShopStrategic());
		history.setShopAdultContent(state.getShopAdultContent());
		history.setkSite(state.getkSiteflags());
		history.setShopSegmentation(state.getShopSegmentation());
		history.setZeusNotation(state.getZeusNotation());
		history.setUser(user);
		em.persist(history);
	}

    /**
     * Find penultimate state of a given shopsite
     * @param shopsiteId shopsite ID
     * @return last state of a given shopsite
     */
    public LgshopShopsiteStateHistory findPenultimateStateOfShopsite(Long shopsiteId) {
        TypedQuery<LgshopShopsiteStateHistory> query = em.createNamedQuery(
                LgshopShopsiteStateHistory.FIND_HISTORY_OF_SHOPSITE, LgshopShopsiteStateHistory.class).setMaxResults(2);
        query.setParameter("shopsiteId", shopsiteId);
        return query.getResultList().get(1);
    }

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
