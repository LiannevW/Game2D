package states;

import core.Game;
import entity.Player;
import tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player ;

    public GameState(Game game) {
        super(game);
        player = new Player(game,100,100);
    }

    @Override
    public void update() {
        player.update();

    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        Tile.tiles[0].render(g, 0, 0 );

    }
}