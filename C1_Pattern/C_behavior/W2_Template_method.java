package C1_Pattern.C_behavior;

abstract  class Game{
    abstract void startGame();
    abstract void play();
    abstract void endGame();

    void run(){
        startGame();
        play();
        endGame();
    }
}

class Pocker extends Game{

    @Override
    void startGame() {
        System.out.println("start Game");
    }

    @Override
    void play() {
        System.out.println("play Game");
    }

    @Override
    void endGame() {
        System.out.println("end Game");
    }
}

//----------------------------------------------------
public class W2_Template_method {
    public static void main(String[] args) {
        Game game = new Pocker();
            game.run();
    }
}
