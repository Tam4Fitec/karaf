package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "rf_language")
@XmlRootElement(name = "LgshopRefLanguage")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingLocale", columns = {
                @ColumnResult(name = "lbl_locale")}),
        @SqlResultSetMapping(name = "mappingIdLanguage", columns = {
                @ColumnResult(name = "id_language")}),
        @SqlResultSetMapping(name = "mappingLanguage", columns = {
                @ColumnResult(name = "language")}),
        @SqlResultSetMapping(name = "mappingIdLanguageByCode", columns = {
                @ColumnResult(name = "id_language")}),
        @SqlResultSetMapping(name = "mappingLocaleName", columns = {
                @ColumnResult(name = "localename")})
})
@NamedNativeQueries({
        @NamedNativeQuery(name = LgshopRefLanguage.FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ID, query = "SELECT rlab.lbl_locale FROM rf_language rlan INNER JOIN rf_label rlab ON rlan.id_language = rlab.id_label AND rlab.lbl_namespace = 'display_lang' AND rlab.lbl_enabled = 'Y'  "
                + " inner JOIN rf_country rc ON  rlan.country = rc.cty_alpha2_code WHERE rc.cty_internal_number = ? AND rlan.id_language = ?", resultClass = String.class,
                resultSetMapping = "mappingLocale"),
        @NamedNativeQuery(name = LgshopRefLanguage.FIND_ID_LANGUAGE_BY_COUNTRY_ID, query = "SELECT rlan.id_language FROM rf_country rc INNER JOIN rf_language rlan ON rc.cty_alpha2_code = rlan.country WHERE rc.cty_internal_number = ?", resultClass = Number.class,
                resultSetMapping = "mappingIdLanguage"),
        @NamedNativeQuery(name = LgshopRefLanguage.FIND_LANGUAGE_BY_LANG_ID_AND_COUNTRY_ID, query = "SELECT rlan.language FROM rf_country rc INNER JOIN rf_language rlan ON rc.cty_alpha2_code = rlan.country WHERE rlan.id_language = ? and rc.cty_internal_number = ?", resultClass = String.class,
                resultSetMapping = "mappingLanguage"),
        @NamedNativeQuery(name = LgshopRefLanguage.FIND_ID_LANGUAGE_BY_CODE, query = "SELECT distinct rlan.id_language FROM rf_language rlan WHERE rlan.language = ?", resultClass = Number.class,
                resultSetMapping = "mappingIdLanguageByCode"),
        @NamedNativeQuery(name = LgshopRefLanguage.FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ALPHA2, query = "SELECT distinct rlan.localename FROM rf_language rlan WHERE rlan.id_language = ? and rlan.country =? ", resultClass = String.class,
                resultSetMapping = "mappingLocaleName"),
})
public class LgshopRefLanguage implements Serializable {

    private static final long serialVersionUID = 3921359631952255896L;

    public static final String FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ID = "LgshopRefLanguage.findLocaleByLanguageIdAndCountryId";
    public static final String FIND_LANGUAGE_BY_LANG_ID_AND_COUNTRY_ID = "LgshopRefLanguage.findLanguageByLanguageIdAndCountryId";
    public static final String FIND_ID_LANGUAGE_BY_COUNTRY_ID = "LgshopRefLanguage.findIdLanguageByCountry";
    public static final String FIND_ID_LANGUAGE_BY_CODE = "LgshopRefLanguage.findIdLanguageByCode";
    public static final String FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ALPHA2 = "LgshopRefLanguage.findLocaleByLanguageIdAndCountryAlpha2";

    @Id
    @Column(name = "id_language")
    private Byte languageId;

    @Column(name = "localename")
    private String localename;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "encoding")
    private String encoding;

    @Column(name = "mimecharset")
    private String mimecharset;

    public Byte getLanguageId() {
        return languageId;
    }

    public void setLanguageID(Byte languageId) {
        this.languageId = languageId;
    }

    public String getLocalename() {
        return localename;
    }

    public void setLocalename(String localename) {
        this.localename = localename;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getMimecharset() {
        return mimecharset;
    }

    public void setMimecharset(String mimecharset) {
        this.mimecharset = mimecharset;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
