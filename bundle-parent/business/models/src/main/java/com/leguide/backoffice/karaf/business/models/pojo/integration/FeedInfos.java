package com.leguide.backoffice.karaf.business.models.pojo.integration;

import java.io.Serializable;

public class FeedInfos implements Serializable {
	

	private static final long serialVersionUID = -768473401558524326L;
	
	private Long sourceId;
	private Long shopsiteId;
	private Long storeId;
	private String country;
	private String url;
	private Integer separator;
	private Integer delimiter;
	private Integer startLine;
	private String encoding;
	private Boolean xml;
	private Boolean saxParser;
	private Long catalogId;
	private String typeSource;
	
	
	public Long getShopsiteId() {
		return shopsiteId;
	}
	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSeparator() {
		return separator;
	}
	public void setSeparator(Integer separator) {
		this.separator = separator;
	}
	public Integer getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(Integer delimiter) {
		this.delimiter = delimiter;
	}
	public Integer getStartLine() {
		return startLine;
	}
	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Boolean getXml() {
		return xml;
	}
	public void setXml(Boolean xml) {
		this.xml = xml;
	}
	
	public Boolean getSaxParser() {
		return saxParser;
	}
	public void setSaxParser(Boolean saxParser) {
		this.saxParser = saxParser;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getTypeSource() {
		return typeSource;
	}

	public void setTypeSource(String typeSource) {
		this.typeSource = typeSource;
	}

	@Override
	public String toString() {
		return "FeedInfos [sourceId=" + sourceId + ", shopsiteId=" + shopsiteId
				+ ", storeId=" + storeId + ", country=" + country + ", url="
				+ url + ", separator=" + separator + ", delimiter=" + delimiter
				+ ", startLine=" + startLine + ", encoding=" + encoding
				+ ", xml=" + xml + ", saxParser=" + saxParser + "]";
	}
	
}
