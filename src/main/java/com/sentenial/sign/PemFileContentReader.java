package com.sentenial.sign;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Pattern;

/**
 * Gets the input stream and removes the header and footer that are not needed.
 * Decodes the base64 contents into raw bytes
 */
final class PemFileContentReader {

    private static final Pattern PEM_FILE_PATTERN = Pattern.compile("(?m)(?s)^---*BEGIN.*---*$(.*)^---*END.*---*$.*");

    static byte[] getContent(final InputStream resource) throws IOException {
            String pem = new String(resource.readAllBytes(), StandardCharsets.ISO_8859_1);
            String encoded = PEM_FILE_PATTERN.matcher(pem).replaceFirst("$1");
            return Base64.getMimeDecoder().decode(encoded);
    }

}
