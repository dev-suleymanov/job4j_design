package ru.job4j.ood.tdd;

import org.assertj.core.internal.Predicates;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class CinemaTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountReal();
        Cinema cinema = new CinemaReal();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new TicketReal());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new CinemaReal();
        Session session = new SessionReal();
        cinema.add(session);
        List<Session> sessions = cinema.find(ses -> true);
        assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountReal();
        Cinema cinema = new CinemaReal();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenGetSessionsByFilter() {
        Predicate<Session> predicate = s -> true;
        List<Session> result = new CinemaReal().find(predicate);
        List<Session> expected = new ArrayList<>(List.of());
        assertThat(result).isEqualTo(expected);
    }
}