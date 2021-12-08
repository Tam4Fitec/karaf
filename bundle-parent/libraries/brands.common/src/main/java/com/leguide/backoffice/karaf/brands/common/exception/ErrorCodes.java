package com.leguide.backoffice.karaf.brands.common.exception;

public enum ErrorCodes {

    /**
     * Default code - unhandled error
     */
    ERR000,
    /**
     * missing parameter brand names list for checkGreyList
     */
    ERR001,
    /**
     * missing parameter locale for checkGreyList
     */
    ERR002,
    /**
     * missing parameter idThes for checkGreyList
     */
    ERR003,
    /**
     * missing post request
     */
    ERR004,
    /**
     * DB exception
     */
    ERR005,
    /**
     * Error parsing parameter
     */
    ERR006;
}
