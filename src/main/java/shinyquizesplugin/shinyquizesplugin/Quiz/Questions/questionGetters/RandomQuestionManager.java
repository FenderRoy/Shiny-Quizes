package shinyquizesplugin.shinyquizesplugin.Quiz.Questions.questionGetters;

import org.bukkit.configuration.file.FileConfiguration;
import shinyquizesplugin.shinyquizesplugin.Mangers.ConfigManager;
import shinyquizesplugin.shinyquizesplugin.Mangers.Messengers.ServerCommunicator;
import shinyquizesplugin.shinyquizesplugin.Quiz.CustomQuestionsManager;
import shinyquizesplugin.shinyquizesplugin.Quiz.Questions.ShuffledWordQuestionManager;
import shinyquizesplugin.shinyquizesplugin.Quiz.Questions.TypeWordQuestionManager;

import java.util.ArrayList;
import java.util.List;

public class RandomQuestionManager {

    public static List<questionGetter> activeQuestions = new ArrayList<>();

    public static void initialize(){

        activeQuestions.clear();
        FileConfiguration config = ConfigManager.getConfig();

        if(config.getBoolean("enableMathQuestions")) activeQuestions.add(new MathQuestionGetter());
        if(config.getBoolean("enableCustomQuestions") && !CustomQuestionsManager.getCustomQuestionList().isEmpty()) activeQuestions.add(new CustomQuestionGetter());
        if(config.getBoolean("enableShuffledWordQuestions") && !ShuffledWordQuestionManager.shuffledWordList.isEmpty()) activeQuestions.add(new ShuffledWordGetter());
        if(config.getBoolean("enableTypeWordQuestions") && !TypeWordQuestionManager.typeWordList.isEmpty()) activeQuestions.add(new TypedWordGetter());

        ServerCommunicator.sendConsoleMessage("Er zijn "+activeQuestions.size()+" actieve random questions.");
    }

}