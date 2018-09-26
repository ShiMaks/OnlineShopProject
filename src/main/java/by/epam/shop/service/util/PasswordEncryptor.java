package by.epam.shop.service.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Class that encrypt password using MD5 algorithm
 *
 * @author Maksim Shilvian
 *
 */
public final class PasswordEncryptor {

    public static String md5Apache(String st) {
        return DigestUtils.md5Hex(st);
    }
}
