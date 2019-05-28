package gold.topic3.interfaces;

import java.util.StringJoiner;

public class Main {

    public static void main(String... args) {

        final AddressFormatter rc = (String prefecture, String city, String sub) -> {
            var buf = new StringJoiner(System.lineSeparator());
            return buf.add(prefecture).add(city).add(sub).toString();
        };

        System.out.println(rc.formatPostCode(12, 34));
        System.out.println(rc.formatAddress("M県", "N市", "XXX 103号室"));

    }

}
