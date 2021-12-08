package com.leguide.backoffice.karaf.bundle.librairies.security.hmac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface SecurityEncoder {

    String signHmacSha1(String secret, SecurityEncoderParam param) throws NoSuchAlgorithmException,
            InvalidKeyException;

    String calculateMD5(String contentToEncode) throws NoSuchAlgorithmException;

}
