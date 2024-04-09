package com.example.testappforivan.app.presentation.currency.dto;
import com.example.testappforivan.app.domain.entity.Currency;
import com.example.testappforivan.app.presentation.currency.dto.commands.CreateCurrencyCommands;
import com.example.testappforivan.app.presentation.currency.dto.commands.UpdateCurrencyCommands;
import com.example.testappforivan.app.presentation.currency.dto.queries.CurrencyQuery;
import com.example.testappforivan.app.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@AllArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<CurrencyQuery> getAll() throws InterruptedException{

        return service.getAll().stream().
                map(currency -> mapper.map(currency, CurrencyQuery.class)).
                toList();
    }

    @GetMapping("/{id}")
    public CurrencyQuery getById(@PathVariable Integer id){

        return mapper.map(service.getById(id), CurrencyQuery.class);
    }

    @PostMapping
    public CurrencyQuery create(@RequestBody CreateCurrencyCommands commands){

        Currency currencyFromCommand = mapper.map(commands, Currency.class);

        Currency currency = service.create(currencyFromCommand);

        CurrencyQuery currencyQueryResponse = mapper.map(currency, CurrencyQuery.class);

        return currencyQueryResponse;
    }
    @PutMapping("/{id}")
    public CurrencyQuery update(@PathVariable Integer id, @RequestBody UpdateCurrencyCommands commands) throws InterruptedException{

        Currency currencyFromCommand = mapper.map(commands, Currency.class);

        Currency currency = service.update(id,currencyFromCommand);
        currency.setUpdatedAt(LocalDateTime.now());

        CurrencyQuery currencyResponse = mapper.map(currency, CurrencyQuery.class);

        return currencyResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id, UpdateCurrencyCommands commands){
        commands.setDeletedAt(LocalDateTime.now());
        service.delete(id);
    }
}
