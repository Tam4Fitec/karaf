DROP TABLE IF EXISTS tb_source;

CREATE TABLE tb_source (
  id_source int(10) NOT NULL AUTO_INCREMENT,
  src_url text COMMENT 'Url of the source',
  src_field_separator int(3) NOT NULL COMMENT 'ASCII code for the separator character in the source',
  src_string_delimiter int(3) DEFAULT NULL COMMENT 'ASCII code for the string  delimiter character inside the fields in the source',
  src_start_line smallint(5) NOT NULL DEFAULT '0' COMMENT 'Number of the line containing the first offer; in order to remove header lines',
  src_md5_cli char(32) DEFAULT NULL COMMENT 'Processed MD5 for the source',
  src_command text COMMENT 'Path to the command that must be launched before the source processing',
  src_command_active char(1) DEFAULT 'N' COMMENT 'Command active (Y/N)?',
  src_last_download datetime DEFAULT NULL COMMENT 'The last time the source was crawled (downloaded)',
  src_active char(1) NOT NULL DEFAULT 'Y' COMMENT 'Source active (Y/N) ?',
  src_encoding varchar(20) NOT NULL DEFAULT 'ISO-8859-1' COMMENT 'Encoding of the source',
  src_check_price char(1) NOT NULL DEFAULT 'Y' COMMENT 'Flag to indicate (Y/N) if prices must be checked. If the flag is ''Y'', then prices with 0 as value are invalid. For sources with mobile phone offers where prices can be 0, it is necessary to set this flag to ''N''',
  src_response_timeout smallint(5) NOT NULL DEFAULT '30',
  src_download_timeout smallint(5) NOT NULL DEFAULT '600',
  id_catalog int(10) NOT NULL,
  id_source_type int(10) NOT NULL,
  src_command_comment varchar(256) NOT NULL DEFAULT '',
  src_price_affected_by_deee char(1) NOT NULL DEFAULT 'Y' COMMENT 'Flag to indicate (Y/N) if prices are affected by deee',
  src_oldPrice_affected_by_deee char(1) NOT NULL DEFAULT 'Y' COMMENT 'Flag to indicate (Y/N) if old prices are affected by deee',
  src_last_change datetime DEFAULT NULL COMMENT 'The last time the source has changed (downloaded and compared)',
  src_md5_original char(32) DEFAULT NULL COMMENT 'MD5 of the downloaded source',
  id_source_format int(10) NOT NULL DEFAULT '1' COMMENT '1 For the undefined source format',
  src_xsl_content text,
  src_is_xml char(1) DEFAULT NULL,
  src_origin_id int(10) DEFAULT NULL,
  src_cookie char(1) DEFAULT '0',
  src_parameters char(255) DEFAULT NULL,
  src_downloaded_by_command char(1) DEFAULT '0',
  src_comment varchar(1000) DEFAULT NULL,
  src_sax_parser char(1) DEFAULT '0',
  src_download_mode int(10) DEFAULT '0',
  PRIMARY KEY (id_source)
);

INSERT INTO tb_source VALUES ('35488', 'http://flux.lengow.com/shopbot/leguidecom-reviews/7017/txt/', '124', '0', '1', '', '', 'N',
'2013-11-07 11:02:42', 'Y', 'ISO-8859-1', 'Y', '30', '600', '24901', '3', '', 'Y', 'Y', NULL, '', '1', 'xsl_content', 'N', NULL, '0', NULL, '0', '', '0', NULL);