package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDao;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopLightShopsite;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsite;
import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteRelation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LgshopShopsiteDaoImpl implements LgshopShopsiteDao {

    @PersistenceContext
    private EntityManager em;


    public LgshopShopsiteDaoImpl() {

    }

    @Override
    public LgshopShopsite findById(Long id) {
        return em.find(LgshopShopsite.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<LgshopLightShopsite> findLightShopInfoByKSite(long ksite) {
        Query query = em.createNamedQuery(LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_KSITE, LgshopLightShopsite.class);
        query.setParameter(1, ksite);
        query.setParameter(2, ksite);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public LgshopLightShopsite findLightShopInfoById(String id) {

        TypedQuery<LgshopLightShopsite> query = em.createNamedQuery(LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_ID, LgshopLightShopsite.class);
        query.setParameter(1, id);
        return query.getResultList().stream().findFirst().map(shopsite -> {
            TypedQuery<String> stringTypedQuery = em.createNamedQuery(LgshopShopsiteRelation.FIND_PAYMENT_INFO_BY_SHOPSITE_ID_AND_NAMESPACE, String.class);
            stringTypedQuery.setParameter(1, id);
            stringTypedQuery.setParameter(2, "payment_solutions");
            shopsite.setPaymentSolutions(stringTypedQuery.getResultList());

            stringTypedQuery = em.createNamedQuery(LgshopShopsiteRelation.FIND_PAYMENT_INFO_BY_SHOPSITE_ID_AND_NAMESPACE, String.class);
            stringTypedQuery.setParameter(1, id);
            stringTypedQuery.setParameter(2, "payment_card");
            shopsite.setPaymentCards(stringTypedQuery.getResultList());

            stringTypedQuery = em.createNamedQuery(LgshopShopsiteRelation.FIND_PAYMENT_INFO_BY_SHOPSITE_ID_AND_NAMESPACE, String.class);
            stringTypedQuery.setParameter(1, id);
            stringTypedQuery.setParameter(2, "other_payment_methods");
            shopsite.setOtherPaymentMethods(stringTypedQuery.getResultList());

            stringTypedQuery = em.createNamedQuery(LgshopShopsiteRelation.FIND_DELIVERY_AVAILABLE_BY_SHOPSITE_ID, String.class);
            stringTypedQuery.setParameter(1, id);
            stringTypedQuery.setParameter(2, id);

            shopsite.setDeliveryOptions(stringTypedQuery.getResultList());

            return shopsite;
        }).orElse(null);
    }

    /*
     * (non-Javadoc)
     * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDao#findLightShopInfoByIds(java.lang.Long[])
     */
    public List<LgshopLightShopsite> findLightShopInfoByIds(String[] ids) {
        List<LgshopLightShopsite> toReturn = new ArrayList<LgshopLightShopsite>();

        LgshopLightShopsite shopsite = null;

        for (String id : ids) {
            shopsite = findLightShopInfoById(id);
            if (shopsite != null)
                toReturn.add(shopsite);
        }

        return toReturn;
    }

    @Override
    public List<LgshopLightShopsite> findLightShopInfoByZeusNotation(Integer zeusNotation, Integer limit, Integer offset) {
        TypedQuery<LgshopLightShopsite> query = em.createNamedQuery(LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_ZEUS_NOTATION, LgshopLightShopsite.class);
        query.setParameter(1, zeusNotation);
        if (offset != null) {
            query.setFirstResult(offset);
        }
        if (limit != null) {
            query.setMaxResults(limit);
        }

        return query.getResultList();
    }

    @Override
    public List<Long> findListShopIdByLanguageAndRefState(Long languageId, Long idRefState) {
        TypedQuery<Number> jpaQuery = em.createNamedQuery(LgshopShopsite.GET_LIST_ID_BY_LANGUAGE_AND_ID_REFSTATE, Number.class);
        jpaQuery.setParameter(1, idRefState);
        jpaQuery.setParameter(2, languageId);
        return jpaQuery.getResultList().stream().map(Number::longValue).collect(Collectors.toList());
    }

    @Override public void createShopMapping(Long comId, Long shopId, String name,String languague, String locale) {
        
        Query queryInsert = em.createNativeQuery("insert into lgshop.mapping_merchant (kk_com_id, lg_shop_id,kk_merchant_name,lg_merchant_name,merchant_lang,lg_backfill, locale)"
                        + " values (?,?,?, ?,?,?,?)");
        queryInsert.setParameter(1, comId);
        queryInsert.setParameter(2, shopId);
        queryInsert.setParameter(3, name);
        queryInsert.setParameter(4, name);
        queryInsert.setParameter(5, languague);
        queryInsert.setParameter(6, 'Y');
        queryInsert.setParameter(7, locale);
        queryInsert.executeUpdate();
    }

    @Override
    public String retrieveLocale(Long shopsiteId) {
        Query querySelect = em.createNativeQuery("SELECT lang.localename FROM lgshop.tb_shopsite shop\n" +
                "JOIN lgshop.rf_country cty ON cty.cty_internal_number = shop.id_country\n" +
                "JOIN lgshop.rf_language lang ON lang.id_language = shop.shs_main_language AND lang.country = cty.cty_alpha2_code\n" +
                "WHERE id_shopsite = ?; ");
        querySelect.setParameter(1, shopsiteId);
        return (String) querySelect.getSingleResult();
    }

    /*
         * (non-Javadoc)
         * @see com.leguide.backoffice.karaf.dao.lgshop.LgshopShopsiteDao#create(com.leguide.backoffice.karaf.models.lgshop.Shopsite)
         */
    @Override
    public void create(LgshopShopsite newShopsite) {
        em.persist(newShopsite);
    }

    @Override
    public void update(LgshopShopsite lgshopShopsite) {
        em.merge(lgshopShopsite);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
