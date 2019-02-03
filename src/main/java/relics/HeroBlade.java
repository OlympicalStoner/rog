package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class HeroBlade extends AbstractGrowthRelic{
    public static String ID = "rog:HeroBlade";
    public static String IMG = "rogassets/img/relics/grow_strength.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_strength.png";
    public static AbstractRelic.RelicTier RARITY = AbstractRelic.RelicTier.BOSS;
    public static AbstractRelic.LandingSound PICKUP = AbstractRelic.LandingSound.SOLID;
    public static int BATTLES_TO_LEVEL = 6;



    @Override
    public void atBattleStart(){
        if(this.counter > 0){
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, this.counter), 1));
        }
    }



    public HeroBlade(){
        super(ID, IMG, IMG_OTL, RARITY, PICKUP, BATTLES_TO_LEVEL);
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
