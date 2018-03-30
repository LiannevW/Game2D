package states;

import core.Game;
import entity.Player;
import worlds.World;

import java.awt.*;
import java.io.File;

public class GameState extends State {

    private Player player ;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100,100);
        world = new World(game,"resources/wereld/world1.txt");

    }

    @Override
    public void update() {
        world.update();
        player.update();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
