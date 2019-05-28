package gold.topic3.interfaces;

import java.util.Arrays;
import java.util.StringJoiner;

public class Main {

    public static void main(String... args) {

        final AddressFormatter rc = (String prefecture, String city, String... subs) -> {
            var buf = new StringJoiner(System.lineSeparator()).add(prefecture).add(city);
            Arrays.stream(subs).forEachOrdered(buf::add);
            return buf.toString();
        };

        System.out.println(rc.formatPostCode(12, 34));
        System.out.println(rc.formatAddress("M県", "N市", "XXX 103号室"));

    }

}
