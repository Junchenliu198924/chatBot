import java.nio.charset.StandardCharsets;

/**
 * @ Author     ：ljc
 * @ Date       ：Created in 13:54 2023/5/6
 * @ Description：
 */

public class TokenTest {
    public static void main(String[] args) {
        String text = "{\n" +
                "\"role\": \"system\",\n" +
                "\"content\": \"您将是一个智能助手\"\n" +
                "},\n" +
                "{\n" +
                "\"role\": \"user\",\n" +
                "\"content\": \"帮忙写一个100以内挑选质数的方法 用java来写吧\"\n" +
                "}";
        int tokenCount = text.split("\\s+").length + text.length() - text.replaceAll("[\u4e00-\u9fa5]", "").length();
        System.out.println("Estimated token count: " + tokenCount);
    }

    private static int getTokenCount(String text) {
        // 这是一个简化的 token 计数方法，更准确的 token 计数可能需要引入额外的库
        return text.split("\\s+").length;
    }




}
