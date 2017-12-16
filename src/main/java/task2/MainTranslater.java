package task2;


public class MainTranslater {
    public static void main(String[] args) {
        Translater translater = new Translater();

        translater.addWord("Undo", "Розкуй");
        translater.addWord("these", "цi");
        translater.addWord("chains", "ланцюги");
        translater.addWord("my", "мiй");
        translater.addWord("friend", "друже");

        System.out.println(translater.translate("undo"));

    }
}
