package useenum;

import java.util.*;

class Course {
  private String name;
  private Course(String n) {
    name = n;
  }
  private static Map<String, Course> known = new HashMap<>();
  static {
    List<String> ls = Arrays.asList("MATH", "PHYSICS");
    for (String s : ls) {
      known.put(s, create(s));
    }
  };

  private static Course create(String s) {
    return new Course(s);
  }

  public static Course get(String name) {
    Course rv = known.get(name);
    if (rv == null) throw new IllegalArgumentException("No such value " + name);
    return rv;
  }
}
public class TryAnEnum {
  public static void main(String[] args) {
    Course c = Course.get("MATH");
    Course c1 = Course.get("MATH");
    System.out.println("c == c1? " + (c == c1));
  }
}
