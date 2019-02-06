package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static relics.CommonMethods.activate;

public class HeroBlade extends CustomRelic {
    public static String ID = "rog:HeroBlade";
    public static String IMG = "rogassets/img/relics/grow_strength.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_strength.png";
    public static AbstractRelic.RelicTier RARITY = AbstractRelic.RelicTier.SPECIAL;
    public static AbstractRelic.LandingSound PICKUP = AbstractRelic.LandingSound.SOLID;
    public static int BATTLES_TO_LEVEL = 6;

    @Override
    public void onEquip(){ this.counter = 0; }

    @Override
    public void onVictory(){++this.counter;}

    @Override
    public void atBattleStart(){
        if(this.counter > BATTLES_TO_LEVEL){
            activate(this);
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, this.counter / BATTLES_TO_LEVEL), 1));
        }
    }



    public HeroBlade(){
        super(ID, new Texture(IMG), new Texture(IMG_OTL), RARITY, PICKUP);
    }

    @Override
    public AbstractRelic makeCopy() {
        return new HeroBlade();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
