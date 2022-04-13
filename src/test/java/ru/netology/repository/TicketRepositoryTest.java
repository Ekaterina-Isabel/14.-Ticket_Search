package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 1199, "VKO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 3199, "VKO", "KZN", 95);

    @Test
    void shouldAddTicketsInRepository() {       //добавь билеты в репозиторий
        repository.save(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {     //найди билет по ID
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        Ticket expected = ticket2;
        Ticket actual = repository.findById(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {       //удали билет по id
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);

        repository.removeById(2);

        Ticket[] expected = {ticket1, ticket3, ticket4};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}