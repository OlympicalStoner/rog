package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static relics.CommonMethods.activate;

public class AegisShield extends CustomRelic {
    public static String ID = "rog:AegisShield";
    public static String IMG = "rogassets/img/relics/grow_dexterity.png";
    public static String IMG_OTL = "rogassets/img/relics/outline/grow_dexterity.png";
    public static RelicTier RARITY = RelicTier.SPECIAL;
    public static LandingSound PICKUP = LandingSound.HEAVY;
    public static int BATTLES_TO_LEVEL = 8;

    @Override
    public void onEquip(){ this.counter = 0; }

    @Override
    public void onVictory(){++this.counter;}

    @Override
    public void atBattleStart(){
        if(this.counter >= BATTLES_TO_LEVEL){
            activate(this);
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DexterityPower(AbstractDungeon.player, this.counter / BATTLES_TO_LEVEL), 1));
        }
    }

    public AegisShield(){ super(ID, new Texture(IMG), new Texture(IMG_OTL), RARITY, PICKUP); }

    @Override
    public AbstractRelic makeCopy() {
        return new AegisShield();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
