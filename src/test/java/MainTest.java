import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    private Main example = new Main();

    @Test
    public void test3a()
    {
        String expected = "[[\"Andriy\"], [\"Artem\"], [\"Bogus\"], [\"Grishka\"], [\"Liza\"], [\"Nazar\"], [\"Taras\"], [\"Vitia\"]]";
        assertEquals(example.func3a(), expected);
    }

    @Test
    public void test3b()
    {
        String expected = "[[\"Andriy\", 23], [\"Artem\", 23], [\"Bogus\", 20], [\"Nazar\", 20], [\"Taras\", 19], [\"Grishka\", 10], [\"Vitia\", 5]]";
        assertEquals(example.func3b(), expected);
    }

    @Test
    public void test3c()
    {
        String expected = "[[\"Andriy\"], [\"Grishka\"]]";
        assertEquals(example.func3c("Bogus"), expected);
    }

    @Test
    public void test3d()
    {
        String expected = "[[\"Bogus\"], [\"Bogus\"], [\"Nazar\"], [\"Vitia\"], [\"Vitia\"]]";
        assertEquals(example.func3d("Bogus"), expected);
    }

    @Test
    public void test3e()
    {
        String expected = "[[\"Andriy\", 2], [\"Artem\", 2], [\"Bogus\", 2], [\"Grishka\", 3], [\"Liza\", 1], [\"Nazar\", 1], [\"Taras\", 1], [\"Vitia\", 2]]";
        assertEquals(example.func3e(), expected);
    }

    @Test
    public void test3f()
    {
        String expected = "[[\"FIOT\"], [\"KPI\"]]";
        assertEquals(example.func3f(), expected);
    }

    @Test
    public void test3g()
    {
        String expected = "[[\"FIOT\"], [\"KPI\"]]";
        assertEquals(example.func3g("Bogus"), expected);
    }

    @Test
    public void test3h()
    {
        String expected = "[[\"KPI\", 7], [\"FIOT\", 4]]";
        assertEquals(example.func3h(), expected);
    }


    @Test
    public void test3j()
    {
        String expected = "[[5]]";
        assertEquals(example.func3j("Bogus"), expected);
    }

    @Test
    public void test4a()
    {
        String expected = "[[[\"bbbbbbbbb\", \"b\"]]]";
        assertEquals(example.func4a("Bogus"), expected);
    }

    @Test
    public void test4b()
    {
        String expected = "[[\"Grishka\", []], [\"Andriy\", []], [\"Bogus\", []], [\"Taras\", [\"tttttttttttt\", \"tttttttttttt\"]], [\"Artem\", [\"aaaaaaaaaaaaaa\", \"aaaaaaaaaaa\"]], [\"Vitia\", [\"vvvvvvvvvvv\"]], [\"Liza\", []], [\"Nazar\", []]]";
        assertEquals(example.func4b(10), expected);
    }

    @Test
    public void test4c()
    {
        String expected = "[[\"Vitia\", 6], [\"Grishka\", 5], [\"Artem\", 5], [\"Taras\", 4], [\"Andriy\", 3], [\"Liza\", 3], [\"Bogus\", 2], [\"Nazar\", 2]]";
        assertEquals(example.func4c(), expected);
    }

    @Test
    public void test4d()
    {
        String expected = "[[\"Vitia\", [\"vvvv\", \"vv\", \"vvvvvvvvvvv\", \"vvvvv\", \"vv\", \"vvvvvvvv\"]], [\"Bogus\", [\"bbbbbbbbb\", \"b\"]], [\"Vitia\", [\"vvvv\", \"vv\", \"vvvvvvvvvvv\", \"vvvvv\", \"vv\", \"vvvvvvvv\"]], [\"Nazar\", [\"nn\", \"n\"]], [\"Bogus\", [\"bbbbbbbbb\", \"b\"]]]";
        assertEquals(example.func4d("Bogus"), expected);
    }

    @Test
    public void test4i()
    {
        String expected = "[[\"Taras\", 8], [\"Artem\", 7], [\"Grishka\", 5], [\"Bogus\", 5], [\"Vitia\", 5], [\"Liza\", 5], [\"Andriy\", 4], [\"Nazar\", 1]]";
        assertEquals(example.func4i(), expected);
    }

}