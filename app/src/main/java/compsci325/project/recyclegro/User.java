package compsci325.project.recyclegro;

public class User {
    private String firstName;
    private String lastName;
    private String fullName;
    private int recyclePoints;
    private int ranking;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.fullName = "";
        this.recyclePoints = 0;
        this.ranking = -1;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.recyclePoints = 0;
        this.ranking = -1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRecyclePoints() {
        return recyclePoints;
    }

    public void setRecyclePoints(int recyclePoints) {
        this.recyclePoints = recyclePoints;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
