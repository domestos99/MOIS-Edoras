package cz.uhk.mois.edoras.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.uhk.mois.edoras.bankingapi.model.Payment;

public interface PaymentDAO extends JpaRepository<Payment, String>
{
}
