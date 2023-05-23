import org.example.Movie;
import org.example.MovieManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    Movie item1 = new Movie("movie1");
    Movie item2 = new Movie("movie2");
    Movie item3 = new Movie("movie3");
    Movie item4 = new Movie("movie4");
    Movie item5 = new Movie("movie5");

    @Test
    public void findAllMovies() {
        MovieManager repo = new MovieManager();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.findAll();

        Movie[] expected = {item1, item2, item3};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMovies1() {
        MovieManager repo = new MovieManager(10);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Movie[] expected = {item3, item2, item1};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMovies2() {
        MovieManager repo = new MovieManager();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);

        repo.findLast();

        Movie[] expected = {item5, item4, item3, item2, item1};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMovies3() {
        MovieManager repo = new MovieManager(2);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Movie[] expected = {item3, item2};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastMovies4() {
        MovieManager repo = new MovieManager(10);


        Movie[] expected = {};
        Movie[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
