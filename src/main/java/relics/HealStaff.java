package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static relics.CommonMethods.activate;

public class HealStaff extends CustomRelic {
    public static String ID = "rog:HealStaff";
    public static String IMG = "rogassets/img/relics/grow_regen.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_regen.png";
    public static RelicTier RARITY = RelicTier.SPECIAL;
    public static LandingSound PICKUP = LandingSound.MAGICAL;
    public static int BATTLES_TO_LEVEL = 3;

    @Override
    public void onEquip(){ this.counter = 0; }

    @Override
    public void onVictory(){++this.counter;}

    @Override
    public void atBattleStartPreDraw(){
        if(this.counter >= BATTLES_TO_LEVEL){
            activate(this);
            AbstractPlayer p = AbstractDungeon.player;
            if (p.currentHealth > 0) {
                p.heal(this.counter / BATTLES_TO_LEVEL);
            }
        }
    }



    public HealStaff(){
        super(ID, new Texture(IMG), new Texture(IMG_OTL), RARITY, PICKUP);
    }

    @Override
    public AbstractRelic makeCopy() {
        return new HealStaff();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
