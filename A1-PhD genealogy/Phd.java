package a1;

/** NetId: sau8, df356. Time spent: 3 hours, 0 minutes. <br>
 * What I thought about this assignment: This assignment was engaging, and truly familiarized us
 * <br>
 * with the concept of testing. It also showed us how to concise code, given the instructions to
 * <br>
 * keep most return statements to one line of length. The program also introduced testing in <br>
 * an actual computer program, and definitely served as good practice in that regard. <br>
 * <br>
 * An instance maintains info about the Phd of a person. */

public class Phd {

    /** name of the PhD-holder, with a length more than 0. */
    private String name;

    /** year the PhD was awarded. More than 1000, 1000 referring to the year 1000 A.D.. */
    private int year;

    /** month PhD was awarded. In 1..12, with 1 meaning January, etc. */
    private int month;

    /** first advisor of this person. If unknown, becomes null. */
    private Phd advisor1;

    /** first advisor of this person. If unknown, or if there is only one advisor, becomes null. */
    private Phd advisor2;

    /** number of advisees this person has. */
    private int advisees;

    /** Constructor: an instance for a person with name n, Phd year y, Phd month m. Its advisors are
     * unknown, and it has no advisees. Precondition: n has at least 1 char, y > 1000, and m is in
     * 1..12 */
    public Phd(String n, int y, int m) {
        assert n.length() > 0;
        assert y > 1000;
        assert m > 0 && m < 13;
        name= n;
        year= y;
        month= m;
        advisor1= null;
        advisor2= null;
        advisees= 0;
    }

    /** Constructor: a Phd with name n, Phd year y, <br>
     * Phd month m, first advisor a1, and second advisor a2. Precondition: n has at least 1 char, y
     * > 1000, m is in 1..12,a1 and a2 are not null, and a1 and a2 are different. */
    public Phd(String n, int y, int m, Phd a1, Phd a2) {
        assert n.length() > 0;
        assert y > 1000;
        assert m > 0 && m < 13;
        assert a1 != null;
        assert a2 != null;
        assert a1 != a2;
        name= n;
        year= y;
        month= m;
        setAdvisor1(a1);
        setAdvisor2(a2);
        advisees= 0;
    }

    /** = the name of this person */
    public String name() {
        return name;
    }

    /** = the date on which this person got the Phd. In the form "month/year", with no blanks, e.g.
     * "6/2007 */
    public String date() {
        return month + "/" + year;
    }

    /** = the first advisor of this Phd (null if unknown). */
    public Phd advisor1() {
        return advisor1;
    }

    /** = the second advisor of this Phd (null if unknown or non-existent). */
    public Phd advisor2() {
        return advisor2;
    }

    /** = the number of Phd advisees of this person. */
    public int nAdvisees() {
        return advisees;
    }

    /** Make p the first advisor of this person. Precondition: the first advisor is unknown and p is
     * not null */
    public void setAdvisor1(Phd p) {
        assert advisor1 == null;
        assert p != null;
        advisor1= p;
        p.advisees++ ;
    }

    /** Make p the second advisor of this person. Precondition: The first advisor (of this person)
     * is known, the second advisor is unknown, p is not null, and p is different from the first
     * advisor. */
    public void setAdvisor2(Phd p) {
        assert advisor1 != null;
        assert advisor2 == null;
        assert p != null;
        assert p != advisor1;
        advisor2= p;
        p.advisees++ ;
    }

    /** = "this Phd has no advisees", i.e. true if this Phd has no advisees and false otherwise. */
    public boolean hasNoAdvisees() {
        return advisees == 0;
    }

    /** = "p is not null and this person got the Phd before p. */
    public boolean gotBefore(Phd p) {
        assert p != null;
        return year < p.year || year == p.year && month < p.month;
    }

    /** = "this person and p are intellectual siblings."Precondition: p is not null. */
    public boolean areSibs(Phd p) {
        assert p != null;
        return this != p && (advisor1 == p.advisor1() && advisor1 != null ||
            advisor1 == p.advisor2() && advisor1 != null ||
            advisor2 == p.advisor1() && advisor2 != null ||
            advisor2 == p.advisor2() && advisor2 != null);

    }
}