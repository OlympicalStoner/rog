package relics;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class OdinHelmet extends AbstractGrowthRelic {
    public static String ID = "rog:OdinHelmet";
    public static String IMG = "img/relics/NA"; //TODO: Make sprite
    public static String IMG_OTL = "img/relics/outline/NA";
    public static RelicTier RARITY = RelicTier.BOSS;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 9;


    @Override
    public void atTurnStartPostDraw(){
        if(this.counter > 0){
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, this.counter));
        }
    }


    public OdinHelmet(){super(ID, IMG, IMG_OTL, RARITY, PICKUP, BATTLES_TO_LEVEL);}

    @Override
    public AbstractRelic makeCopy() {
        return new OdinHelmet();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
