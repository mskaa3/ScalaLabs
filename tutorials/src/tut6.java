public class tut6{
        static boolean isEqual1(int m, int n){
            return m == n;
        }
        static boolean isEqual2(Integer m, Integer n){
            return m == n;
        }
//    static boolean isEqual3(Integer m, Integer n){
//        return m.equals(n) ;
//    }
        public static void main(String[] args){
            System.out.println(isEqual1(250,250));
            System.out.println(isEqual2(250,250));
           // System.out.println(isEqual3(250,250));
            //type int is a primitive type, while Integer is a wrapper class for int type
            //when we use == for Integer then java doesnt compare them by the value but by the reference,
            //which means, that even though they have same value, they are two different objects and the returning value
            //will be false. Can be fixed with usage of equals

            //task4
            System.out.println("-------------------------------------------------");
            String s1 = "foo";
            String s2 = "foo";
            String s3 = new String("foo");
            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));
            System.out.println(s1 == s3);
            System.out.println(s1.equals(s3));
            //== is and operator for reference comparison (address) and equals method for the content .
            //== checks if both objects point to the same memory but equals compare the values in the objects.
            //
        }

    }

