package norman.com.learningproject;

/**
 * Created by norman on 8/24/17.
 */

public class QuestionsLoadedEvent {
    public SOQuestions questions;

    public QuestionsLoadedEvent(SOQuestions questions) {
        this.questions = questions;
    }

    public SOQuestions getQuestions() {
        return questions;
    }
}
