package com.leguide.backoffice.karaf.models.lgintegration.custom;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FeedInfosDTO implements Serializable{

	private static final long serialVersionUID = -3914786868928808392L;
	
	@Id
	@Column(name="id_source")
	private Long sourceId;
	
	@Column(name="id_shopsite")
	private Long shopsiteId;
	
	@Column(name="store_id")
	private Long storeId;
	
	@Column(name="country")
	private String country;
	
	@Column(name="src_url")
	private String url;
	
	@Column(name="src_field_separator")
	private Integer separator;
	
	@Column(name="src_string_delimiter")
	private Integer delimiter;
	
	@Column(name="src_start_line")
	private Integer startLine;
	
	@Column(name="src_encoding")
	private String encoding;
	
	@Column(name="src_is_xml")
	private boolean xml;
	
	@Column(name="src_sax_parser")
	private boolean saxParser;
	
	
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
	public boolean isXml() {
		return xml;
	}
	public void setXml(boolean xml) {
		this.xml = xml;
	}
	public boolean isSaxParser() {
		return saxParser;
	}
	public void setSaxParser(boolean saxParser) {
		this.saxParser = saxParser;
	}
	
}
