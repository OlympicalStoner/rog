import basemod.BaseMod;
import basemod.interfaces.EditRelicsSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.RelicStrings;
import relics.AltarOrb;
import relics.GrowthColor;
import relics.HealStaff;
import relics.HeroBlade;

@SpireInitializer
public class ROG implements EditRelicsSubscriber {

    public static String ASSETS = "img";

    public static final String makeResourcePath(String input){
        return ASSETS + "/" + input;
    }

    public static final String makeRelicImagePath(String input){
        return makeResourcePath("relics/" + input);
    }



    public ROG(){
        BaseMod.subscribe(this);
        BaseMod.addColor(GrowthColor.ROG_SHARED,
                Color.CLEAR,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "");
    }

    public static void initialize(){
        new ROG();
    }

    //Register relics here
    public void receiveEditRelics(){
        BaseMod.loadCustomStringsFile(RelicStrings.class, "rogassets/localization/relics.json");

        BaseMod.addRelicToCustomPool(
                new AltarOrb(),
                GrowthColor.ROG_SHARED
        );

        BaseMod.addRelicToCustomPool(
                new HeroBlade(),
                GrowthColor.ROG_SHARED
        );

        BaseMod.addRelicToCustomPool(
                new HealStaff(),
                GrowthColor.ROG_SHARED
        );
    }
}
