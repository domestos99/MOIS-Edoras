package cz.uhk.mois.edoras.helpers;

import cz.uhk.mois.edoras.bankingapi.model.TransactionPartyAccount;
import cz.uhk.mois.edoras.utils.StringUtil;

public class AccountHelper
{
    public static String getAccountId(TransactionPartyAccount partyAccount)
    {
        if (partyAccount == null)
            return null;

        if (StringUtil.isEmptyOrNull(partyAccount.getPrefix()))
        {
            return partyAccount.getAccountNumber() + "/" + partyAccount.getBankCode();
        }
        else
        {
            return partyAccount.getPrefix() + "-" + partyAccount.getAccountNumber() + "/" + partyAccount.getBankCode();
        }
    }
}
