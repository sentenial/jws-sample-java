# Introduction
This is sample Java code that will generate a correct JWS Signature for the supplied cert and private key.

# Use your certs
replace tte cert.crt and private.key with your files. The sample private key is PKCS8 encoded. The code is also tailored for PKCS#8 private keys.

The files for this test are expected to be encoded as follows
 - *cert:* pem formatted certificate
 - *private key:* PKCS#8 pem encoded private key
 
# Build
mvn clean test, this will run the unit test.
