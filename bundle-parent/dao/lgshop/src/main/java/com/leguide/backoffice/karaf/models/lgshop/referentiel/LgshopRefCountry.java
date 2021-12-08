package com.leguide.backoffice.karaf.models.lgshop.referentiel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import static com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefCountry.*;

@Entity
@Table(name="rf_country")
@XmlRootElement(name = "LgshopRefCountry")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingInternalId", columns = {
                @ColumnResult(name = "cty_internal_number")}),
        @SqlResultSetMapping(name = "mappingAlphaCode", columns = {
                @ColumnResult(name = "cty_alpha2_code")})
})
@NamedNativeQueries({
	@NamedNativeQuery(name=FIND_INTERNAL_ID_COUNTRY_BY_ALPHA2CODE, query="SELECT rc.cty_internal_number FROM rf_country rc WHERE rc.cty_alpha2_code = ?", resultClass = Number.class,
            resultSetMapping = "mappingInternalId"),
	@NamedNativeQuery(name=FIND_ALPHA2CODE_COUNTRY_BY_INTERNAL_ID, query="SELECT rc.cty_alpha2_code FROM rf_country rc WHERE rc.cty_internal_number = ?", resultClass = String.class,
            resultSetMapping = "mappingAlphaCode")
})
public class LgshopRefCountry implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1806311721293101217L;

	public static final String FIND_INTERNAL_ID_COUNTRY_BY_ALPHA2CODE = "findInternalIdCountryByAlpha2Code";
	public static final String FIND_ALPHA2CODE_COUNTRY_BY_INTERNAL_ID = "findAlpha2CodeCountryByInternalId";


	@Id
	@Column(name="id_country")
	private Integer countryId;

	@Column(name="cty_name")
	private String name;

	@Column(name="cty_alpha2_code")
	private String alpha2code;

	@Column(name="cty_alpha3_code")
	private String alpha3code;

	@Column(name="cty_vat")
	private Float vat;

	@Column(name="cty_conversion")
	private Float conversion;

	@Column(name="cty_currency")
	private String currency;

	@Column(name="cty_internal_number")
	private Byte internalNumber;

	@Column(name="cty_leguide_country")
	private String leguideCountry;

	@Column(name="cty_time_zone")
	private String timeZone;

	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alpha2code
	 */
	public String getAlpha2code() {
		return alpha2code;
	}

	/**
	 * @param alpha2code the alpha2code to set
	 */
	public void setAlpha2code(String alpha2code) {
		this.alpha2code = alpha2code;
	}

	/**
	 * @return the alpha3code
	 */
	public String getAlpha3code() {
		return alpha3code;
	}

	/**
	 * @param alpha3code the alpha3code to set
	 */
	public void setAlpha3code(String alpha3code) {
		this.alpha3code = alpha3code;
	}

	/**
	 * @return the vat
	 */
	public Float getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(Float vat) {
		this.vat = vat;
	}

	/**
	 * @return the conversion
	 */
	public Float getConversion() {
		return conversion;
	}

	/**
	 * @param conversion the conversion to set
	 */
	public void setConversion(Float conversion) {
		this.conversion = conversion;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the internalNumber
	 */
	public Byte getInternalNumber() {
		return internalNumber;
	}

	/**
	 * @param internalNumber the internalNumber to set
	 */
	public void setInternalNumber(Byte internalNumber) {
		this.internalNumber = internalNumber;
	}

	/**
	 * @return the leguideCountry
	 */
	public String getLeguideCountry() {
		return leguideCountry;
	}

	/**
	 * @param leguideCountry the leguideCountry to set
	 */
	public void setLeguideCountry(String leguideCountry) {
		this.leguideCountry = leguideCountry;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}



}
