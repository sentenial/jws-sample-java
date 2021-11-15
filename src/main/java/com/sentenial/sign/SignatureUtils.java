package com.sentenial.sign;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

public class SignatureUtils {

	private static String[] CRIT = new String [] {"iat","iss","b64"};
	private static JWSAlgorithm alg = JWSAlgorithm.RS256;

	public static RSAPrivateKey loadTestPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		InputStream certIn = SignatureUtils.class.getClassLoader().getResourceAsStream("private.key");
		return (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(PemFileContentReader.getContent(certIn)));
	}


	public static String createSignature(RSAPrivateKey key, String payload, String kid, Object iat, String iss) throws Exception {
		final Map<String, Object> map = new LinkedHashMap<>();
		map.put("alg", alg.getName());
		map.put("kid", kid);
		map.put("iat", iat);
		map.put("iss", iss);
		map.put("b64", false);
		map.put("crit", CRIT);

		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		final String header = Base64.getUrlEncoder().withoutPadding().encodeToString(gson.toJson(map).getBytes());

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		os.write(header.getBytes());
		os.write(0x2e); // ascii for "."
		os.write(payload.getBytes());

		//please note that the new JWSHeader(alg) just selects the algorithm to use to sign the request with.
		return header + ".." + new RSASSASigner( key ).sign(new JWSHeader(alg), os.toByteArray());
	}
}
