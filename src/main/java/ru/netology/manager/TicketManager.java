package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {       //метод findAll принимает 2 параметра: from, to
        return searchByWay(from, to);
    }

    public Ticket findById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    //формирует массив отфильтрованных билетов, у которых совпадают аэропорты вылета и прилета
    public Ticket[] searchByWay(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result= tmp;
            }
        }
        Arrays.sort(result);        //сортировка билетов по цене
        return result;
    }

    //ищет билеты, у которых совпадают аэропорты вылета и прилета
    private boolean matches(Ticket ticket, String from, String to) {
        return ticket.getFrom().contains(from) && ticket.getTo().contains(to);
    }
}
