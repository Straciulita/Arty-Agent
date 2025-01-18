package CommandSablon;

import com.mycompany.artyagent.GamePanel;

public class PauseCommand implements Command {
    private GamePanel gamePanel;

    public PauseCommand(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void execute() {
        gamePanel.togglePause(); // Apelează metoda de pauză din GamePanel
    }
}
