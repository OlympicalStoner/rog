package relics;

import basemod.abstracts.CustomRelic;
import basemod.interfaces.PostEnergyRechargeSubscriber;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static relics.CommonMethods.activate;

public class AltarOrb extends CustomRelic implements PostEnergyRechargeSubscriber {
    public static String ID = "rog:FieryOrb";
    public static String IMG = "img/relics/grow_energy.png";
    public static String IMG_OTL = "img/relics/outline/grow_energy.png";
    public static RelicTier RARITY = RelicTier.SPECIAL;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 8;

    @Override
    public void onEquip(){ this.counter = 0; }

    @Override
    public void onVictory(){++this.counter;}

    @Override
    public void receivePostEnergyRecharge() {
        if(this.counter > BATTLES_TO_LEVEL){
            activate(this);
            AbstractDungeon.actionManager.addToTop(new GainEnergyAction(this.counter / BATTLES_TO_LEVEL));
        }
    }



    public AltarOrb(){
        super(ID, new Texture(IMG), new Texture(IMG_OTL), RARITY, PICKUP);
    }

    @Override
    public AbstractRelic makeCopy() {
        return new AltarOrb();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
