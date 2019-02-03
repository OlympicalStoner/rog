package relics;

import basemod.interfaces.PostEnergyRechargeSubscriber;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class AltarOrb extends AbstractGrowthRelic implements PostEnergyRechargeSubscriber {
    public static String ID = "rog:FieryOrb";
    public static String IMG = "img/relics/grow_energy.png";
    public static String IMG_OTL = "img/relics/outline/grow_energy.png";
    public static RelicTier RARITY = RelicTier.BOSS;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 8;



    @Override
    public void receivePostEnergyRecharge() {
        if(this.counter > 0){
            this.flash();
            AbstractDungeon.actionManager.addToTop(new GainEnergyAction(this.counter));
            AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        }
    }



    public AltarOrb(){
        super(ID, IMG, IMG_OTL, RARITY, PICKUP, BATTLES_TO_LEVEL);
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
