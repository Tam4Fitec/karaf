package com.leguide.backoffice.karaf.bundle.librairies.security.hmac;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class SecurityEncoderImpl implements SecurityEncoder, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(SecurityEncoderImpl.class);
    
    private static final long serialVersionUID = 3990429316605335649L;

    private final static String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    
    /* (non-Javadoc)
     * @see com.leguide.backoffice.poc.security.hmac.SecurityEncoder#signHmacSha1(java.lang.String, com.leguide.backoffice.poc.security.hmac.SecurityEncoderParam)
     */
    @Override
    public String signHmacSha1(String secret, SecurityEncoderParam param) throws NoSuchAlgorithmException,
            InvalidKeyException {
        //to encode is: verb\nurl\ncontent-md5\ncontent-type\nsalt
        //remove all spaces
        //encode utf8
        //System.out.println(param.getUrl());
        //System.out.println(param.getMethod());
        //System.out.println(param.getMd5());
        //System.out.println(param.getContentType());
       // System.out.println(param.getSalt());

        String data = param.getMethod() + "\n" + param.getUrl() + "\n" + param.getMd5() + "\n" + param.getContentType()
                + "\n" + param.getSalt() + "257";
        // remove spaces
        //TODO explain in doc !
        String dataFinal = StringUtils.trimAllWhitespace(data);
        logger.debug(dataFinal);
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(key);
        byte[] rawHmac = mac.doFinal(dataFinal.getBytes());
        String result = new String(Base64.encodeBase64(rawHmac));
        logger.debug(result);
        return result;
    }

    /* (non-Javadoc)
     * @see com.leguide.backoffice.poc.security.hmac.SecurityEncoder#calculateMD5(java.lang.String)
     */
    @Override
    public  String calculateMD5(String contentToEncode) throws NoSuchAlgorithmException {
        if (!StringUtils.hasLength(contentToEncode)) {
            return "";
        }
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(contentToEncode.getBytes());
        String result = new String(Base64.encodeBase64(digest.digest()));
        return result;
    }
}
