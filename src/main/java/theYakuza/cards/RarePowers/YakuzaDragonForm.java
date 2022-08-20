package theYakuza.cards.RarePowers;

import theYakuza.DefaultMod;
import theYakuza.cards.AbstractDynamicCard;
import theYakuza.characters.TheDefault;
import theYakuza.powers.DragonFormPower;

import static theYakuza.DefaultMod.makeCardPath;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class YakuzaDragonForm extends AbstractDynamicCard {

    // TEXT DECLARATION

    public static final String ID = DefaultMod.makeID(YakuzaDragonForm.class.getSimpleName());
    public static final String IMG = makeCardPath("Yakuza_Dragon_Form.png");

    // /TEXT DECLARATION/

    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 4;

    // /STAT DECLARATION/

    public YakuzaDragonForm() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        // this.tags.add(CardTags.STARTER_DEFEND); // Tag your strike, defend and form
        // (Wraith form, Demon form, Echo form,
        // etc.) cards so that they function correctly.
        isEthereal = true;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p,
                new DragonFormPower(p, p, 1)));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            isEthereal = false;
            initializeDescription();
        }
    }
}