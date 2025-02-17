package theGartic.cards;

import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PenNibPower;
import com.megacrit.cardcrawl.stances.WrathStance;

import static theGartic.GarticMod.makeID;
import static theGartic.util.Wiz.*;

public class GodsBlood extends AbstractEasyCard {
    public final static String ID = makeID(GodsBlood.class.getSimpleName());
    public final static int MAGIC = 3;
    private final static int COST = 1;
    private final static int UPGRADED_COST = 0;

    public GodsBlood() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new LoseHPAction(adp(), adp(), 1));
        atb(new ChangeStanceAction(WrathStance.STANCE_ID));
        applyToSelf(new PenNibPower(adp(), 1));
    }

    public void upp() {
        upgradeBaseCost(UPGRADED_COST);
    }
}