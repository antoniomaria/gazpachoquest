package net.sf.gazpachosurvey.repository;

public class MyRegularExpression {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "aBB = bbb OR a = bbb";
        String simple = "(\\S+\\s=\\s\\S+)";
        String compuesta = "(\\S+\\s=\\s\\S+\\s(AND|OR)\\s\\S+\\s=\\s\\S+)";
        String searchCondition = "((\\S+\\s=\\s\\S+\\s(AND|OR)\\s\\S+\\s=\\s\\S+)*)";
        System.out.println(input.matches(compuesta));

    }

}
