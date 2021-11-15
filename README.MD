# introduction
This is sample Java code that will generate a correct JWS Signature for the supplied cert and private key.

# use your certs
replace hte cert.crt and private.key with your files. The sample private key is PKCS8 encoded.

The files for this test are expected to be encoded as follows
*cert* pem formatted certificate
*private key* PKCS#8 pem encoded private key
 
# build
mvn clean test, this will run the unit test.
