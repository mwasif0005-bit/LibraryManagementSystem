public class Member {
    int id;
    String name;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {
        System.out.println("Member ID: " + id + ", Name: " + name);
    }
}
