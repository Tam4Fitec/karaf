package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_source_format")
public class SourceFormatDTO implements Serializable {

	private static final long serialVersionUID = 9157047260471508954L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_source_format")
	private Long id_source_format;

	@JoinColumn(name="id_format")
	private Long id_format;
	
	@Column(name = "sfo_version")
	private Long sfo_version;

	@Column(name = "sfo_comment")
	private String sfo_comment;

	public Long getId_format() {
		return id_format;
	}

	public void setId_format(Long id_format) {
		this.id_format = id_format;
	}

	public String getSfo_comment() {
		return sfo_comment;
	}

	public void setSfo_comment(String sfo_comment) {
		this.sfo_comment = sfo_comment;
	}

	public Long getSfo_version() {
		return sfo_version;
	}

	public void setSfo_version(Long sfo_version) {
		this.sfo_version = sfo_version;
	}

	public Long getId_source_format() {
		return id_source_format;
	}

	public void setId_source_format(Long id_source_format) {
		this.id_source_format = id_source_format;
	}
}
