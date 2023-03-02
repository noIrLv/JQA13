import netology.ru.Manager;
import netology.ru.Repository;
import netology.ru.Tiket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ManagerTest {


        Tiket tiket1 = new Tiket(1, 17800, "DME", "BEG", 150);
        Tiket tiket2 = new Tiket(2, 13300, "DME", "KTW", 210);
        Tiket tiket3 = new Tiket(3, 12000, "KTW", "BEG", 70);
        Tiket tiket4 = new Tiket(4, 17800, "DME", "BEG", 150);
        Tiket tiket5 = new Tiket(5, 7600, "SVO", "ROV", 100);
        Tiket tiket6 = new Tiket(6, 18900, "KTW", "BEG", 70);


      @Test
        public void whenOnlyTicket() {
            Repository repo = new Repository();
            Manager manager = new Manager(repo);
            manager.add(tiket1);
            manager.add(tiket2);
            manager.add(tiket3);
            manager.add(tiket4);
            manager.add(tiket5);
            manager.add(tiket6);


            Tiket[] expected = {tiket5};
            Tiket[] actual = manager.findAll("SVO", "ROV");

            Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void removeById(){
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(tiket1);
        manager.add(tiket2);
        manager.add(tiket3);
        manager.add(tiket4);
        manager.add(tiket5);
        manager.add(tiket6);

        manager.removeById(4);

        Tiket[] expected = {tiket1};
        Tiket[] actual = manager.findAll("DME", "BEG");

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void severalTicketsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(tiket1);
        manager.add(tiket2);
        manager.add(tiket3);
        manager.add(tiket4);
        manager.add(tiket5);
        manager.add(tiket6);


        Tiket[] expected = {tiket3,tiket6};
        Tiket[] actual = manager.findAll("KTW", "BEG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenNoTicketsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(tiket1);
        manager.add(tiket2);
        manager.add(tiket3);
        manager.add(tiket4);
        manager.add(tiket5);
        manager.add(tiket6);;
        manager.removeById(5);


        Tiket[] expected = {};
        Tiket[] actual = manager.findAll("SVO", "ROV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inTheOrder() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(tiket1);
        manager.add(tiket2);
        manager.add(tiket3);
        manager.add(tiket4);
        manager.add(tiket5);
        manager.add(tiket6);

        Tiket[] expected = {tiket3, tiket6};
        Tiket[] actual = manager.findAll("KTW", "BEG");

        Assertions.assertArrayEquals(expected, actual);
    }
}