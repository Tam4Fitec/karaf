package com.leguide.backoffice.karaf.bundle.librairies.security.hmac;

import java.io.Serializable;

public class SecurityEncoderParam implements Serializable {

    private static final long serialVersionUID = -4017366603698669319L;

    private String md5;
    private String contentType;
    private String method;
    private String url;
    private String salt;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "SecurityEncoderParam [md5=" + md5 + ", contentType=" + contentType + ", method=" + method + ", url="
                + url + ", salt=" + salt + "]";
    }

    
}
