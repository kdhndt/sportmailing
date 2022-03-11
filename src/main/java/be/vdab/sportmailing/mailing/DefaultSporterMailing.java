package be.vdab.sportmailing.mailing;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.exceptions.KanMailNietZendenException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class DefaultSporterMailing implements SporterMailing {
    private final JavaMailSender sender;

    public DefaultSporterMailing(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void stuurMailNaToevoegingArtikel(Sporter sporter, String artikelNaam) {
        try {
            var message = new SimpleMailMessage();
            message.setTo(sporter.getEmailAdres());
            message.setSubject("Nieuw artikel");
            message.setText("Er is een nieuw artikel:" + artikelNaam);
            sender.send(message);
        } catch (MailException ex) {
            throw new KanMailNietZendenException(ex);
        }
    }
}
