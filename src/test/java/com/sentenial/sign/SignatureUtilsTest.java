package com.sentenial.sign;

import org.junit.Assert;
import org.junit.Test;

import java.security.interfaces.RSAPrivateKey;

/**
 * Note the signature is detached. The exact request body that goes out on the wire needs to be the payload we sign here.
 * If your request is pretty printed as part of your object serialisation it needs to pretty printed when signing too.
 */
public class SignatureUtilsTest {


    @Test
    public void testSignature() throws Exception {

        String expectedSignture="ewogICJhbGciOiAiUlMyNTYiLAogICJraWQiOiAiMTMzNzQ3MTQxMjU1IiwKICAiaWF0IjogMCwKICAiaXNzIjogIkM9R0IsIEw9TG9uZG9uLCBPVT1OdWFwYXkgQVBJLCBPPU51YXBheSwgQ049eWJvcXlheTkycSIsCiAgImI2NCI6IGZhbHNlLAogICJjcml0IjogWwogICAgImlhdCIsCiAgICAiaXNzIiwKICAgICJiNjQiCiAgXQp9..d_cZ46lwNiaFHAu_saC-Zz4rSzNbevWirO94EmBlbOwkB1L78vGbAnNjUsmFSU7t_HhL-cyMiQUDyRWswsEnlDljJsRi8s8ft48ipy2SMuZrjPpyYYMgink8nZZK7l-eFJcTiS9ZWezAAXF_IJFXSTO5ax9z6xty3zTNPNMV9W7aH8fEAvbUIiueOhH5xNHcsuqlOGygKdFz2rbjTGffoE_6zS4Dry-uX5mts2duLorobUimGsdlUcSM6P6vZEtcXaJCdjrT9tuFMh4CkX9nqk19Bq2z3i-SX4JCPvhD2r3ghRmX0gG08UcvyFVbrnVZJnpl4MU8V4Nr3-2M5URZOg";
        RSAPrivateKey key = SignatureUtils.loadTestPrivateKey();
        //simple test payload
        String payload = "{}";
        String signature = SignatureUtils.createSignature(key, payload, "133747141255", 0, "C=GB, L=London, OU=Nuapay API, O=Nuapay, CN=yboqyay92q");
        Assert.assertEquals(expectedSignture,signature);
        System.out.println("signature " + signature);
    }
}
