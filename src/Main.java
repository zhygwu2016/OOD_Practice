import CrossSections.Car;
import CrossSections.CrossSection;
import CrossSections.CrossSectionType;
import CrossSections.IRoad;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Main {

    public static void main(String[] argus){

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


    }
}
