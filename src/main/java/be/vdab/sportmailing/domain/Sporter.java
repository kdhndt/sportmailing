package be.vdab.sportmailing.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sporters")
public class Sporter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull @Email
    private String emailAdres;

    protected Sporter() {
    }

    public long getId() {
        return id;
    }

    public String getEmailAdres() {
        return emailAdres;
    }
}
