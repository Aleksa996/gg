package object;

import main.GamePanel;

import javax.imageio.ImageIO;

public class OBJ_key extends SuperObject {
    GamePanel gp;
    public OBJ_key(GamePanel gp){
        this.gp = gp;
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
