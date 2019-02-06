package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static relics.CommonMethods.activate;

public class OdinHelmet extends CustomRelic {
    public static String ID = "rog:OdinHelmet";
    public static String IMG = "rogassets/img/relics/grow_draw.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_draw.png";
    public static RelicTier RARITY = RelicTier.SPECIAL;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 9;

    @Override
    public void onEquip(){ this.counter = 0; }

    @Override
    public void onVictory(){++this.counter;}

    @Override
    public void atTurnStartPostDraw(){
        if(this.counter > BATTLES_TO_LEVEL){
            activate(this);
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.counter / BATTLES_TO_LEVEL));
        }
    }



    public OdinHelmet(){super(ID, new Texture(IMG), new Texture(IMG_OTL), RARITY, PICKUP);}

    @Override
    public AbstractRelic makeCopy() {
        return new OdinHelmet();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
