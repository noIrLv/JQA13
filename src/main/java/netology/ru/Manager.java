package netology.ru;

import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Tiket product) {
        repository.add(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


    public Tiket[] findAll(String from, String to) {
        Tiket[] result = new Tiket[0];
        for (Tiket tiket : repository.findAll()) {
            if (matches(tiket, from, to)) {
                Tiket[] tmp = new Tiket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = tiket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Tiket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}

