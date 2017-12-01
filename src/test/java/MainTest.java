import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    private Main example = new Main();

    @Test
    public void getTopName() {
        String expected = "[[\"Logan\"], [\"Lucas\"], [\"Lucy\"], [\"Max\"], [\"Olivia\"], [\"Tom\"], [\"Torvald\"], [\"Victor\"]]";
        assertEquals(example.getTopName(), expected);
    }

    @Test
    public void getNameMale() {
        String expected = "[[\"Lucas\", 23], [\"Logan\", 22], [\"Tom\", 21], [\"Max\", 20], [\"Torvald\", 20], [\"Victor\", 5]]";
        assertEquals(example.getNameMale(), expected);
    }

    @Test
    public void getFriends() {
        String expected = "[[\"Lucy\"], [\"Tom\"]]";
        assertEquals(example.getFriends("Victor"), expected);
    }

    @Test
    public void getFriendsFriends() {
        String expected = "[[\"Max\"], [\"Max\"], [\"Torvald\"], [\"Victor\"], [\"Victor\"]]";
        assertEquals(example.getFriendsFriends("Victor"), expected);
    }

    @Test
    public void getNameAndCountFriends() {
        String expected = "[[\"Logan\", 1], [\"Lucas\", 2], [\"Lucy\", 2], [\"Max\", 2], [\"Olivia\", 1], [\"Tom\", 3], [\"Torvald\", 1], [\"Victor\", 2]]";
        assertEquals(example.getNameAndCountFriends(), expected);
    }

    @Test
    public void getGroups() {
        String expected = "[[\"Coffee\"], [\"Programing\"]]";
        assertEquals(example.getGroups(), expected);
    }

    @Test
    public void getGroupsByName() {
        String expected = "[[\"Coffee\"], [\"Programing\"]]";
        assertEquals(example.getGroupsByName("Victor"), expected);
    }

    @Test
    public void getGroupsAndMemberCount() {
        String expected = "[[\"Programing\", 7], [\"Coffee\", 4]]";
        assertEquals(example.getGroupsAndMemberCount(), expected);
    }
    
    @Test
    public void getCountGroupsFriendsFriends() {
        String expected = "[[7]]";
        assertEquals(example.getCountGroupsFriendsFriends("Victor"), expected);
    }

    @Test
    public void getPosts() {
        String expected = "[[[\"Programming\", \"Java\", \"Python\", \"Stack\", \"Linux\"]]]";
        assertEquals(example.getPosts("Victor"), expected);
    }

    @Test
    public void getPostsGtNum() {
        String expected = "[[\"Tom\", [\"Hello Word!\"]], [\"Lucy\", []], [\"Max\", [\"Cars my love\"]], [\"Olivia\", [\"I don'n know\", \"Happy birthday\"]], [\"Lucas\", [\"Lamp don't blink\"]], [\"Victor\", [\"Programming\"]], [\"Logan\", []], [\"Torvald\", [\"Operation system\"]]]";
        assertEquals(example.getPostsGtNum(10), expected);
    }

    @Test
    public void getNameAndPosts() {
        String expected = "[[\"Tom\", 5], [\"Victor\", 5], [\"Lucy\", 3], [\"Olivia\", 3], [\"Logan\", 3], [\"Max\", 2], [\"Lucas\", 2], [\"Torvald\", 2]]";
        assertEquals(example.getNameAndPosts(), expected);
    }

    @Test
    public void getPostsFriendsFriends() {
        String expected = "[[\"Victor\", [\"Programming\", \"Java\", \"Python\", \"Stack\", \"Linux\"]], [\"Max\", [\"Cars my love\", \"Just do it\"]], [\"Victor\", [\"Programming\", \"Java\", \"Python\", \"Stack\", \"Linux\"]], [\"Torvald\", [\"Creator\", \"Operation system\"]], [\"Max\", [\"Cars my love\", \"Just do it\"]]]";
        assertEquals(example.getPostsFriendsFriends("Victor"), expected);
    }

    @Test
    public void getPostsSort() {
        String expected = "[[\"Olivia\", 12], [\"Lucas\", 12], [\"Max\", 11], [\"Torvald\", 11], [\"Tom\", 6], [\"Lucy\", 6], [\"Victor\", 6], [\"Logan\", 6]]";
        assertEquals(example.getPostsSort(), expected);
    }

}