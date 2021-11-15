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

        String expectedSignture="ewogICJhbGciOiAiUlMyNTYiLAogICJraWQiOiAiMTMzNzQ3MTQxMjU1IiwKICAiaWF0IjogMTAsCiAgImlzcyI6ICJDPUdCLCBMPUxvbmRvbiwgT1U9TnVhcGF5IEFQSSwgTz1OdWFwYXksIENOPXlib3F5YXk5MnEiLAogICJiNjQiOiBmYWxzZSwKICAiY3JpdCI6IFsKICAgICJpYXQiLAogICAgImlzcyIsCiAgICAiYjY0IgogIF0KfQ..cC8RSP8H2mhO4KaXLRAecAWXhJKCsxEGZLdy96uNLwhD-ZdScIEHWqE60IqYQfPXRx3FEEl25hvJn9SexegHo7k7f13y7-qwtno_e2uCzSAPKw9ColknJtaQHMns4EoiUC1rC1WjFZqCQaNEC7uc1CG3mToX1JwPsuDCqp9V8-FcjUfloi5dN_1SrKkyAoBu80DHtVe8PGJ3-MgYZqOiVIS4aSOv9u-7hp-fRXzqZbXHnoXpVRLDckEP_sdYi18i6mBtf7QPupQNzvTGIEppZdp2WQVWkInqv3Dw61I8A5-qo0WPhiuVuhsT2Ookic9i1Gnj-VSBoj8w7WVDAuIRsg";
        RSAPrivateKey key = SignatureUtils.loadTestPrivateKey();
        //simple test payload
        String payload = "{}";
        String signature = SignatureUtils.createSignature(key, payload, "133747141255", 10, "C=GB, L=London, OU=Nuapay API, O=Nuapay, CN=yboqyay92q");
        Assert.assertEquals(expectedSignture,signature);
        System.out.println("signature " + signature);
    }
}
