public class checkLabels {

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        return Label.OK;
    }


    public  void run(String[] args){
        System.out.println("Fun");

    }

    public static void main(String[] args){
        System.out.println("Go!");
        try
        {
            checkLabels obj = new checkLabels ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }

}
