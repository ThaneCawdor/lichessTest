package lichessTest;

import org.apache.commons.lang3.RandomStringUtils;
public class Storage {
    public final static String Url = "https://lichess.org/login?referrer=/ru";
    public final static String login = "Naaaaaaa";
    public final static String password = "trollivalli";
    public final static String specialCharacters = "!»№;%:?*()_+.,}{}[];:’”`~";
    public final static String registerLogin = "NaaaAaaa";
    public final static String registerPassword = "troLLivalli";
    public final static String translitLogin = "Naaaaaaа";
    public final static String translitPassword = "trollivаlli";
    public final static String sqlInjection = "a’ OR 1=1;--";
    public final static String randomString = RandomStringUtils.randomAlphanumeric(10);
}
