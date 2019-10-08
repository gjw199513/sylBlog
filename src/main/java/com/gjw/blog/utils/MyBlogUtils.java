package com.gjw.blog.utils;

import java.net.URI;

/**
 * @author gjw19
 * @since 2019/10/8.
 */
public class MyBlogUtils {
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
