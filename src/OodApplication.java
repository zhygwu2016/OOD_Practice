import BuilderDesignPattern.User;
import CallCenterDesign.ServiceCenter;
import Card.Game;
import Card.Player;
import CrossSections.Car;
import CrossSections.CrossSection;
import CrossSections.CrossSectionType;
import CrossSections.IRoad;
import DependencyInjection.Client;
import DependencyInjection.ServiceA;
import DependencyInjection.ServiceB;
import DesignElevator.ElevatorSystem;
import FactoryDesignPattern.DrawClient;
import FactoryDesignPattern.ShapeType;
import HackyDemo.UserInfo;
import HackyDemo.UserInfoRecorder;
import HashMapDesign.MyHashMap;
import InMemoryFileSystem.Directory;
import InMemoryFileSystem.FileSystem;
import InterFaceDemo.Book;
import InterFaceDemo.IReadable;
import InterFaceDemo.NewPaper;
import InterFaceDemo.Person;
import LeetCodeSwapNodeInPair.ListNode;
import LeetCodeSwapNodeInPair.SwapPair;
import ObserverDesignPattern.IStateWatcherA;
import ObserverDesignPattern.IStateWatcherB;
import ObserverDesignPattern.StateChangeObserverable;
import ParkingLotDesign.ParkingGarage;
import Permutation.Permutation;
import SingletonDesignPattern.Singleton;
import SnakeGame.Board;
import SnakeGame.Direction;
import SnakeGame.Snake;
import StaticDemo.StateDemo;
import Subset.Subset;
import VotingSystem.Candidate;
import VotingSystem.VoteSystem;
import WrapperDesignPattern.PeekingIterator;

import java.util.Iterator;
import java.util.List;

import static BuilderDesignPattern.User.Gender.Male;

public class OodApplication {

    public static void main(String[] argus){

        /*
         * Builder Pattern:
         *
         * 1. The builder class is the nested class in the "Contract" class, define as public static class
         *
         * 1.Can simplified the way to create a object with many fields.
         * Especially for class that some fields could be null and other can not be null
         *
         * 2.Builder Design Pattern usually is used in create the "Contract" Object. Contract means define a class
         * with the fields that need to be used by two different micro-services or used by both the front-end and back-end.
         *
         * 3.Those fields in side of the "Contract" usually correspond with Schemas in DataBase in Backend Services.
         */

        final User user1 = new User.UserBuilder("flk","user1")
                                    .withFirstName("Frank")
                                    .withLastName("Fang")
                                    .withGender(Male)
                                    .withCellphoneNumber("408-923-3705")
                                    .withEmail("frankfangflk@gmail.com")
                                    .build();

        final User user2 = new User.UserBuilder("Any","user2")
                                    .withFirstName("Annie")
                                    .withLastName("Xue")
                                    .withGender(User.Gender.Female)
                                    .withCellphoneNumber("123-456-789")
                                    .withEmail("annieXue1@gmail.com")
                                    .build();

        final User user3 = new User("UnKnown","user3");

        user3.copy(user1);

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

        System.out.println(Male.toString());
     //---------------------------------------------------------------------------------
        /*
         * SingletonDesignPattern.Singleton Pattern:
         *
         * 1. SingletonDesignPattern.Singleton pattern is a design pattern that restricts the instantiation of a class to one object.
         * 2.This is useful when exactly one object is needed to coordinate actions across the system.
         * 3.Used in overall service, encryption key.
         */

        final Singleton singleton = Singleton.getSingletonInstance();

     //---------------------------------------------------------------------------------

        /*
         * Factory Pattern:
         *
         * Factory:
         * 1. Factory itself that is used by the client
         * 2. The Enum indicate the limited type of objects that the factory can create
         * 3. The abstract class that has the common fields and abstract method that need to be implement differently according to the child class
         * 4. Different child class that extends from the abstract class.
         *
         * Client: Just used Factory to create the new object
         *
         * The advantage is obvious:
         * 1.New shapes can be added without changing a single line of code in the framework(the client code that uses the shapes from the factory).
         * 2.As it is shown in the next sections, there are certain factory implementations that allow adding new products without even modifying the factory class.
         * 3.Allows client to access a new object without having to know the details of how they’re created.
         */

        final DrawClient drawClient = new DrawClient();

        drawClient.draw(ShapeType.Triangle);
        drawClient.draw(ShapeType.Circle);
        drawClient.draw(ShapeType.Rectangle);
      //---------------------------------------------------------------------------------

        /*
         * Wrapper Design Pattern:
         *
         * 1. Add new fields or methods to an Object without changing the same type of other project;
         * 2. Dynamically bind the values from server/database to a certain kind of object
         */

        PeekingIterator peekingIterator = new PeekingIterator(new Iterator<Integer>() {
            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        });
      //---------------------------------------------------------------------------------

        /*
         * Dependency Injection Design Pattern:
         *
         * 1. If class A need class B to be instanciate correctly, class B is class A's dependency
         * 2. Instead of Instanciate class B in class A, directly parse a Instance of class B into class A
         * that is dependency injection
         */

        Client clientA = new Client(new ServiceA());
        Client clientB = new Client(new ServiceB());

        clientA.requestProcess();
        clientB.requestProcess();
        //---------------------------------------------------------------------------------

        /*
         * Observer Design Pattern:
         *
         * 1. Contains three key element: The observable class, an Observer Interface or abstract class and a class want
         * to listen to the change of observable class
         *
         * 2. Inside of Observerable class, we need:
         * a. A list of Observer
         * b. Methods to registerListeners/deregister observer
         * c. notifyListener()
         *
         * 3.Inside of observer interface/class: onStateChange()
         *
         * 4.Other class need to implement the observer interface/class
         */

        StateChangeObserverable stateChangeObserverable = new StateChangeObserverable(3);

        IStateWatcherA stateWatcherA = new IStateWatcherA();
        IStateWatcherB stateWatcherB = new IStateWatcherB();

        stateChangeObserverable.registerListeners(stateWatcherA);
        stateChangeObserverable.registerListeners(stateWatcherB);

        stateChangeObserverable.setState(5);
        //---------------------------------------------------------------------------------
        /*
         * Card:
         *
         * 1. Basic Classes:  Card, Deck, Game, Player, Suit(Enum)
         * 2. Card: final Suit suit, final int value
         * 3. Deck: final List<Card>,shuffle() method
         * 4. Player: final int id, final String Name
         */

        Player player1 = new Player(1,"Player1");
        Player player2 = new Player(2,"Player2");
        Player player3 = new Player(3,"Player3");

        Game game1 = new Game("FLK_Game_1");

        game1.addPlayer(player1);
        game1.addPlayer(player2);
        game1.addPlayer(player3);

        game1.init();

        //---------------------------------------------------------------------------------

        /*
         * Parking Lot:
         *
         * 1. Enum VehicleType: Bus, Moto, Compact
         * 2. Abstract Method Vehicle, Bus, Moto, Compact extends it
         * 3. Interface ParkingInfo: ParkingSpot, ParkingLevel, ParkingLot implements it.
         * 4. Tree Structure: in ParkingSpot has a parent PakringLevel, ParkingLevel has a parent ParkingLot ......
         */
        ParkingGarage parkingGarage = new ParkingGarage("Flk",7);

        //---------------------------------------------------------------------------------

        /*
         * Elevator:
         *
         * 1. Enum : Direction
         * 2. Class: Elevator, Floor, Elevator System
         * 3. Design Pattern: Observer Design Pattern
         * 4. Interface: ElevatorEventListener, FloorEventListener
         * 5. KeyPoint: how to handle task ?
         *     One Queue ? Up PriorityQueue and Down PriorityQueue -- > trade off, Limit the add floor
         */
        ElevatorSystem elevatorSystem = new ElevatorSystem();

        //---------------------------------------------------------------------------------

        /*
         * In Memory File System:
         *
         * 1. Class : Entry, Directory, File, File System
         * 2. Entry: abstract class, abstract method getSize(), getPath();
         * 3. Directory: getFileNum(), getSize(); --> polymorphism, instanceOf
         */

        FileSystem fileSystem = new FileSystem("System");
        Directory root = fileSystem.getRoot();
        root.mkdir("Personal Information");

        //---------------------------------------------------------------------------------

        /*
         * Service Center:
         *
         * 1. Enum : Rank(Enum), Employee, Call, ServiceCenter(Singleton)
         */
         final ServiceCenter serviceCenter = ServiceCenter.getInstance();
        //---------------------------------------------------------------------------------

        /*
         * Static:
         *
         * 1. Static: No need to instantiated, only one copy, store in heap
         * 2. Static method can only access static data
         * 3. Static method can't directly call non-static method
         * 4. Static class: Builder Design Pattern --> XXXBuilder
         * 5. Static method: Singleton Design pattern, getInstance
         * 5. Static fields:
         *        Good use:  1. Static String as TAG or other Marker
         *                   2. Static Int as Constant
         *                   3. Static Instance as Singleton
         *
         *        Bad use:   1. Static variable without a very good control --> Become "Global variable", need to avoid
         *                   2. Static variable would introduce a Concept called "State"
         *                   3. Majority case, stateless is better.
         *
         * Links:
         *   1. https://softwareengineering.stackexchange.com/questions/284088/why-static-methods-cant-call-non-static-methods-directly?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
         *   2. https://softwareengineering.stackexchange.com/questions/211137/why-can-static-methods-only-use-static-data
         */

        final StateDemo stateDemo1 = new StateDemo();
        stateDemo1.checkState();
        stateDemo1.setState(2);

        final StateDemo stateDemo2 = new StateDemo();
        stateDemo2.checkState();
        //---------------------------------------------------------------------------------

        /*
         * HashMap:
         *
         * 1. Generic Type <K,V>
         * 2. Cell<K,V>
         * 3. The use of method hasCode();
         * 4. MAX_SIZE, LOAD_FACTOR and reHashing();
         */

        MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();

        String[] keys = {"abc", "xyz", "abc", "vv", "x"};
        Integer[] values = {1,10,2,5,null};

        int len  = keys.length;

        System.out.println(myHashMap.get(""));
        System.out.println(myHashMap.get(null));

        for (int i = 0; i < len; i++) {
            myHashMap.put(keys[i], values[i]);
            Integer val = myHashMap.get(keys[i]);
            System.out.println(val);
        }


        System.out.println(myHashMap.get(""));

        for (int i = 0; i < len; i++) {
            System.out.println(myHashMap.get(keys[i]));
        }


        //---------------------------------------------------------------------------------
        final NewPaper p1 = new NewPaper();
        final Book b1 = new Book();

        final IReadable p2 = new NewPaper();
        final IReadable b2 = new Book();

//        p2.getAd();
//        b2.getEdition();

        final Person person = new Person();

        System.out.println(person.read(p1));
        System.out.println(person.read(b1));
        System.out.println(person.read(p2));
        System.out.println(person.read(b2));
        //---------------------------------------------------------------------------------

        /*
         * Cross Section:
         *
         * 1. Class : CrossSectionType(Enum), Car, Road,IRoad(Interface),CrossSection
         * 2. CrossSectionType: 3 way or 4 way
         * 3. Car:
         *        Vin: String
         *        Arrival Time: long
         *        IRoad
         * 4. IRoad: 1.Decouple 2.Increase Scalebility
         * 5. NormalRoad: Queue<Car>
         * 6. CrossSection: List<Road>, PriorityQueue<Car>
         */

        CrossSection crossSection = new CrossSection(CrossSectionType.FourWay.toString(),CrossSectionType.FourWay);

        for(int i = 0; i < 10; i++){
            final Car car = new Car("Car" + i, i + System.currentTimeMillis());

            final IRoad normalRoad = crossSection.getRoad(i % 4);

            car.setRoad(normalRoad);
            normalRoad.add(car);
        }

        while(!crossSection.isEmpty()){
            final Car car = crossSection.passCar();
            if(car != null) System.out.println(car.getVin() + " is Passed");
        }

        //---------------------------------------------------------------------------------

        /*
         *  Design a voting system:
         *   Allow to vote for candidate
         *   Allow get the number of vote for a candidate when given a time
         *   Allow find the top k candidates when give a time
         *
         *   1. Candidate:
         *          Id: String， Unique
         *          Name: Allow same name
         *          List<Ticket>: Do we need to Sort? No, because the ticket is in time order
         *          Implement Comparable: custom compareTo() in reverse order
         *
         *   2. Ticket:
         *          TicketId: String
         *          Candidate info: 1.Candidate Name 2. Candidate Id --> Choose this one since it is unique
         *          Time: long
         *
         *   3. VoteSystem:
         *          1. Candidate: HashSet
         *          2. voteForCandidates()
         *          3. findTopK(): set CompareNumber for Candidate, sort, return top k in the list
         *          4. Singleton(Optional)
         */
        final VoteSystem voteSystem = VoteSystem.getInstance();

        final Candidate Tom = new Candidate("Tom", "Tom123");
        final Candidate Jerry = new Candidate("Jerry", "Jerry123");
        final Candidate Ted = new Candidate("Ted","Ted123");

        voteSystem.addCandidate(Tom);
        voteSystem.addCandidate(Jerry);
        voteSystem.addCandidate(Ted);

        for(int i = 0; i < 6; i++){
            voteSystem.voteForCandidate(Tom,1);
            voteSystem.voteForCandidate(Tom,1);
            voteSystem.voteForCandidate(Jerry, 1);
        }

        for(int i = 0; i < 5; i++){
            voteSystem.voteForCandidate(Tom,2);
            voteSystem.voteForCandidate(Jerry, 2);
        }

        for(int i = 0; i < 4; i++){
            voteSystem.voteForCandidate(Tom,3);
            voteSystem.voteForCandidate(Ted, 3);
            voteSystem.voteForCandidate(Ted, 3);
            voteSystem.voteForCandidate(Ted, 3);
            voteSystem.voteForCandidate(Ted, 3);
        }

        List<Candidate> list1 = voteSystem.findTopK(1,2);
        List<Candidate> list2 = voteSystem.findTopK(2,2);
        List<Candidate> list3 = voteSystem.findTopK(3,3);

        for (Candidate candidate: list1){
            System.out.println(candidate.getName() + " has ticket " + candidate.getTicketNumber(1));
        }

        System.out.println("----------------");

        for (Candidate candidate: list2){
            System.out.println(candidate.getName() + " has ticket " + candidate.getTicketNumber(2));
        }

        System.out.println("----------------");

        for (Candidate candidate: list3){
            System.out.println(candidate.getName() + " has ticket " + candidate.getTicketNumber(3));
        }


        //---------------------------------------------------------------------------------

        /*
         *  SnakeGame:  2D Game --> Coordinate --> int[]{y,x}
         *   1. Snake:
         *          head: int[]
         *          tail: int[]
         *          body: a collection of int[] --> (Set? List? PriorityQueue?) Queue
         *          Move: Change of body --> change of Head and tail --> head + direction, body pop
         *          Eat: Head + direction, not pop tail
         *          Dead: head + direction = non-food and non-empty
         *          EventListener(Optional): Board needs to know snake dead
         *
         *   2. Board:
         *            Matrix --> Character[][]
         *            Wall,Snake Body, Food
         *
         *   3. Direction:
         *          how ? --> coordinnate --> y,x
         *          Limited number of directions: Enum
         *          enum: String + int[]
         *
         *   4. Game:
         *          Board
         *          Snake
         *          init()
         *
         *
         *   5. Constants(optional):
         *         WallChar
         *         SnakeChar
         *         FoodChar
         */

        System.out.println(" ");

        final Board board = new Board("Board1",7,7);

        final Snake snake = new Snake("Snake1");

        final SnakeGame.Game game = new SnakeGame.Game(board,snake);


        board.setFood(1,2);
        board.setFood(2,2);
        board.setFood(3,2);

        game.printBoard();

        System.out.println("-------------------------- ");

        snake.move(Direction.Right);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Down);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Down);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Right);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Right);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Right);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();

        snake.move(Direction.Down);
        System.out.println("The Snake size is: " + snake.size());
        game.printBoard();


        for (int i = 0; i < 5; i++){
            snake.move(Direction.Left);
            System.out.println("The Snake size is: " + snake.size());
            game.printBoard();
        }

        //---------------------------------------------------------------------------------

        Subset subset = new Subset();

        subset.subSet(new int[]{1,2,3});

        Permutation permutation = new Permutation();

        permutation.permute(new int[]{1,2,3});

        //---------------------------------------------------------------------------------

        final UserInfo userInfo = new UserInfo("Zizuo", "Liu","3375 Scott Blvd, 123-456-789");
        final UserInfoRecorder userInfoRecorder = new UserInfoRecorder();
        userInfoRecorder.setUserInfo(userInfo);

        System.out.println(userInfoRecorder.getCellphoneNum());


        SwapPair swapPair = new SwapPair();

        ListNode head = new ListNode(1);
        ListNode pointer = head;

        for(int i = 2; i < 5; i++){
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }

        swapPair.swapPairs(head);
    }

}
