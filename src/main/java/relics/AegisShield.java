package relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class AegisShield extends AbstractGrowthRelic {
    public static String ID = "rog:AegisShield";
    public static String IMG = "img/relics/grow_NA.png"; //TODO: Draw the sprites
    public static String IMG_OTL = "img/relics/outline/grow_NA.png";
    public static RelicTier RARITY = RelicTier.RARE;
    public static LandingSound PICKUP = LandingSound.HEAVY;
    public static int BATTLES_TO_LEVEL = 8;

    @Override
    public void atBattleStart(){
        if(this.counter > 0){
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, this.counter), 1));
        }
    }

    public AegisShield(){ super(ID, IMG, IMG_OTL, RARITY, PICKUP, BATTLES_TO_LEVEL); }

    @Override
    public AbstractRelic makeCopy() {
        return new AegisShield();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
