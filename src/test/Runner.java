package test;

import logic.BinaryTree;
import logic.Dish;

public class Runner {
    public static void main(String[] args) {
        BinaryTree<Integer> nums = new BinaryTree<>(((o1, o2) -> Integer.compare(o1,o2)));
        nums.addNode( 50 );
        nums.addNode( 10 );
        nums.addNode( 69 );
        nums.addNode( 5 );
        nums.addNode( 57 );
        nums.addNode( 34 );
        nums.addNode( 18 );
        nums.addNode( 40 );
        nums.addNode( 63 );
        nums.addNode( 45 );
        nums.addNode( 42 );
        nums.addNode( 47 );
        nums.addNode( 80 );

        System.out.println( nums.listPresort());

        //System.out.println(nums.listInsort( ));

        //System.out.println( nums.listPosort( ) );

        BinaryTree<Dish> bts = new BinaryTree<>(((o1, o2) -> Integer.compare( o1.getCalories(),o2.getCalories())));

        bts.addNode( new Dish("50","Carne",450,false,45_000));
        bts.addNode( new Dish("70","Pescado",300,false,54_000));
        bts.addNode( new Dish("30","Fruta",50,true,20_000));
        bts.addNode( new Dish("60","Pollo",340,false,145_000));
        bts.addNode( new Dish("80","Pasta",100,true,45_000));

        System.out.println( bts.listPresort());

        System.out.println("**********EN AMPLITUD*************");
        //nums.lisAmplitudeDown().forEach( System.out::println );
        System.out.println( nums.lisAmplitudeDown());
    }
}
