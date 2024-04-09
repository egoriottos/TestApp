package com.example.testappforivan.app.service;

import com.example.testappforivan.app.domain.entity.Currency;
import com.example.testappforivan.app.repository.CurrencyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Async
    public List<Currency> getAll() throws InterruptedException{
        return currencyRepository.findAll();
    }

    public Currency getById(Integer id){
        return currencyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Currency create(Currency currencyFromCommand){
        Currency currency = currencyRepository.save(currencyFromCommand);
        return currency;
    }
    @Async
    public Currency update(Integer id, Currency currencyFromCommand) throws InterruptedException{
        var currency = getById(id);
        if(!currency.getIndex().equals(currencyFromCommand.getIndex()) &&
                !currency.getPurchase().equals(currencyFromCommand.getPurchase()) &&
                !currency.getSale().equals(currencyFromCommand.getSale()))
        {
            currency.setIndex(currencyFromCommand.getIndex());
            currency.setPurchase(currencyFromCommand.getPurchase());
            currency.setSale(currencyFromCommand.getSale());
        }
        Currency saved = currencyRepository.save(currency);
        saved.getUpdatedAt();
        return saved;
    }

    public void delete(Integer id){
        currencyRepository.deleteById(id);
    }
}
