package gold.topic3.interfaces;

import java.util.StringJoiner;
import java.util.stream.IntStream;

@FunctionalInterface
public interface AddressFormatter {

    /**
     * 郵便マーク<br/>
     */
    public static final String POST_MARK = "〒";

    /**
     * 郵便番号の区切り文字<br/>
     */
    public static final String POST_CODE_DELIMITER = "-";

    /**
     * 住所をフォーマットする。<br/>
     * @param prefecture 都道府県。
     * @param city 市区町村。
     * @param subs 以降の住所。
     * @return フォーマット済み住所を返却する。
     */
    String formatAddress(String prefecture, String city, String... subs);

    /**
     * 郵便番号をフォーマットする。<br/>
     * <p>
     * 実装先のクラスで処理が定義されなかった場合、
     * デフォルトで記述してある処理が実装される。
     * </p>
     * @param first 郵便番号上3桁。
     * @param last 郵便番号下4桁。
     * @return フォーマット済み郵便番号を返却する。
     */
    default String formatPostCode(int first, int last) {
        var builder = new StringBuilder(9)
                .append(POST_MARK)
                .append(paddingLeft(3, '0', first))
                .append(POST_CODE_DELIMITER)
                .append(paddingLeft(4, '0', last));
        return builder.toString();
    }

    /**
     * 左にパディングする。<br/>
     * <p>
     * interfaceでprivate修飾子を使用することができる。
     * defaultメソッド内で再利用することを目的としている。
     * </p>
     * @param padCnt パディング数。
     * @param padChar パディング文字。
     * @param value パディング対象の値。
     * @return 整数をパディングした値を返却する。
     */
    private String paddingLeft(int padCnt, char padChar, int value) {
        final String padStr = IntStream
                .range(0, padCnt)
                .mapToObj(num -> padChar)
                .map(String::valueOf)
                .reduce((x1, x2) -> x1.concat(x2))
                .orElse("");
        final String padded = padStr.concat(Integer.valueOf(value).toString());
        return padded.substring(padded.length() - padCnt);
    }

}
