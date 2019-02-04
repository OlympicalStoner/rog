package cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Fire extends CustomCard {
    public static String ID = "rog:Fire";
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String NAME = cardStrings.NAME;
    public static String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "NA";
    private static final int COST = 0;
    private static final int ATTACK_DMG = 3;

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster){

    }

    public Fire(){super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, CardColor.COLORLESS, CardRarity.COMMON, CardTarget.ENEMY);}

    @Override
    public void upgrade(){}
}
