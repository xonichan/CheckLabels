import java.util.Arrays;
import java.util.List;

public class checkLabels {

    //Абстрогированный фильтр в интерфейса
    interface TextAnalyzer {
        Label processText(String text);
    }

    //тип-перечисление, которые содержит метки, которыми будем помечать текст
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }


    //Основной метод
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {

        return Label.OK;
    }



    public void run(String[] args) {


        // тесты

        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        //System.out.println(textAnalyzers1.);

        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        checkLabels testObject = new checkLabels();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++; 
        }
        System.out.println("Fin");
    }

    public static void main(String[] args) {
        System.out.println("Go!");
        try {
            checkLabels obj = new checkLabels();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SpamAnalyzer implements TextAnalyzer {
        List<String> spamArr;

        public SpamAnalyzer(String[] spamKeywords) {
            if (spamKeywords != null) {
                spamArr = Arrays.asList(spamKeywords);
                System.out.println("add");
            }

        }

        @Override
        public Label processText(String text) {
            return null;
        }
    }

    private class NegativeTextAnalyzer implements TextAnalyzer {
        @Override
        public Label processText(String text) {
            return null;
        }
    }

    private class TooLongTextAnalyzer implements TextAnalyzer {
        int comment_MaxLength;

        public TooLongTextAnalyzer(int commentMaxLength) {
            if (commentMaxLength>0) {
                comment_MaxLength = commentMaxLength;
                System.out.println("add MaxLength");
            }
        }

        @Override
        public Label processText(String text) {
            return null;
        }
    }
}
