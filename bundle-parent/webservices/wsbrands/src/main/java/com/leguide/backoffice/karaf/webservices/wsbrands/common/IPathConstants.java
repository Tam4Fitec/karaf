package com.leguide.backoffice.karaf.webservices.wsbrands.common;

/**
 * Interface holding path constants used in the REST WS 
 * @author cbaudoin
 *
 */
public interface IPathConstants {

    //path
	 String PATH_MAP = "map";
	 String PATH_REJECT = "reject";
	 String PATH_ID = "id";
	 String PATH_NAME = "name";
	 String PATH_SEONAME = "seoname";
	 String PATH_RESETSEONAME = "resetseoname";
	 String PATH_MAPPED_ID = "mappedid";
	 String PATH_TYPE = "type";
	 String PATH_BLACKLIST = "blacklist";
	 String PATH_UNBLACKLIST = "unblacklist";
	 String PATH_DATATABLE = "datatable";
	 String PATH_PRIORITY = "priority";
	 String PATH_SET_SEO_NAME = "seoname";
    
    //param
     String PARAM_BRAND_ID = "brandid";
     String PARAM_BRAND_IDS_LIST = "idList";
     String PARAM_BRAND_NAME = "brandname";
     String PARAM_TMP_BRAND_ID = "tmpbrandid";
     String PARAM_MAPPED_ID = "mappedid";        
    
    //query
     String QUERY_LIMIT = "limit";
     String QUERY_PAGE = "page";
     String QUERY_TYPE = "type";
     String QUERY_ID = "id";
     String QUERY_NAME = "name";
     String QUERY_STATUS = "status";
     String QUERY_ALIAS = "alias";
     String QUERY_USE_SEO_NAME = "useSeoName";
     String QUERY_ACTIVATION_DATE = "activationDate";
     String QUERY_MODIFICATION_DATE = "modificationDate";
     String QUERY_SEARCH = "search";
     String QUERY_ORDER = "order";
     String QUERY_ORDER_TYPE = "orderType";
     String QUERY_FORCE = "force";
     String QUERY_MAPPED_TYPE = "mappedType";
     String QUERY_PRIORITY = "priority";
     String QUERY_PRIORITY_TYPE = "priorityType";
     
     String QUERY_FILTER_ID = "id_search";
     String QUERY_FILTER_NAME = "name_search";
     String QUERY_FILTER_STATUS = "status_search";
     String QUERY_FILTER_MAPPED_TYPE = "mappedType_search";
     String QUERY_FILTER_INSERTION_DATE = "insertionDate_search";
     String QUERY_FILTER_MODIFICATION_DATE = "modificationDate_search";
     String QUERY_FILTER_PRIORITY = "priority_search";
     String QUERY_FILTER_GLOBAL_SEARCH = "global_search";
    

    //root path
     String ROOT_PATH = "services";
    
	// default query    
     String DEFAULT_ALIAS_PARAM = "false";
     String DEFAULT_USE_SEO_NAME_PARAM = "false";
     String DEFAULT_FORCE_PARAM = "false";
     String DEFAULT_SEARCH_TYPE_PARAM = "exact";
}