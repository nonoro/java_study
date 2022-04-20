package ch07.interface07;

interface Parseable {
    //  구문 분석작업을 수행한다.
    public abstract void parse(String fileName);
}

class ParserManager {
    //  리턴타입이 Parseable인터페이스이다.
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable parser = new HTMLParser();
            return parser;
            //  return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {
    @Override
    public void parse(String fileName) {
        /* 구문 분석작업을 수행하는 코드를 적는다 */
        System.out.println(fileName + "- XML parsing completed.");
    }
}

class HTMLParser implements Parseable {
    @Override
    public void parse(String fileNme) {
        /* 구문 분석작업을 수행하는 코드를 적는다 */
        System.out.println(fileNme + "- HML parsing completed.");
    }
}

class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
//        Parseable parser = new XMLParser();
        parser.parse("document.xml");
        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");

    }
}