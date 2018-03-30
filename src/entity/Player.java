package entity;

import core.Game;
import gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGTH);
        this.game = game;

    }

    @Override
    public void update() {
        getInput();
        move();
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
     g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
    }

}
