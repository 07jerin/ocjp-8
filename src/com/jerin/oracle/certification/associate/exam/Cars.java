package com.jerin.oracle.certification.associate.exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;

public class Cars {
	public static void main(String[] args) {
//		System.out.println("Here");
//		A.drive();
		
//		Vacation.main();
		
//		System.out.println(DaysOff.valueOf("PresidentsDay").name());
		
//		 Supplier s = String::new;
//		 List list = new ArrayList<String>();
//		 list.add("Monday");
//		 list.add(s);
//		 list.add("Tuesday");
//		 list.remove(0);
//		 System.out.println(list.get(0));		
		
		
//		TreeSet<Integer> hs = new TreeSet<Integer>();
//		hs.add(null);
//		
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(null);
		
		
	}
}

class A {
	static {
		System.out.println("static");
	}

	public static void drive() {
		System.out.println("fast");
	}

}

enum DaysOff {
	Thanksgiving, PresidentsDay, ValentinesDay;
	
	DaysOff() {
		System.out.println(this.name());
	}
}

class Vacation {
	public static void main() {
		final DaysOff input = DaysOff.ValentinesDay;
		switch (input) {
		default:
			System.out.println("3");
		case ValentinesDay:
			System.out.print("1");
		case PresidentsDay:
			System.out.print("2");
		}
	}
}


interface Edible { void eat(); }
class ApplePicking {
   public static void main(String[] food) {
      Edible apple = new Edible() {
         @Override
         public void eat() {
            System.out.print("Yummy!");
         }
      };
   }
}


 class Penguin {
	   private int volume = 1;
	   private static class Chick {
	      private static final int volume = 3;
	      void chick() {
	         System.out.print("Honk");
	      }
	   }
	   public static void main(String... eggs) {
	      Penguin pen = new Penguin();
	      final Penguin.Chick littleOne = new Penguin.Chick();
	      littleOne.chick();
	   }
	}
 
 abstract interface CanSwim {
	   public void swim();
	}
 
 final class Bottle {
	   final private int size = 14;
	   final Insert insert = new Insert();
	   final protected class Insert {
	      private final int size = 25;
	      public final int getSize() {
	         return Bottle.this.size;
	      }
	   }
	   final public static void main(String[] feed) {
	      System.out.print(new Bottle().insert.getSize());
	   }
	}
 
 
 interface Toy { String play(); }
  class Gift {
    public static void main(String[] matrix) {
       abstract class Robot {}
       class Transformer extends Robot implements Toy {
          public String name = "GiantRobot";
          public String play() {return "DinosaurRobot";}
       }
       Transformer prime = new Transformer () {
          public String play() {return name;}  // y1
       };
       System.out.print(prime.play()+" "+prime.name);
    }
 }
  
   class Ready {
	   protected static int first = 2;
	   private final short DEFAULT_VALUE = 10;
	   private static class GetSet {
	      int first = 5;
//	      static int second = DEFAULT_VALUE;
	   }
	   private GetSet go = new GetSet();
	   public static void main(String[] begin) {
	      Ready r = new Ready();
	      System.out.print(r.go.first);
//	      System.out.print(", "+r.go.second);
	   }
	}
   
   
   class News<Object> {}
   
   
   class Magazine {
	   private String name;
	   public Magazine(String name) {
	      this.name = name;
	   }
	   public int compareTo(Magazine m) {
	      return name.compareTo(m.name);
	   }
	   public String toString() {
	      return name;
	   }
	}
	class Newstand {
	   public static void main(String[] args) {
		   TreeSet<Magazine> set = new TreeSet<>();
	      set.add(new Magazine("highlights"));
	      set.add(new Magazine("Newsweek"));
	      set.add(new Magazine("highlights"));
	      System.out.println(set.iterator().next());
	   }
	}
   
	