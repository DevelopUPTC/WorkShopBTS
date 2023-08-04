package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Integer> bt;
    private BinaryTree<Dish> bts;

    void setup(){
        bt = new BinaryTree<>( (n1,n2) -> Integer.compare( n1,n2) );
        bt.addNode( 50 );
        bt.addNode( 10 );
        bt.addNode( 69 );
        bt.addNode( 5 );
        bt.addNode( 57 );
        bt.addNode( 34 );
        bt.addNode( 18 );
        bt.addNode( 40 );
        bt.addNode( 63 );
        bt.addNode( 45 );
        bt.addNode( 42 );
        bt.addNode( 47 );
        bt.addNode( 80 );
        bt.addNode( 12 );
        bt.addNode( 25 );
        bt.addNode( 15 );
        bt.addNode( 17 );
    }

    void setupTwo(){
        bts = new BinaryTree<>( (d1,d2) -> d1.getId().compareTo( d2.getId()));
        bts.addNode(new Dish("1010","Empanada",80, false, 28000));
    }

    @Test
    void findNode() {
        setup();
        assertNotNull( bt.findNode(25) );
        assertNotNull( bt.findNode(50) );
        assertNotNull( bt.findNode(10) );
        assertNotNull( bt.findNode(80) );
        assertNotNull( bt.findNode(12) );
        assertNull( bt.findNode( 90 ) );
        assertNull( bt.findNode( 53 ) );
        assertNull( bt.findNode( 1 ) );
        assertEquals( 50, bt.findNode( 50 ).getInfo());

        setupTwo();
        assertNotNull( bts.findNode( new Dish("1010",null,0,false,0.0) ));
        assertNull( bts.findNode( new Dish("101020",null,0,false,0.0) ));
        assertEquals("Empanda",bts.findNode( new Dish("101020",null,0,false,0.0) ).getInfo().getName());

    }

    @Test
    void heightTree() {
        setup();
        assertEquals(6, bt.heightTree());

        setupTwo();
        assertEquals(0, bts.heightTree());
    }

    @Test
    void heightNode() {
        setup();
        assertEquals( 3, bt.heightNode( bt.findNode(18)));
        assertEquals( 0, bt.heightNode( bt.findNode(80)));
        assertEquals( 5, bt.heightNode( bt.findNode(10)));
        assertEquals( 1, bt.heightNode( bt.findNode(57)));
        assertEquals( 2, bt.heightNode( bt.findNode(40)));
        assertEquals( 2, bt.heightNode( bt.findNode(69)));
    }

    @Test
    void weightTree() {
        setup();
        assertEquals(6, bt.heightTree());

        setupTwo();
        assertEquals(0, bts.heightTree());
    }

    @Test
    void levelNode() {
        setup();
        assertEquals(0, bt.levelNode( bt.findNode( 50 ) ) );
        assertEquals(6, bt.levelNode( bt.findNode( 17 ) ) );
        assertEquals(3, bt.levelNode( bt.findNode( 40 ) ) );
        assertEquals(1, bt.levelNode( bt.findNode( 10 ) ) );
        assertEquals(4, bt.levelNode( bt.findNode( 25 ) ) );
        assertEquals(2, bt.levelNode( bt.findNode( 34 ) ) );
    }

    @Test
    void isLeaf() {
        setup();
        assertTrue( bt.isLeaf( bt.findNode(17)));
        assertTrue( bt.isLeaf( bt.findNode(42)));
        assertTrue( bt.isLeaf( bt.findNode(47)));
        assertTrue( bt.isLeaf( bt.findNode(80)));
        assertTrue( bt.isLeaf( bt.findNode(5)));
        assertFalse( bt.isLeaf( bt.findNode(50)));
        assertFalse( bt.isLeaf( bt.findNode(12)));
        assertFalse( bt.isLeaf( bt.findNode(45)));
        assertFalse( bt.isLeaf( bt.findNode(34)));
        assertFalse( bt.isLeaf( bt.findNode(57)));
        assertFalse( bt.isLeaf( bt.findNode(69)));
        assertFalse( bt.isLeaf( bt.findNode(40)));
    }

    @Test
    void gradeNode() {
        setup();
        assertEquals(2,bt.gradeNode( bt.findNode(50)));
        assertEquals(2,bt.gradeNode( bt.findNode(45)));
        assertEquals(2,bt.gradeNode( bt.findNode(10)));
        assertEquals(2,bt.gradeNode( bt.findNode(34)));
        assertEquals(2,bt.gradeNode( bt.findNode(18)));

        assertEquals(1,bt.gradeNode( bt.findNode(12)));
        assertEquals(1,bt.gradeNode( bt.findNode(15)));
        assertEquals(1,bt.gradeNode( bt.findNode(57)));

        assertEquals(0,bt.gradeNode( bt.findNode(17)));
        assertEquals(0,bt.gradeNode( bt.findNode(42)));
        assertEquals(0,bt.gradeNode( bt.findNode(47)));
        assertEquals(0,bt.gradeNode( bt.findNode(5)));
        assertEquals(0,bt.gradeNode( bt.findNode(80)));
        assertEquals(0,bt.gradeNode( bt.findNode(63)));
        assertEquals(0,bt.gradeNode( bt.findNode(25)));
    }

    @Test
    void findFather() {
        setup();
        assertNotNull( bt.findFather( bt.findNode(15)));
        assertEquals(12,bt.findFather( bt.findNode(15)).getInfo());

        assertNull( bt.findFather( bt.findNode(50)));

        assertNotNull( bt.findFather( bt.findNode(63)));
        assertEquals(57,bt.findFather( bt.findNode(63)).getInfo());
    }

    @Test
    void deleteNode() {
        setup();
        //Valido el grado del nodo padre del nodo a eliminar
        assertEquals(2,bt.gradeNode( bt.findNode(45)));
        assertEquals(42, bt.deleteNode( bt.findNode( 42 ) ) );
        assertNull(bt.findNode(42));
        //El grado del nodo padre cambia a 1
        assertEquals(1,bt.gradeNode( bt.findNode(45)));

        //Para eliminar el nodo 57, el 63 sube un nivel (3, 1), el padre del 63 cambia al 69
        assertEquals(3,bt.levelNode( bt.findNode(63)));
        assertEquals(57, bt.deleteNode( bt.findNode( 57 ) ) );
        assertNull(bt.findNode(57));
        assertEquals(2,bt.levelNode( bt.findNode(63)));
        assertEquals(69,bt.findFather( bt.findNode(63)).getInfo());

        //Para eliminar el 10, el nodo sustituto es 12
        //El 12 pasa de nivel 3 al 1
        //El padre del quince, que ara 12, ahora es 18
        //El padre del 12 que era 18, ahora es 50
        //Eñ grado del 12 pasa de 1 a 2
    }
}