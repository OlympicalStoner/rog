package relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class HealStaff extends AbstractGrowthRelic {
    public static String ID = "rog:HealStaff";
    public static String IMG = "rogassets/img/relics/grow_regen.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_regen.png";
    public static RelicTier RARITY = RelicTier.UNCOMMON;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 3;



    @Override
    public void atBattleStart(){
        this.flash();
        AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        AbstractPlayer p = AbstractDungeon.player;
        if (p.currentHealth > 0) {
            p.heal(this.counter);
        }
    }



    public HealStaff(){ super(ID, IMG, IMG_OTL, RARITY, PICKUP, BATTLES_TO_LEVEL); }

    @Override
    public AbstractRelic makeCopy() {
        return new HealStaff();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
