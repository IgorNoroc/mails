package mail;

import java.util.List;

public class StubInput implements Input {
    private List<String> answers;
    private int point = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public int askCommand() {
        return Integer.parseInt(answers.get(point++));
    }

    @Override
    public String ask() {
        return answers.get(point++);
    }
}
