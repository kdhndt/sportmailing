package be.vdab.sportmailing.services;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.repositories.SporterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultSporterService implements SporterService {
    private final SporterRepository sporterRepository;

    public DefaultSporterService(SporterRepository sporterRepository) {
        this.sporterRepository = sporterRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sporter> findAll() {
        return sporterRepository.findAll();
    }
}
