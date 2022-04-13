package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {       //добавить билет
        int lengh = tickets.length + 1;
        Ticket[] tmp = new Ticket[lengh];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {     //получить набор билетов
        return tickets;
    }

    public Ticket findById(int id) {        //возвращает билет по id
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {        //удалить билет по id
        int lenght = tickets.length - 1;
        Ticket[] tmp = new Ticket[lenght];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() !=id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}
