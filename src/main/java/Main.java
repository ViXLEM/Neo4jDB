import org.neo4j.driver.v1.*;
import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class Main
{
    public static Driver driver = null;

    private static void addPerson(String name, int Age, int Id, String sex, String[] posts) {
        try (Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("MERGE (" + "a:Person {name: {name}, age : {age}, id : {id}, sex: {sex}, posts: {posts}}" + ")",
                        parameters("name", name, "age", Age, "id", Id, "sex", sex, "posts", posts));
                tx.success();
            }
        }
    }

    private static void addFriendRelation(int firstID, int secondID) {
        try (Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("match (a{id: {x} }),(b{id: {y} }) Merge (a)-[r:FRIEND]->(b)",
                        parameters("x", firstID, "y",secondID));
                tx.success();
            }
        }
    }

    private static void addGroupRelation(int GroupID, int personID)
    {
        try (Session session = driver.session()){
            try (Transaction tx = session.beginTransaction()){
                tx.run("match (a{id: {x} }),(b{id: {y} }) Merge (a)-[r: SUBSCRIBER]->(b)",
                        parameters("y", GroupID, "x",personID));
                tx.success();
            }
        }
    }

    private static void addGroup(String name, int Id) {
        try (Session session = driver.session()){
            try (Transaction tx = session.beginTransaction()){
                tx.run("MERGE (a:Group {name: {x}, id : {y}})",
                        parameters("x", name, "y", Id));
                tx.success();
            }
        }
    }

    public String func3a(){
        return execute("match (n:Person) return n.name order by n.name");
    }

    public String func3b(){
        return execute("match (p:Person) where p.sex=\"male\" return p.name, p.age order by p.age desc");
    }

    public String func3c(String name){
        return executeWithNameParam("match (node:Person)<-[:FRIEND]-(n) where node.name = {x} return n.name order by n.name", name);
    }

    public String func3d(String name){
        return executeWithNameParam("match (node:Person)<-[:FRIEND]-(n)<-[:FRIEND]-(f) where node.name = {x} return f.name order by f.name", name);
    }

    public String func3e(){
        return execute("MATCH (n:Person)<-[:FRIEND]-(f) RETURN n.name, count(f) as counter order by n.name");
    }

    public String func3f(){
        return execute("match (g:Group) return g.name order by g.name");
    }

    public String func3g(String name) {
        return executeWithNameParam("match (g:Group)<-[:SUBSCRIBER]-(p:Person) where p.name = {x} return g.name order by g.name", name);
    }

    public String func3h(){
        return execute("match (g:Group)<-[:SUBSCRIBER]-(p:Person) return g.name, count(p) order by count(p) desc");
    }

    public String func3i(){
        return execute("match (g:Group)<-[:SUBSCRIBER]-(p:Person) return p.name, count(g) order by count(g) desc");
    }

    public String func3j(String name){
        return executeWithNameParam("match (p:Person)<-[:FRIEND]-(f:Person)<-[:FRIEND]-(ff:Person)-[:SUBSCRIBER]->(g:Group) where p.name={x} return count(g)", name);
    }

    public String func4a(String name){
        return executeWithNameParam("match (n) where n.name={x} return n.posts", name);
    }

    public String func4b(int num){
        return executeWithIntParam("match (n:Person) return n.name, filter(row in n.posts where length(row)>{x})", num);
    }

    public String func4c(){
        return execute("match (n:Person) return n.name, size(n.posts) order by size(n.posts) desc");
    }

    public String func4d(String name){
        return executeWithNameParam("match (n:Person)<-[:FRIEND]-(f:Person)<-[:FRIEND]-(ff:Person) where n.name={x} return ff.name, ff.posts", name);
    }

    public String func4i(){
        return execute("match (p:Person) with (reduce(total = 0, row in p.posts | total + length(row)))/size(p.posts) as num, p.name as name return name, num order by num desc");
    }

    public static String execute(String query){
        List<String> arr = new ArrayList<String>();
        try (Session session = driver.session()){
            StatementResult result = session.run(query);
            while (result.hasNext()){
                Record record = result.next();
                arr.add(record.values().toString());
            }
        }
        return arr.toString();
    }

    public static String executeWithNameParam(String query, String name){
        List<String> arr = new ArrayList<String>();
        try (Session session = driver.session()){
            StatementResult result = session.run(query, parameters("x", name));
            while (result.hasNext()){
                Record record = result.next();
                arr.add(record.values().toString());
            }
        }
        return arr.toString();
    }

    public static String executeWithIntParam(String query, int num){
        List<String> arr = new ArrayList<String>();
        try (Session session = driver.session()){
            StatementResult result = session.run(query, parameters("x", num));
            while (result.hasNext()){
                Record record = result.next();
                arr.add(record.values().toString());
            }
        }
        return arr.toString();
    }

    public void printResult(String result){
        System.out.println(result);
    }

    public static void close() {
        driver.close();
    }

    public Main()
    {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "neo4j"));
        try (Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("match (n)-[r]-() DELETE n,r;");
                tx.success();
            }
        }
        addPerson("Grishka", 10, 1, "male", new String[]{"gggg", "gggggggg", "gg", "ggggg", "ggggggg"});
        addPerson("Andriy", 23, 2, "male", new String[]{"aaaaaaa", "aa", "aaaaa"});
        addPerson("Bogus", 20, 3, "male", new String[]{"bbbbbbbbb", "b"});
        addPerson("Taras", 19, 4, "male", new String[]{"tttttttttttt", "tttttttttttt", "ttt", "tttttt"});
        addPerson("Artem", 23, 5, "male", new String[]{"aaaaaaaa", "aaaaaaaaaaaaaa", "aaaaaaaaaaa", "aa", "aaaa"});
        addPerson("Vitia", 5, 6, "male", new String[]{"vvvv", "vv", "vvvvvvvvvvv", "vvvvv", "vv", "vvvvvvvv"});
        addPerson("Liza", 22, 7, "female", new String[]{"llll", "lll", "llllllll"});
        addPerson("Nazar", 20, 8, "male", new String[]{"nn", "n"});
        addFriendRelation(1,3);
        addFriendRelation(2,3);
        addFriendRelation(1,8);
        addFriendRelation(4,5);
        addFriendRelation(5,7);
        addFriendRelation(1,6);
        addFriendRelation(3,1);
        addFriendRelation(3,2);
        addFriendRelation(8,1);
        addFriendRelation(5,4);
        addFriendRelation(7,5);
        addFriendRelation(6,2);
        addFriendRelation(2,6);
        addFriendRelation(6,1);
        addGroup("KPI", 101);
        addGroup("FIOT", 102);
        addGroupRelation(101, 1);
        addGroupRelation(101, 2);
        addGroupRelation(101, 3);
        addGroupRelation(101, 4);
        addGroupRelation(101, 5);
        addGroupRelation(101, 7);
        addGroupRelation(101, 8);
        addGroupRelation(102, 1);
        addGroupRelation(102, 3);
        addGroupRelation(102, 4);
        addGroupRelation(102, 7);
    }

}