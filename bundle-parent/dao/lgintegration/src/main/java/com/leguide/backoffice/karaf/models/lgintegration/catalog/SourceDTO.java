package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_source")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingFeedMapping",
                classes= {
                        @ConstructorResult(targetClass=FieldLabelMappingValue.class, columns={
                                @ColumnResult(name="label", type = String.class),
                                @ColumnResult(name="value", type = String.class)})})
})
@NamedQueries({
        @NamedQuery(name = SourceDTO.REQ_FEED_XSL_BY_SOURCEID,
                query = "SELECT xslContent FROM SourceDTO where sourceId = ?")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = SourceDTO.REQ_FEED_MAPPING_TXT_BY_SOURCEID, query = "SELECT rff.fld_label as label, tfm.fmp_map_value as value FROM lgintegration.tb_field_mapping tfm " +
                "inner join lgintegration.rf_field rff on tfm.id_field = rff.id_field where tfm.id_source = ?",
                resultSetMapping = "mappingFeedMapping")
})
public class SourceDTO implements Serializable {

    public static final String REQ_FEED_XSL_BY_SOURCEID = "SourceDTO.getXSLForSourceId";
    public static final String REQ_FEED_MAPPING_TXT_BY_SOURCEID = "SourceDTO.getTextMappingForSourceId";

    private static final long serialVersionUID = 8464220704781973940L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_source")
    private Long sourceId;

    @Column(name = "id_catalog")
    private Long catalogId;

    @Column(name = "src_url")
    private String url;

    @Column(name = "src_field_separator")
    private String fieldSeparator;

    @Column(name = "src_string_delimiter")
    private String stringDelimiter;

    @Column(name = "src_start_line")
    private Integer startLine;

    @Column(name = "src_md5_cli")
    private String md5Cli;

    @Column(name = "src_command")
    private String command;

    @Column(name = "src_command_active")
    private String commandActive;

    @Column(name = "src_last_download")
    private Date lastDownloadDate;

    @Column(name = "src_active")
    private String active;

    @Column(name = "src_encoding")
    private String encoding;

    @Column(name = "src_check_price")
    private String checkPrice;

    @Column(name = "src_response_timeout")
    private Long responseTimeOut;

    @Column(name = "src_download_timeout")
    private Long downloadTimeOut;

    @Column(name = "id_source_type")
    private Integer sourceType;

    @Column(name = "src_command_comment")
    private String commandComment;

    @Column(name = "src_price_affected_by_deee")
    private String priceAffectedByDeee;

    @Column(name = "src_oldPrice_affected_by_deee")
    private String oldPriceAffectedByDeee;

    @Column(name = "src_last_change")
    private Date lastChangeDate;

    @Column(name = "src_md5_original")
    private String md5Original;

    @Column(name = "id_source_format")
    private Long sourceFormatId;

    @Column(name = "src_xsl_content")
    private String xslContent;

    @Column(name = "src_is_xml")
    private String isdXml;

    @Column(name = "src_origin_id")
    private RefOrigin refOriginId;

    @Column(name = "src_cookie")
    private String cookie;

    @Column(name = "src_parameters")
    private String parameters;

    @Column(name = "src_downloaded_by_command")
    private String downloadedByCommand;

    @Column(name = "src_comment")
    private String comment;

    @Column(name = "src_sax_parser")
    private String saxParser;

    @Column(name = "src_download_mode")
    private String downloadMode;


    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFieldSeparator() {
        return fieldSeparator;
    }

    public void setFieldSeparator(String fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
    }

    public String getStringDelimiter() {
        return stringDelimiter;
    }

    public void setStringDelimiter(String stringDelimiter) {
        this.stringDelimiter = stringDelimiter;
    }

    public Integer getStartLine() {
        return startLine;
    }

    public void setStartLine(Integer startLine) {
        this.startLine = startLine;
    }

    public String getMd5Cli() {
        return md5Cli;
    }

    public void setMd5Cli(String md5Cli) {
        this.md5Cli = md5Cli;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandActive() {
        return commandActive;
    }

    public void setCommandActive(String commandActive) {
        this.commandActive = commandActive;
    }

    public Date getLastDownloadDate() {
        return lastDownloadDate;
    }

    public void setLastDownloadDate(Date lastDownloadDate) {
        this.lastDownloadDate = lastDownloadDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(String checkPrice) {
        this.checkPrice = checkPrice;
    }

    public Long getResponseTimeOut() {
        return responseTimeOut;
    }

    public void setResponseTimeOut(Long responseTimeOut) {
        this.responseTimeOut = responseTimeOut;
    }

    public Long getDownloadTimeOut() {
        return downloadTimeOut;
    }

    public void setDownloadTimeOut(Long downloadTimeOut) {
        this.downloadTimeOut = downloadTimeOut;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getCommandComment() {
        return commandComment;
    }

    public void setCommandComment(String commandComment) {
        this.commandComment = commandComment;
    }

    public String getPriceAffectedByDeee() {
        return priceAffectedByDeee;
    }

    public void setPriceAffectedByDeee(String priceAffectedByDeee) {
        this.priceAffectedByDeee = priceAffectedByDeee;
    }

    public String getOldPriceAffectedByDeee() {
        return oldPriceAffectedByDeee;
    }

    public void setOldPriceAffectedByDeee(String oldPriceAffectedByDeee) {
        this.oldPriceAffectedByDeee = oldPriceAffectedByDeee;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getMd5Original() {
        return md5Original;
    }

    public void setMd5Original(String md5Original) {
        this.md5Original = md5Original;
    }

    public String getXslContent() {
        return xslContent;
    }

    public void setXslContent(String xslContent) {
        this.xslContent = xslContent;
    }

    public String getIsdXml() {
        return isdXml;
    }

    public void setIsdXml(String isdXml) {
        this.isdXml = isdXml;
    }


    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getDownloadedByCommand() {
        return downloadedByCommand;
    }

    public void setDownloadedByCommand(String downloadedByCommand) {
        this.downloadedByCommand = downloadedByCommand;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSaxParser() {
        return saxParser;
    }

    public void setSaxParser(String saxParser) {
        this.saxParser = saxParser;
    }

    public String getDownloadMode() {
        return downloadMode;
    }

    public void setDownloadMode(String downloadMode) {
        this.downloadMode = downloadMode;
    }

    public Long getSourceFormatId() {
        return sourceFormatId;
    }

    public void setSourceFormatId(Long sourceFormatId) {
        this.sourceFormatId = sourceFormatId;
    }

    public RefOrigin getRefOriginId() {
        return refOriginId;
    }

    public void setRefOriginId(RefOrigin refOriginId) {
        this.refOriginId = refOriginId;
    }


}
