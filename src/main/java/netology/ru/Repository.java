package netology.ru;

public class Repository {

    private Tiket[] tickets = new Tiket[0];

    public void add(Tiket ticket) {
        Tiket[] tmp = new Tiket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
       Tiket[] tmp = new Tiket[tickets.length - 1];
        int copyToIndex = 0;
        for (Tiket product : tickets) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Tiket[] findAll() {
        return tickets;
    }
}
