package com.leguide.backoffice.karaf.bundle.librairies.security.hmac;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class SecurityEncoderTest {

    private SecurityEncoder encoder = new SecurityEncoderImpl();

    @Test
    public void testMD5() throws NoSuchAlgorithmException {
        assertEquals("hwNMvbNt3OeuPqqbYOIQHg==", encoder.calculateMD5("this is a test -8 -9 \n"));
    }

    @Test
    public void testHMAC() throws NoSuchAlgorithmException, InvalidKeyException {
        SecurityEncoderParam param = new SecurityEncoderParam();
        //System.out.println(param.getUrl());
        //System.out.println(param.getMethod());
        //System.out.println(param.getMd5());
        //System.out.println(param.getContentType());
       // System.out.println(param.getSalt());
        param.setMethod("GET");
        param.setUrl("/test/test");
        param.setContentType("text");
        param.setMd5("hwNMvbNt3OeuPqqbYOIQHg==");
        param.setSalt("1970-02-01:15h36");
        assertEquals("6fBsqksw3PITTLVO0aRnr5jRApU=", encoder.signHmacSha1("this is a secret", param));
        
        assertNotEquals("6fBsqksw3PITTLVO0aRnr5jRApU=", encoder.signHmacSha1("this is another secret", param));
    }
}
