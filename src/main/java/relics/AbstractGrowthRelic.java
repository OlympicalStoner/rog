package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;

public class AbstractGrowthRelic extends CustomRelic{
    public int exp;
    public int cap;



    @Override
    public void onEquip(){
        this.exp = 0;
        this.counter = 0;
    }

    public void setLevel(){
        this.counter = this.exp / this.cap;
    }

    @Override
    public void onVictory(){
        ++this.exp;
        setLevel();
    }



    public AbstractGrowthRelic(String id, String img, String outline, RelicTier tier, LandingSound sound, int cap){
        super(id, new Texture(img), new Texture(outline), tier, sound);
        this.exp = 0;
        this.cap = cap;
        this.counter = 0;
    }
}
