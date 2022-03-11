package be.vdab.sportmailing.mailing;

import be.vdab.sportmailing.domain.Sporter;

public interface SporterMailing {
    void stuurMailNaToevoegingArtikel(Sporter sporter, String artikelNaam);
}
