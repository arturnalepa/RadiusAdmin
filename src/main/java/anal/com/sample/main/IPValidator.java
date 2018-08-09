package anal.com.sample.main;

import java.util.regex.Pattern;

public class IPValidator {

    private Pattern pattern;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    boolean validateIP(String ipStr) {
        boolean valid = false;
        return Pattern.matches(IPADDRESS_PATTERN, ipStr);
    }

    boolean validateIPOctets(String ipStr) {
        boolean validoc = false;
        String regex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
        return Pattern.matches(regex, ipStr);
    }

    public IPValidator() {
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }
}
