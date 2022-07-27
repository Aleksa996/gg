package main;

import object.OBJ_key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font arial_40 , arial_80;

    BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";

    int messageCounter = 0;

    public boolean gameFinished = false;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80 = new Font("Arial",Font.BOLD,80);
        OBJ_key key = new OBJ_key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished){
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            String text;
            int textLenght;
            int x;
            int y;

            text = "You found the tresure!";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLenght/2;
            y = gp.screenHeight/2 - (gp.tileSize *3);
            g2.drawString(text,x,y);

            g2.setFont(arial_80);
            g2.setColor(Color.YELLOW);

            text = "Congratulations!";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLenght/2;
            y = gp.screenHeight/2 + (gp.tileSize * 2);
            g2.drawString(text,x,y);

            gp.gameThread = null;

        }else{
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString("x " + gp.player.hasKey,74,65);

            if(messageOn){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tileSize/2,gp.tileSize * 5);

                messageCounter++;

                if(messageCounter == 120){
                    messageCounter = 0;
                    messageOn = false;
                }
        }
        }
    }

}
