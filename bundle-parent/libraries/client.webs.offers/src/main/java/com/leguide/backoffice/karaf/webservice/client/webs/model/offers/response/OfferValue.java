package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferValue {

    private int rank;

    private String id;

    private String title;

    private String desc;

    private int shop;

    private int shop_im;

    private String shop_name;

    private String shop_vars;

    private int shop_rating;

    private int shop_logo;

    private int cat;

    private String cat_name;

    private int brand;

    private String brand_name;

    private float price_euro;

    private float price_ori_euro;

    private float deliv_cost_euro;

    private int in_stock_format;

    private String in_stock_value;

    private int deliv_nbdays_format;

    private String deliv_nbdays_value;

    private int warranty;

    private String url;

    private String ean13;

    private String currency;

    private float price_intl;

    private float price_ori_intl;

    private float deliv_cost_intl;

    private int on_sale;

    private int sale_status;

    private int discount_percentage;

    private int offer_state;

    private String go_url;

    private String click_url;

    private String img_offer;

    private String img_logo;

    private float cat_cpc;

    private String product;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public int getShop_im() {
        return shop_im;
    }

    public void setShop_im(int shop_im) {
        this.shop_im = shop_im;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_vars() {
        return shop_vars;
    }

    public void setShop_vars(String shop_vars) {
        this.shop_vars = shop_vars;
    }

    public int getShop_rating() {
        return shop_rating;
    }

    public void setShop_rating(int shop_rating) {
        this.shop_rating = shop_rating;
    }

    public int getShop_logo() {
        return shop_logo;
    }

    public void setShop_logo(int shop_logo) {
        this.shop_logo = shop_logo;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public float getPrice_euro() {
        return price_euro;
    }

    public void setPrice_euro(float price_euro) {
        this.price_euro = price_euro;
    }

    public float getPrice_ori_euro() {
        return price_ori_euro;
    }

    public void setPrice_ori_euro(float price_ori_euro) {
        this.price_ori_euro = price_ori_euro;
    }

    public float getDeliv_cost_euro() {
        return deliv_cost_euro;
    }

    public void setDeliv_cost_euro(float deliv_cost_euro) {
        this.deliv_cost_euro = deliv_cost_euro;
    }

    public int getIn_stock_format() {
        return in_stock_format;
    }

    public void setIn_stock_format(int in_stock_format) {
        this.in_stock_format = in_stock_format;
    }

    public String getIn_stock_value() {
        return in_stock_value;
    }

    public void setIn_stock_value(String in_stock_value) {
        this.in_stock_value = in_stock_value;
    }

    public int getDeliv_nbdays_format() {
        return deliv_nbdays_format;
    }

    public void setDeliv_nbdays_format(int deliv_nbdays_format) {
        this.deliv_nbdays_format = deliv_nbdays_format;
    }

    public String  getDeliv_nbdays_value() {return deliv_nbdays_value; }

    public void setDeliv_nbdays_value(String deliv_nbdays_value) {
        this.deliv_nbdays_value = deliv_nbdays_value;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getPrice_intl() {
        return price_intl;
    }

    public void setPrice_intl(float price_intl) {
        this.price_intl = price_intl;
    }

    public float getPrice_ori_intl() {
        return price_ori_intl;
    }

    public void setPrice_ori_intl(float price_ori_intl) {
        this.price_ori_intl = price_ori_intl;
    }

    public float getDeliv_cost_intl() {
        return deliv_cost_intl;
    }

    public void setDeliv_cost_intl(float deliv_cost_intl) {
        this.deliv_cost_intl = deliv_cost_intl;
    }

    public int getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(int on_sale) {
        this.on_sale = on_sale;
    }

    public int getSale_status() {
        return sale_status;
    }

    public void setSale_status(int sale_status) {
        this.sale_status = sale_status;
    }

    public int getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(int discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public int getOffer_state() {
        return offer_state;
    }

    public void setOffer_state(int offer_state) {
        this.offer_state = offer_state;
    }

    public String getGo_url() {
        return go_url;
    }

    public void setGo_url(String go_url) {
        this.go_url = go_url;
    }

    public String getClick_url() {
        return click_url;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }

    public String getImg_offer() {
        return img_offer;
    }

    public void setImg_offer(String img_offer) {
        this.img_offer = img_offer;
    }

    public String getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(String img_logo) {
        this.img_logo = img_logo;
    }

    public float getCat_cpc() {
        return cat_cpc;
    }

    public void setCat_cpc(float cat_cpc) {
        this.cat_cpc = cat_cpc;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


}
