package cz.uhk.mois.edoras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import cz.uhk.mois.edoras.repositories.impl.PaymentMemoryCache;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleConfig
{
    @Bean
    public PaymentMemoryCache paymentMemoryCache()
    {
        return new PaymentMemoryCache();
    }
}
