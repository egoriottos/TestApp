package com.example.testappforivan;

import com.example.testappforivan.app.domain.entity.Currency;
import com.example.testappforivan.app.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;
import java.util.concurrent.Future;

@EnableAsync
@SpringBootApplication
public class TestAppForIvanApplication implements Runnable {
    CurrencyService currencyService;
    int count = 0;
    @Override
    public void run() {
        Future<Currency> task1;
        Future<Currency> task2;
        try {
            task1 = (Future<Currency>) currencyService.getAll();
            task2 = (Future<Currency>) currencyService.update(++count, new Currency());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!(task1.isDone() && task2.isDone())){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(TestAppForIvanApplication.class, args);
    }

}
