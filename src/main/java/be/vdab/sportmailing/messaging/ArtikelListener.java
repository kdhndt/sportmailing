package be.vdab.sportmailing.messaging;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;
import be.vdab.sportmailing.exceptions.KanMailNietZendenException;
import be.vdab.sportmailing.mailing.SporterMailing;
import be.vdab.sportmailing.services.SporterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ArtikelListener {
    private final SporterService sporterService;
    private final SporterMailing sporterMailing;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArtikelListener(SporterService sporterService, SporterMailing sporterMailing) {
        this.sporterService = sporterService;
        this.sporterMailing = sporterMailing;
    }

    //RabbitMQ dependency met deze annotation zorgt voor koppeling met exchange en zijn queue(s)? berichten worden hier een per een ontvangen
    @RabbitListener(queues = "sportartikels")
    void verwerkBericht(ArtikelGemaakt artikelGemaakt) {
//        var sporters = sporterService.findAll();
//        sporters.stream().forEach(sporter -> sporterMailing.stuurMailNaToevoegingArtikel(sporter, artikelGemaakt.getNaam()));
        try {
            for (Sporter sporter : sporterService.findAll()) {
                sporterMailing.stuurMailNaToevoegingArtikel(sporter, artikelGemaakt.getNaam());
            }
        } catch (KanMailNietZendenException ex) {
            logger.error("Kan mail niet sturen", ex);
        }
    }
}