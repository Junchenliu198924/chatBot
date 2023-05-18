/**
 * @ Author     ：ljc
 * @ Date       ：Created in 13:54 2023/5/6
 * @ Description：
 */

public class TokenTest {
    public static void main(String[] args) {

    }

    private static int getTokenCount(String text) {
        // 这是一个简化的 token 计数方法，更准确的 token 计数可能需要引入额外的库
        return text.split("\\s+").length;
    }
}
