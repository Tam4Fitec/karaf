/*
* This software is the confidential and proprietary information of LeGuide.com.
* ("Confidential Information").  You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms of the license
* agreement you entered into with LeGuide.com.
*
* LeGuide.com MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
* PURPOSE, OR NON-INFRINGEMENT. LeGuide.com SHALL NOT BE LIABLE FOR ANY DAMAGES
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
* THIS SOFTWARE OR ITS DERIVATIVES.
*
* Use is subject to license terms.
*
*
* Project : LGMobileService
* Copyright (c) 2009-2010 LeGuide.com. All Rights Reserved.
* Company : LeGuide.com
*
* $Id:  $
* $Revision: $
*/
package com.leguide.backoffice.karaf.webservices.client.engine;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Eduardo Francos
 *
 */
public interface IEngineProtocol
{
//	public static final String QUERY_TAG = "query";
//	public static final String PROTOCOL_TAG = "kProtocol";
//	public static final String FUNCTION_TAG = "kFunc";
//	public static final String PAYS_TAG = "kPays";
//	public static final String DELIVERY_ZONE_TAG = "kZone";
//	public static final String SITE_TAG = "kSite";
//	public static final String CATEGORY_TAG = "kCat";
//	public static final String MARK_TAG = "kMark";
//	public static final String WORDS_TAG = "kWords";
//	public static final String PHONETIC_TAG = "kPhonetic";
//	public static final String PROD_COUNT_TAG = "kProdCount";
//	public static final String PAGE_NUMBER_TAG = "kPage";
//	public static final String SORT_TAG = "kSort";
//	public static final String STATUS_MASK_TAG = "kStatusMask";
//	public static final String PRICE_MIN_TAG = "kPriceMin";
//	public static final String PRICE_MAX_TAG = "kPriceMax";
//	public static final String DISCOUNT_MIN_TAG = "kDiscountMin";
//	public static final String DISCOUNT_MAX_TAG = "kDiscountMax";
//	public static final String MARK_COUNT_TAG = "kMarkCount";
//	public static final String ONLY_CAT_TAG = "kOnlyCat";
//	public static final String DATE_MIN_TAG = "kDateMin";
//	public static final String DATE_MAX_TAG = "kDateMax";
//	public static final String PRODUCTS_CRITERIA_TAG = "kCriteria";
//	public static final String CAT_COUNT_TAG = "kCatCount";
//	public static final String SHORTLINKS_TAG = "kShortlinks";
//	public static final String GROUP_PRODUCTS_TAG = "kGroup";
//	public static final String FILTER_TAG = "kFilter";
//	public static final String REVIEWS_SOURCES_TAG = "kReviewsSources";
//
//	
//	
//	public static final String BASE_ID_TAG = "kBaseID";
//	public static final String PHP_TAG = "kPhp";
//	public static final String OCCASION_TAG = "kOccasion";
////	public static final String ???_TAG = "";
////	public static final String ???_TAG = "";
////	public static final String ???_TAG = "";
////	public static final String ???_TAG = "";
//
	public static final long NO_CAT = -1;
	public static final int NO_PRODUCT_GROUPING = -1;
	public static final long NO_CAT_COUNT = -1;
	public static final double NO_PRICE = -1.0;
	public static final short NO_DISCOUNT = -1;
	public static final int NO_MARK_COUNT = -1;
	public static final int NO_SHORTLINKS = -1;
	public static final int NO_REVIEWSOURCES = -1;
	public static final int NO_KFILTER = -1;
//	public static final Calendar NO_DATE = new GregorianCalendar(1900, Calendar.JANUARY, 1);

	public static final String GET_OFFERS_QUERY = "get_offers";
	public static final String PRODUCTS_NET_QUERY = "products_net";
	public static final String LISTE_OFFRES_QUERY = "Liste_offres";
	public static final String PRODUCT_INFO_QUERY = "prod_info";
	public static final String START_PAGE_QUERY = "start_page";
	public static final String INFO_MAG_QUERY = "intra_infomag";
	
}
