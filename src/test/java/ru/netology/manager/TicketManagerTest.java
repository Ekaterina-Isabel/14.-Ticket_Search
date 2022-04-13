package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1199, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 3199, "VKO", "KZN", 95);

    @Test
    void shouldAddTickets() {       //добавь билеты (через репозиторий и менеджер)
        repository.save(ticket1);
        manager.add(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket[] expected = {ticket3, ticket2, ticket4};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {     //найди билет по ID
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket expected = ticket2;
        Ticket actual = manager.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdNoId() {     //найди билет по ID, нет id
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket expected = null;
        Ticket actual = manager.findById(5);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {       //удали билет по id (через репозиторий и менеджер)
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        repository.removeById(1);
        manager.removeById(4);

        Ticket[] expected = {ticket3, ticket2};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTicketByFrom() {     //найди билет по аэропорту вылета и прилета
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("SVO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTicketByFromNoTicket() {     //найди билет по аэропорту вылета, нет такого билета
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNoSearchTicketByEmptySearch() {     //найди билет по аэропорту вылета, нет такого билета
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket[] expected = {ticket3, ticket1, ticket2, ticket4};
        Ticket[] actual = manager.findAll("", "");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNoSearchTicket() {     //найди билет по аэропорту вылета, нет такого билета

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }
}